// Abstract base class
abstract class Course {
    private String courseCode;   // encapsulated field
    private int credits;

    // Constructor
    public Course(String courseCode, int credits) throws Exception {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new Exception("Invalid Course Code!");
        }
        if (credits <= 0) {
            throw new Exception("Credits must be greater than 0!");
        }
        this.courseCode = courseCode;
        this.credits = credits;
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }

    // Abstract method (to be implemented by subclasses)
    public abstract int calculateWorkload();
}

// Subclass: TheoryCourse
class TheoryCourse extends Course {
    public TheoryCourse(String courseCode, int credits) throws Exception {
        super(courseCode, credits);
    }

    @Override
    public int calculateWorkload() {
        // Workload = credits * 3 hours
        return getCredits() * 3;
    }
}

// Subclass: LabCourse
class LabCourse extends Course {
    public LabCourse(String courseCode, int credits) throws Exception {
        super(courseCode, credits);
    }

    @Override
    public int calculateWorkload() {
        // Workload = credits * 4 hours
        return getCredits() * 4;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            // Polymorphism: Array of Course references
            Course[] courses = {
                    new TheoryCourse("CS101", 3),
                    new LabCourse("CS102L", 2)
            };

            // Display workloads
            for (Course c : courses) {
                System.out.println("Course: " + c.getCourseCode() +
                        " | Credits: " + c.getCredits() +
                        " | Workload: " + c.calculateWorkload() + " hours/week");
            }

            // Invalid case (throws exception)
            Course invalid = new TheoryCourse("CS999", -1);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
