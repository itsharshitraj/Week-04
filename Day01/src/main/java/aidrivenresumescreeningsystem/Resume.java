package aidrivenresumescreeningsystem;

class Resume<T extends JobRole> {
    private T JobRole;

    public Resume(T jobRole) {
        this.JobRole = jobRole;
    }

    public void process() {
        System.out.println("Processing Resume for: " + JobRole.candidateName);
        JobRole.resumeChecking();
    }
}
