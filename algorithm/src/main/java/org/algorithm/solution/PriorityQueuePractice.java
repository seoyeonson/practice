package org.algorithm.solution;

import java.util.*;

public class PriorityQueuePractice {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        taskQueue.offer(new Task("Low priority", 5));
        taskQueue.offer(new Task("High priority", 1));
        taskQueue.offer(new Task("Medium priority", 3));

        while(!taskQueue.isEmpty()){
            Task task = taskQueue.poll();
//            System.out.println(task.name + " (Priority: " + task.priority + ")");
            String message = String.format("%s (Priority: %d)", task.name, task.priority);
            System.out.println(message);
        }
    }
}

class Task implements Comparable<Task> {
    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other){
        return Integer.compare(this.priority, other.priority);
    }
}
