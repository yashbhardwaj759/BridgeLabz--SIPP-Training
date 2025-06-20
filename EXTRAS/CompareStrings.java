public class CompareStrings {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        int minLen = Math.min(str1.length(), str2.length());
        int cmp = 0;
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cmp = str1.charAt(i) - str2.charAt(i);
                break;
            }
        }
        if (cmp == 0) {
            cmp = str1.length() - str2.length();
        }
        if (cmp < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (cmp > 0) {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
    }
} 