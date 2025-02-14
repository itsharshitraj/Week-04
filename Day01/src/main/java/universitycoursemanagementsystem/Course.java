package universitycoursemanagementsystem;

import java.util.ArrayList;
import java.util.List;

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public Course() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(T course) {
        courses.add(course);
    }

    public void showCourse() {
        for (T course : courses) {
            System.out.println(course);
            course.evaluation();
        }
    }
}
