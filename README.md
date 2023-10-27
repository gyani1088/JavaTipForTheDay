# JavaTipForTheDay

This program will fetch a java tip for the day and send the recipient an email with the same.

This uses Google's Palm API to generate the data.

Please pass environment variables for the following:
1. app password for sender's google account
2. recipient name
3. PALM_API_KEY

In the application.properties file. kindly change the following properties:
spring.mail.username=<GMAIL_ID>
cron.expression=0 0 9 * * ?

cron.expression will set the time for 9am every day to get the message once the app server starts.
