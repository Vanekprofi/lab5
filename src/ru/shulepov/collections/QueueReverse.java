package ru.shulepov.collections;

import java.util.*;

/**
 * Печать элементов очереди в обратном порядке
 */
public class QueueReverse {

    /**
     * Напечатать элементы очереди в обратном порядке
     */
    public static <T> void printReverse(Queue<T> queue) {
        if (queue == null || queue.isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }

        Stack<T> stack = new Stack<>();
        Queue<T> tempQueue = new LinkedList<>(queue);

        while (!tempQueue.isEmpty()) {
            stack.push(tempQueue.poll());
        }

        System.out.print("Обратный порядок: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}