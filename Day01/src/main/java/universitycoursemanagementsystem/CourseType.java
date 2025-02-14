package universitycoursemanagementsystem;

abstract class CourseType {
    protected String courseName;
    protected String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public abstract void evaluation();

    @Override
    public String toString() {
        return courseName + " by " + instructor;
    }
}


