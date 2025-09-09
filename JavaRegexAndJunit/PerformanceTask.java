package com.junit.examples;

public class PerformanceTask {
    
    public String longRunningTask() {
        try {
            Thread.sleep(1500); // Sleep for 1.5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Task interrupted";
        }
        return "Task completed successfully";
    }
    
    public String quickTask() {
        try {
            Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Task interrupted";
        }
        return "Quick task completed";
    }
}