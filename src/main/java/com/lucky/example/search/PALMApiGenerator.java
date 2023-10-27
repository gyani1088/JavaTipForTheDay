package com.lucky.example.search;

import com.google.ai.generativelanguage.v1beta3.GenerateTextRequest;
import com.google.ai.generativelanguage.v1beta3.TextPrompt;
import org.springframework.stereotype.Component;

@Component
public class PALMApiGenerator {
    public TextPrompt createPrompt(String prompt){
        return TextPrompt.newBuilder()
                .setText(prompt)
                .build();
    }

    public GenerateTextRequest request(TextPrompt prompt){
        GenerateTextRequest request = GenerateTextRequest.newBuilder()
                .setModel("models/text-bison-001") // Required, which model to use to generate the result
                .setPrompt(prompt)
                .setTemperature(0.5f) // Optional, controls the randomness of the output
                .setCandidateCount(1) // Optional, the number of generated texts to return
                .build();
        return request;
    }
}
