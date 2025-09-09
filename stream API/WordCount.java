import java.util.*;
import java.util.stream.*;

public class WordCount {
    public static void main(String[] args) {
        String sentence = "java stream api makes coding easier java java";

        Map<String, Long> wordFreq = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(wordFreq);
    }
}