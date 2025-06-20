public class ToggleCase {
    public static void main(String[] args) {
        String input = "Hello World!";
        StringBuilder toggled = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) {
                toggled.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                toggled.append(Character.toUpperCase(ch));
            } else {
                toggled.append(ch);
            }
        }
        System.out.println("Toggled String: " + toggled.toString());
    }
} 