package universitycoursemanagementsystem;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creating different types of courses
        ExamCourse examCourse = new ExamCourse("Maths", "SKD");
        ResearchCourse researchCourse = new ResearchCourse("BioTech", "reddys");
        AssignmentCourse assignmentCourse = new AssignmentCourse("Science", "ryan");

        // Manage exam-based courses
        Course<ExamCourse> examCourseM = new Course<>();
        examCourseM.addCourse(examCourse);
        System.out.println("Exam-based courses");
        examCourseM.showCourse();
        System.out.println();

        // Managing assignment-based courses
        Course<AssignmentCourse> assignmentCourseM = new Course<>();
        assignmentCourseM.addCourse(assignmentCourse);
        System.out.println("Assignment Courses:");
        assignmentCourseM.showCourse();
        System.out.println();

        // Managing research-based courses
        Course<ResearchCourse> researchCourseM = new Course<>();
        researchCourseM.addCourse(researchCourse);
        System.out.println("Research Courses:");
        researchCourseM.showCourse();
        System.out.println();

        // Using wildcard method to handle multiple types of courses
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(examCourse);
        allCourses.add(assignmentCourse);
        allCourses.add(researchCourse);

        System.out.println("All Courses:");
        CourseManager.displayCourses(allCourses);

    }
}
