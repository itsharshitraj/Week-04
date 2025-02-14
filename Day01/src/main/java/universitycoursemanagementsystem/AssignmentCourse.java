package universitycoursemanagementsystem;

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public void evaluation() {
        System.out.println(courseName + " is evaluated through assignments.");
    }
}
