package school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Session {
    public List<Student> students;

    public Session() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void averageQuizScores() {
        for (Student student : students) {
            int sum = student.quizzes.stream().mapToInt(Integer::intValue).sum();
            double avgScore = (double) sum / student.quizzes.size();
            System.out.println(student.name + "'s average score is  " + avgScore);
        }
    }

    public void printSortedQuizScores() {
        List<Integer> allQuizScores = new ArrayList<>();
        for (Student student : students) {
            allQuizScores.addAll(student.quizzes);
        }
        Collections.sort(allQuizScores);
        System.out.println("Quiz Scores in Ascending Order:");
        System.out.println(allQuizScores);
    }

    public void printPartTimeStudents() {
        System.out.println("Part-Time Students:");
        for (Student student : students) {
            if (student instanceof PartTime) {
                System.out.println(student.name);
            }
        }
    }

    public void printFullTimeExamScores() {
        System.out.println("Full-Time Student Exam Scores:");
        for (Student student : students) {
            if (student instanceof FullTime) {
                FullTime fullTimeStudent = (FullTime) student;
                System.out.println(fullTimeStudent.name + ": " + fullTimeStudent.examScores[0] + ", " + fullTimeStudent.examScores[1]);
            }
        }
    }
}