import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Define subject strings
        String[] subjectStrings = {
                "apple123",
                "12345",
                "hello_world",
                "example@email.com",
                "https://www.example.com",
                "Java is fun!"
        };

        // Define regular expression patterns
        String[] patterns = {
                "\\w+",         // Matches one or more word characters
                "\\d+",         // Matches one or more digits
                "\\w+_\\w+",    // Matches strings with underscore
                "\\b\\w+@\\w+\\.\\w+\\b",  // Matches email addresses
                "^https?://.*", // Matches URLs starting with http:// or https://
                "\\bJava\\b"    // Matches the word "Java" as a whole word
        };

        // Test regular expressions against subject strings
        for (String pattern : patterns) {
            System.out.println("Pattern: " + pattern);
            Pattern p = Pattern.compile(pattern);
            for (String subject : subjectStrings) {
                Matcher m = p.matcher(subject);
                if (m.find()) {
                    System.out.println("Positive match: " + subject);
                } else {
                    System.out.println("Negative match: " + subject);
                }
            }
            System.out.println();
        }
    }
}
