package com.task.management.api.service.impl;

import com.task.management.api.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(String email, String newPassword) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom("abb-innovation@gmail.com", "ABB Innovation");
            helper.setTo(email);
            String subject = "Request for password reset";
            helper.setSubject(subject);
            String content = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
                    "\n" +
                    "<head>\n" +
                    "  <meta charset=\"UTF-8\">\n" +
                    "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "  <title>Document</title>\n" +
                    "  <style>\n" +
                    "    table,\n" +
                    "    tr,\n" +
                    "    td {\n" +
                    "      border: 0.5px solid rgba(0, 0, 0, 0.06);\n" +
                    "      border-collapse: collapse;\n" +
                    "      font-family: Arial;\n" +
                    "    }\n" +
                    "    body{\n" +
                    "      padding: 0;\n" +
                    "      margin: 0;\n" +
                    "    }\n" +
                    "\n" +
                    "    ul {\n" +
                    "      background-color: #F5F8FF;\n" +
                    "      padding: 32px;\n" +
                    "      margin: 0 48px 48px;\n" +
                    "    }\n" +
                    "    ul li {display: inline-block;\n" +
                    "      padding-right: 24px;}\n" +
                    "    ul li a {display: block}\n" +
                    "    ul li a img {width: 100%;}\n" +
                    "  </style>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "<h5 style=\"margin: 48px 48px 0; font-family: Arial; color: #171923; font-weight: bold; " +
                    "font-size: 20px;\n" +
                    "margin-bottom: 36px;\">Hello!</h5>\n" +
                    "<h5 style=\"margin: 0 48px; font-family: Arial; color: #171923; font-weight: normal; font-size: " +
                    "16px; line-height:\n" +
                    "     24px; margin-bottom: 36px;\"><b>You have requested password reset. \n Your new " +
                    "password is generated below:" + "<br>Password: " + newPassword + "\n" +
                    "</body>\n" +
                    "</html>";
            helper.setText(content, true);
            mailSender.send(message);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}



