package universitycoursemanagementsystem;

class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public void evaluation() {
        System.out.println(courseName + " is evaluated through exams.");
    }

}
