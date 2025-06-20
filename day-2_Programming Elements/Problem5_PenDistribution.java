public class Problem5_PenDistribution {
    public static void main(String[] args) {
        // Total pens and number of students
        int totalPens = 14;
        int numberOfStudents = 3;
        
        // Calculate pens per student and remaining pens
        int pensPerStudent = totalPens / numberOfStudents;
        int remainingPens = totalPens % numberOfStudents;
        
        // Display the result
        System.out.println("The Pen Per Student is " + pensPerStudent + 
                         " and the remaining pen not distributed is " + remainingPens);
    }
} 