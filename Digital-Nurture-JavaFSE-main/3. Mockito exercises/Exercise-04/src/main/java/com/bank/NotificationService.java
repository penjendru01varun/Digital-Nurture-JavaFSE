package com.bank;

public class NotificationService {

    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendNotification(String email, String msg) {
        emailService.sendEmail(email, msg);
    }
}
