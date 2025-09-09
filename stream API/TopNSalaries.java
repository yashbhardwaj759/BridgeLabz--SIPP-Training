import java.util.*;
import java.util.stream.*;

public class TopNSalaries {
    public static void main(String[] args) {
        List<Integer> salaries = Arrays.asList(60000, 75000, 50000, 80000, 70000);

        List<Integer> top3 = salaries.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(top3);
    }
}