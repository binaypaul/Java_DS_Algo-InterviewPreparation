package DataStructure.Practice.Nov2026;

import java.util.*;
import lombok.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int total = tasks.length;
        HashMap<Character, Integer> taskCountMap = new HashMap<>();
        for (Character c : tasks) {
            taskCountMap.compute(c, (k,v) -> v==null?1:v+1);
        }

        PriorityQueue<TC> nextTCpq = new PriorityQueue<TC>((tc1, tc2)-> tc2.count-tc1.count); //maxHeap

        for (Map.Entry<Character, Integer> characterIntegerEntry : taskCountMap.entrySet()) {
            nextTCpq.offer(new TC(characterIntegerEntry.getKey(), characterIntegerEntry.getValue()));
        }

        Queue<Cooldown> queue = new LinkedList<>();

        int cur = 0;
        while (total>0) {
            cur++;
            //operate on next highest count available task
            if(!nextTCpq.isEmpty()) {
                var tc = nextTCpq.poll();
                if(tc.count>1) {
                    queue.offer(new Cooldown(tc.task, cur));
                    taskCountMap.compute(tc.task, (k, v) -> --v);
                } else {
                    taskCountMap.remove(tc.task);
                }
                total--;
            }
            //recalibrate the nextTCpq for the eligible task
            while (!queue.isEmpty() && cur-queue.peek().executedAt>=n) {
                var task = queue.poll().task;
                nextTCpq.offer(new TC(task, taskCountMap.get(task)));
            }
        }
        return cur;
    }
    //POJO
    record TC(char task, int count){}
    record Cooldown(char task, int executedAt){}

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 0;
        var ret = taskScheduler.leastInterval(tasks, n);
        System.out.println(ret);
    }
}
