package com.junit.examples;

import java.util.regex.Pattern;

public class PasswordValidator {
    
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        
        // At least 6 characters, one uppercase, one digit
        String regex = "^(?=.*[A-Z])(?=.*\\d).{6,}$";
        return Pattern.matches(regex, password);
    }
    
    public String getValidationMessage(String password) {
        if (password == null || password.length() < 6) {
            return "Password must be at least 6 characters long";
        }
        if (!password.matches(".*[A-Z].*")) {
            return "Password must contain at least one uppercase letter";
        }
        if (!password.matches(".*\\d.*")) {
            return "Password must contain at least one digit";
        }
        return "Password is valid";
    }
}
