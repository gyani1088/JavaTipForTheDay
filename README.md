# JavaTipForTheDay

This program will fetch a java tip for the day and send the recipient an email with the same.

This uses Google's Palm API to generate the data.

Pass environment variables for the following:
1. app password for sender's google account -----> spring.mail.password
2. recipient name ----> mail.recipient
3. API key of PALM LLM API ------> PALM_API_KEY

Use the following command in the jar directory to set the environment variables:
java -jar -Dspring.mail.password=<<password>> -DPALM_API_KEY=<<Palm_Api_Key>> -Drecipient.name=<<name>> <<jar_name>>

In the application.properties file. kindly change the following properties:
spring.mail.username=<GMAIL_ID>
cron.expression=0 0 9 * * ?

cron.expression will set the time for 9am every day to get the message once the app server starts.
