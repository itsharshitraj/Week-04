package aidrivenresumescreeningsystem;

class DataScientist extends JobRole {
    public DataScientist(String candidateName, String resumeContent) {
        super(candidateName, resumeContent);

    }

    @Override
    public void resumeChecking() {
        System.out.println("Screening DataScientist resume: " + candidateName);
    }
}
