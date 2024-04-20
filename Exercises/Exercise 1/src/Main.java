
import school.Student;
import school.FullTime;
import school.PartTime;
import school.Session;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Session session = new Session();
        Random random = new Random();

        // Populate session with 20 students
        for (int i = 1; i <= 10; i++) {
            session.addStudent(new PartTime(generateName()));
            FullTime fullTimeStudent = new FullTime(generateName());
            fullTimeStudent.examScores[0] = random.nextInt(41) + 60; // Random exam scores between 60 and 100
            fullTimeStudent.examScores[1] = random.nextInt(41) + 60;
            session.addStudent(fullTimeStudent);
        }

        // Dummy scores for all students
        for (Student student : session.students) {
            for (int j = 0; j < 15; j++) {
                student.quizzes.set(j, random.nextInt(11)); // Random quiz scores between 0 and 10
            }
        }

        // Call public methods and capture output
        session.averageQuizScores();
        session.printSortedQuizScores();
        session.printPartTimeStudents();
        session.printFullTimeExamScores();
    }

    private static String generateName() {
        String[] prefixes = {"John", "Alice", "David", "Emma", "Michael", "Sophia", "Daniel", "Olivia", "Matthew", "Ava"};
        String[] suffixes = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
        Random random = new Random();
        String prefix = prefixes[random.nextInt(prefixes.length)];
        String suffix = suffixes[random.nextInt(suffixes.length)];
        return prefix + " " + suffix;
    }
}