import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Validate number of subjects
        if (numberOfSubjects <= 0) {
            System.out.println("Invalid number of subjects. Exiting...");
            scanner.close();
            return;
        }

        // Array to store marks and variable to calculate total marks
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            int mark = scanner.nextInt();
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark. Please enter marks between 0 and 100.");
                i--; // Retry the current subject
            } else {
                marks[i] = mark;
                totalMarks += mark;
            }
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determine grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        // Close scanner
        scanner.close();
    }
}
