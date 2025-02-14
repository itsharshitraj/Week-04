package aidrivenresumescreeningsystem;

class ProductManager extends JobRole {
    public ProductManager(String candidateName, String resumeContent) {
        super(candidateName, resumeContent);
    }

    @Override
    public void resumeChecking() {
        System.out.println("Screening ProductManager resume: " + candidateName);
    }
}
