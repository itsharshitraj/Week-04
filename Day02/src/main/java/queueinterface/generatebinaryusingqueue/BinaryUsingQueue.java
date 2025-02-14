package queueinterface.generatebinaryusingqueue;

import java.util.*;

public class BinaryUsingQueue {
    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1"); // first binary

        for (int i = 0; i < n; i++) {
            String current = queue.poll(); // get front element
            System.out.println(current + " "); // print current binary

            queue.offer(current + "0"); // add 0
            queue.offer(current + "1"); // add 1
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("First " + n + " binary numbers :");
        generateBinaryNumbers(n);


    }
}
