package DataStructure.Practice.September2026._03.M2;

import java.util.*;
import java.util.stream.*;
import lombok.*;
import lombok.extern.java.*;

public class LongestRunningJobInstancesTracker {
    public List<String> topLongestRunningJobs(List<String> logs, int k) {
        // Your implementation here
        if(logs == null) return null;

        var map = new HashMap<String, Job>();
        for (String log : logs) {
            var logSplitArr = log.split(" ");
            if(logSplitArr.length == 4) {
                //start job
                var name = logSplitArr[1].split("=")[1];
                var jobId = logSplitArr[2].split("=")[1];
                var start = Integer.parseInt(logSplitArr[3].split("=")[1]);
                var startJob = new Job(name, jobId, start, null);
                map.put(jobId, startJob);
            } else if(logSplitArr.length == 3) {
                //end job
                var jobId = logSplitArr[1].split("=")[1];
                var end = Integer.parseInt(logSplitArr[2].split("=")[1]);
                var job = map.get(jobId);
                if(job!=null && job.start<=end) {
                    job.end=end;
                }
            }
        }

        return map.entrySet().stream()
                .filter(e-> e.getValue().end!=null)
                .collect(Collectors.groupingBy(
                        e-> e.getValue().name,
                        Collectors.summingInt(e->e.getValue().end-e.getValue().start)))
                .entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        /*
        List<String> logs = Arrays.asList(
                "Started name=dump_logs jobid=f863 time=100",
                "Started name=dump_logs jobid=g301gas time=200",
                "Ended jobid=f863 time=1021",
                "Started name=grep_logs jobid=ac3de time=10",
                "Ended jobid=g301gas time=1343",
                "Started name=read_logs jobid=r0eas time=300",
                "Started name=write_logs jobid=dg2dz time=400",
                "Started name=grep_logs jobid=v87ft time=50",
                "Started name=write_logs jobid=ttre8 time=600",
                "Ended jobid=ac3de time=52",
                "Ended jobid=v87ft time=102"
        );
        int k = 2;
        */
        List<String> logs = Arrays.asList(
                "Started name=dump_logs jobid=f863 time=100",
                "Started name=dump_logs jobid=g301gas time=200",
                "Ended jobid=f863 time=1021",
                "Started name=grep_logs jobid=ac3de time=10",
                "Ended jobid=g301gas time=1343",
                "Started name=read_logs jobid=r0eas time=300",
                "Started name=write_logs jobid=dg2dz time=400",
                "Started name=grep_logs jobid=v87ft time=50",
                "Started name=write_logs jobid=ttre8 time=600",
                "Ended jobid=ac3de time=52",
                "Ended jobid=v87ft time=102"
        );
        //O/P: ["dump_logs", "grep_logs"]
        int k = 2;
        System.out.println(new LongestRunningJobInstancesTracker().topLongestRunningJobs(logs, k));
    }
    @Data
    @AllArgsConstructor
    class Job {
        String name, jobId;
        Integer start,end;
    }
}
