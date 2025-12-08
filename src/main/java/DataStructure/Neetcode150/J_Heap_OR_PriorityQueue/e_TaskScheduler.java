package DataStructure.Neetcode150.J_Heap_OR_PriorityQueue;

import java.util.*;

//https://leetcode.com/problems/task-scheduler/description/
public class e_TaskScheduler {
    // Max-Heap: Stores tasks ready to run, ordered by frequency (tf2.freq - tf1.freq for descending)
    private Map<Character, Integer> map = new HashMap<>();
    private Queue<TaskFreq> allowedMaxHeap = new PriorityQueue<>((tf1, tf2) -> (tf2.freq - tf1.freq));

    // Cooldown Queue (Min-Heap): Stores tasks that must wait, ordered by the time they were used (usedInterval)
    private Queue<TaskFreq> notAllowedMinHeap = new PriorityQueue<>(Comparator.comparingInt(tf -> tf.usedInterval));

    // For debugging output only
    private List<Character> ll = new LinkedList<>();

    public int leastInterval(char[] tasks, int n) {
        for (char task : tasks) {
            map.merge(task, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> mapent : map.entrySet()) {
            allowedMaxHeap.add(new TaskFreq(mapent.getKey(), mapent.getValue(), 0));
        }

        int curInt = 0;

        // Loop continues only as long as there are tasks to run OR tasks cooling down
        while (!allowedMaxHeap.isEmpty() || !notAllowedMinHeap.isEmpty()) {
            curInt++;
            TaskFreq taskToRun = allowedMaxHeap.poll();

            // 1. Execute task or take idle slot
            if (taskToRun == null) {
                ll.add('_');
            } else {
                ll.add(taskToRun.task);
                taskToRun.freq--; // Decrement frequency immediately

                // 2. Only put tasks with remaining work into the cooldown queue
                if (taskToRun.freq > 0) {
                    taskToRun.usedInterval = curInt; // Mark the time it was used
                    notAllowedMinHeap.add(taskToRun);
                }
            }

            // 3. Move tasks from cooldown to allowed heap if they are ready
            if (!notAllowedMinHeap.isEmpty()) {
                TaskFreq earliestUsedTask = notAllowedMinHeap.peek();

                // Task is ready if current time - time used >= n
                if (curInt - earliestUsedTask.usedInterval >= n) {
                    allowedMaxHeap.add(notAllowedMinHeap.poll());
                }
            }
        }
        return curInt;
    }

    public static void main(String[] args) {
        System.out.println(new e_TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}

//@Data
class TaskFreq {
    char task;
    int freq;
    int usedInterval;

    public TaskFreq(char task, int freq, int usedInterval) {
        this.task = task;
        this.freq = freq;
        this.usedInterval = usedInterval;
    }
}