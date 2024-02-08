package code.Nira.GreddyAlgorithum;
import java.util.*;
public class jobSequence {
    static class job {
        int id;
        int deadline;
        int profit;

        public job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,20}, {1,10},{1,40}, {1, 30}};

        ArrayList<job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
            Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

            ArrayList<Integer> seq = new ArrayList<>();
            int time = 0;

            for (int i = 0; i < jobs.size(); i++) {
                job curr = jobs.get(i);
                if(curr.deadline > time) {
                    seq.add(curr.id);
                    time++;
                }
            }
            System.out.println(seq.size());
            for (int i = 0; i < seq.size(); i++) {
                System.out.print(seq.get(i) + " ");
            }
            System.out.println();
    }
}
