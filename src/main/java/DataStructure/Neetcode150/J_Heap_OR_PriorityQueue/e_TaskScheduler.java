package DataStructure.Neetcode150.J_Heap_OR_PriorityQueue;

import java.util.*;

//https://leetcode.com/problems/task-scheduler/description/
public class e_TaskScheduler {
    private Map<Character, Integer> map = new HashMap<>();
    private Queue<TaskFreq> allowedMaxHeap = new PriorityQueue<>((tf1, tf2)-> (tf2.freq-tf1.freq));
    private Queue<TaskFreq> notAllowedMaxHeap = new PriorityQueue<>(Comparator.comparingInt(tf -> tf.usedInterval));

    private List<Character> ll = new LinkedList<>();

    public int leastInterval(char[] tasks, int n) {
        int resInt = 0;
        for (char task : tasks) {
            map.merge(task, 1, Integer::sum);
        }
        //A=3, B=3
       for (Map.Entry<Character, Integer> mapent : map.entrySet()) {
           allowedMaxHeap.add(new TaskFreq(mapent.getKey(), mapent.getValue(), 0));
       }
        System.out.println("allowedMaxHeap:    " + allowedMaxHeap);

        int curInt = 0;
        while (!allowedMaxHeap.isEmpty() || !notAllowedMaxHeap.isEmpty()) {
            TaskFreq tf = allowedMaxHeap.poll();
            curInt++;

            if(null == tf) {
                ll.add('_');
                resInt++;
            } else {
                ll.add(tf.task);
                resInt++;

                if(tf.freq > 1) {
                    tf.freq--;
                    tf.usedInterval = curInt;
                    notAllowedMaxHeap.add(tf);
                }
            }

            if (!notAllowedMaxHeap.isEmpty() && curInt - notAllowedMaxHeap.peek().usedInterval >= n) {
                allowedMaxHeap.add(notAllowedMaxHeap.poll());
            }

            System.out.println("allowedMaxHeap:    " + allowedMaxHeap);
            System.out.println("notAllowedMaxHeap: " + notAllowedMaxHeap);
            System.out.println(ll);
        }
        return resInt;
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