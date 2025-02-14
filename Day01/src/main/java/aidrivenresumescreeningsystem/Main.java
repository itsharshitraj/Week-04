package aidrivenresumescreeningsystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating resumes
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Harshit", "Java, Spring, Microservices"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Gautam", "Python, ML, TensorFlow"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Harsh", "Agile, UX, Roadmaps"));

        // Processing resumes
        seResume.process();
        dsResume.process();
        pmResume.process();

        // Screening pipeline with wildcards
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer("David", "C++, Algorithms"));
        jobRoles.add(new DataScientist("Eve", "R, Data Visualization"));
        jobRoles.add(new ProductManager("Frank", "Strategy, Metrics"));

        System.out.println("\nRunning Screening Pipeline:");
        ResumeScreening.screenResumes(jobRoles);

    }
}
