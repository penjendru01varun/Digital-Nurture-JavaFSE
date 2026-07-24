package com.bank;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testArgumentMatchers() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getDataById(anyInt())).thenReturn("Data for ID");
        when(mockApi.getDataById(100)).thenReturn("Specific Data");

        MyService service = new MyService(mockApi);

        String result1 = service.fetchDataById(50);
        String result2 = service.fetchDataById(100);

        assertEquals("Data for ID", result1);
        assertEquals("Specific Data", result2);

        verify(mockApi).getDataById(eq(50));
        verify(mockApi).getDataById(eq(100));
    }
}
