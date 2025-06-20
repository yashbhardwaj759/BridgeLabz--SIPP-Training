public class ReplaceWord {
    public static void main(String[] args) {
        String sentence = "Java is fun. Java is powerful.";
        String oldWord = "Java";
        String newWord = "Python";
        String result = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified Sentence: " + result);
    }
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                sb.append(newWord);
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
} 