package com.bank;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    public void testVoidMethod() {
        EmailService mockEmail = Mockito.mock(EmailService.class);
        doNothing().when(mockEmail).sendEmail(anyString(), anyString());

        NotificationService service = new NotificationService(mockEmail);
        service.sendNotification("test@bank.com", "Welcome!");

        verify(mockEmail).sendEmail("test@bank.com", "Welcome!");
    }
}
