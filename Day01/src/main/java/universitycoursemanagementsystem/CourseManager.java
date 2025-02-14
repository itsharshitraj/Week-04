package universitycoursemanagementsystem;

import java.util.ArrayList;
import java.util.List;

class CourseManager {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
            course.evaluation();
        }
    }
}
