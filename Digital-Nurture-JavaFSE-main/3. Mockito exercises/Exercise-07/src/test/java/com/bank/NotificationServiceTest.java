package com.bank;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        EmailService mockEmail = Mockito.mock(EmailService.class);
        doThrow(new RuntimeException("SMTP server unavailable"))
            .when(mockEmail).sendEmail(anyString(), anyString());

        NotificationService service = new NotificationService(mockEmail);

        assertThrows(RuntimeException.class, () -> {
            service.sendNotification("test@bank.com", "Hello");
        });

        verify(mockEmail).sendEmail("test@bank.com", "Hello");
    }
}
