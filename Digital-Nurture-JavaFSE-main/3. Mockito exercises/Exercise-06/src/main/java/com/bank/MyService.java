package com.bank;

public class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        api.connect();
        String data = api.getData();
        api.disconnect();
        return data;
    }
}
