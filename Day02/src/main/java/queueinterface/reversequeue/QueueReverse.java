package queueinterface.reversequeue;

import java.util.*;
import java.util.Queue;

public class QueueReverse {
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<Integer>();
        // Dequeue all elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        // Pop all elements from the stack and enqueue them back into the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original queue: " + queue);

        Queue<Integer> reversedQueue = reverseQueue(queue);
        System.out.println("Reversed queue : " + reversedQueue);

    }
}
