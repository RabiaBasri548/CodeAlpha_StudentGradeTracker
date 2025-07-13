import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int n;
        while (true) {
            System.out.print("Enter number of students: ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("Number must be greater than 0.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();

            double grade;
            while (true) {
                System.out.print("Enter grade for " + name + " (0–100): ");
                try {
                    grade = Double.parseDouble(sc.nextLine());
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter a valid grade.");
                }
            }

            students.add(new Student(name, grade));
        }

        double total = 0, max = -1, min = 101;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            total += s.grade;
            if (s.grade > max) {
                max = s.grade;
                topStudent = s.name;
            }
            if (s.grade < min) {
                min = s.grade;
                lowStudent = s.name;
            }
        }

        System.out.println("\n------ Grade Summary ------");
        System.out.printf("Average Grade: %.2f\n", total / n);
        System.out.printf("Highest Grade: %.2f by %s\n", max, topStudent);
        System.out.printf("Lowest Grade: %.2f by %s\n", min, lowStudent);

        System.out.println("\n------ Student List ------");
        for (Student s : students) {
            System.out.printf("%s: %.2f\n", s.name, s.grade);
        }

        sc.close();
    }
}
