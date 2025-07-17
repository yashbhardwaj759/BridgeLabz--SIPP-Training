public class PalindromeChecker {
    private String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String cleanText = text.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = cleanText.length() - 1;
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Is Palindrome: " + (isPalindrome() ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker("A man, a plan, a canal: Panama");
        checker.displayResult();
    }
}