package queueinterface.hospitaltriagesystem;

import java.util.PriorityQueue;
import java.util.Comparator;

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> - p.severity));
        queue.offer(new Patient("John", 3));
        queue.offer(new Patient("Alice", 5));
        queue.offer(new Patient("Bob", 2));

        System.out.println("Treatment Order :");
        while (!queue.isEmpty()) { // traverse priority queue
            System.out.println(queue.poll());
        }
    }
}

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}
