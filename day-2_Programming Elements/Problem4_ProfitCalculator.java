public class Problem4_ProfitCalculator {
    public static void main(String[] args) {
        // Cost and selling prices
        int costPrice = 129;
        int sellingPrice = 191;
        
        // Calculate profit and profit percentage
        int profit = sellingPrice - costPrice;
        double profitPercentage = (profit * 100.0) / costPrice;
        
        // Display results using a single print statement
        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + 
                         "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage + "%");
    }
} 