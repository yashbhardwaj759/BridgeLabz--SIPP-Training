public class core {
    public static void main(String[] args) {
        // Problem 1: Harry's Age
        int birthYear = 2000;
        int currentYear = 2024;
        int harryAge = currentYear - birthYear;
        System.out.println("Harry's age in 2024 is " + harryAge);

        // Problem 2: Sam's PCM Average
        int mathMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;
        double averageMarks = (mathMarks + physicsMarks + chemistryMarks) / 3.0;
        System.out.println("Sam's average mark in PCM is " + averageMarks);

        // Problem 3: Kilometer to Miles Conversion
        double kilometers = 10.8;
        double miles = kilometers / 1.6;
        System.out.println("The distance " + kilometers + " km in miles is " + miles);

        // Problem 4: Profit and Loss Calculation
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profitPercentage = (profit * 100.0) / costPrice;
        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice);
        System.out.println("The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage + "%");

        // Problem 5: Pen Distribution
        int totalPens = 14;
        int numberOfStudents = 3;
        int pensPerStudent = totalPens / numberOfStudents;
        int remainingPens = totalPens % numberOfStudents;
        System.out.println("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is " + remainingPens);
    }
} 