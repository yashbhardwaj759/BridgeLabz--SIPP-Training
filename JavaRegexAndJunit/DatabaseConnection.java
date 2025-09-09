package com.junit.examples;

public class DatabaseConnection {
    private boolean connected = false;
    
    public void connect() {
        System.out.println("Connecting to database...");
        connected = true;
    }
    
    public void disconnect() {
        System.out.println("Disconnecting from database...");
        connected = false;
    }
    
    public boolean isConnected() {
        return connected;
    }
}