package school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    public String name;
    public List<Integer> quizzes;

    public Student(String name) {
        this.name = name;
        quizzes = new ArrayList<>(Collections.nCopies(15, 0)); // Initialize quiz scores with zeros
    }
}