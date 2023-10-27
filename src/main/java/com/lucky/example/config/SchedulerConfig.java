package com.lucky.example.config;

import com.google.ai.generativelanguage.v1beta3.*;
import com.lucky.example.mailsender.EmailServiceImpl;
import com.lucky.example.search.PALMApiGenerator;
import com.lucky.example.search.SearchGoogle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    SearchGoogle searchGoogle;

    @Autowired
    TextServiceClient pALMApiClient;

    @Autowired
    PALMApiGenerator pALMApiGenerator;

    @Autowired
    Environment env;

    @Autowired
    EmailServiceImpl emailService;

    //cron expressions
    //start of every minute: 0 0/1 * * * ?
    //start of every second: 0/1 * * * * ?
    //start of every day 9 am: 0 0 9 * * ?

    @Scheduled(cron = "${cron.expression}")
    public void scheduleTaskUsingCronExpression() {

        String prompt = "Provide me a Java programming tip for the day.";
        TextPrompt textPrompt = pALMApiGenerator.createPrompt(prompt);
        GenerateTextRequest request = pALMApiGenerator.request(textPrompt);
        GenerateTextResponse response = pALMApiClient.generateText(request);
        TextCompletion returnedText = response.getCandidatesList().get(0);
//        System.out.println(returnedText.getOutput());

        String recipient = env.getProperty("mail.recipient");
        //TODO: send the response as a body to an email
        emailService.sendSimpleMessage(recipient,"Java Tip For The Day",returnedText.getOutput());

    }


}
