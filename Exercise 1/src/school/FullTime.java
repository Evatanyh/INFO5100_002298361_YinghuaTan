package school;

public class FullTime extends Student {
    public int[] examScores;

    public FullTime(String name) {
        super(name);
        examScores = new int[2]; // Initialize exam scores with zeros
    }
}