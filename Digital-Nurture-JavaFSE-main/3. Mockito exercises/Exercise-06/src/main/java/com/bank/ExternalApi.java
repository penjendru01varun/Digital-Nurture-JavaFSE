package com.bank;

public interface ExternalApi {
    void connect();
    String getData();
    void disconnect();
}
