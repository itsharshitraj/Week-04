package aidrivenresumescreeningsystem;

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, String resumeContent) {
        super(candidateName, resumeContent);
    }

    @Override
    public void resumeChecking() {
        System.out.println("Screening Software Engineer resume: " + candidateName);
    }
}
