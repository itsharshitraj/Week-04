package queueinterface.circularbuffersimulation;

import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int size, capacity;
    private int front, rear;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    // Insert element into circular buffer
    public void insert(int value) {
        rear = (rear + 1) % capacity; // Move rear forward circularly
        buffer[rear] = value;

        if (size < capacity) {
            size++; // Increase size if not full
        } else {
            front = (front + 1) % capacity; // Move front forward when overwriting
        }
    }

    // Get buffer contents
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); //

        cb.insert(4); // Overwrites 1
        cb.display();

        cb.insert(5); // Overwrites 2
        cb.display();
    }
}
