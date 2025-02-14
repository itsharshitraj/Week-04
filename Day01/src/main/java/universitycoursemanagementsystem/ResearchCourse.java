package universitycoursemanagementsystem;

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public void evaluation() {
        System.out.println(courseName + " is evaluated through assignments.");
    }
}
