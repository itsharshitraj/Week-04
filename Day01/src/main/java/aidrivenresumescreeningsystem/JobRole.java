package aidrivenresumescreeningsystem;

abstract class JobRole {
    String candidateName;
    String resumeContent;

    public JobRole(String candidateName, String resumeContent) {
        this.candidateName = candidateName;
        this.resumeContent = resumeContent;
    }

    public abstract void resumeChecking();
}
