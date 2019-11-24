/**
 * http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
 * Given set of jobs with start and end interval and profit, how to maximize profit such that 
 * jobs in subset do not overlap.
 */

package LatestProg;

import java.util.Arrays;
import java.util.Comparator;

public class JobSchedulingProblem {

	private static int maximum(Job[] jobs) {
		// sort the jobs array on basis of the end time;
		Arrays.sort(jobs, new EndDateComparator());
		
		int t[] = new int[jobs.length];
		t[0] = jobs[0].profit;
		
		for(int i=1; i < jobs.length; i++){
            t[i] = Math.max(jobs[i].profit, t[i-1]);
            for(int j=i-1; j >=0; j--){
                if(jobs[j].end <= jobs[i].start){
                    t[i] = Math.max(t[i], jobs[i].profit + t[j]);
                    break;
                }
            }
        }
		
	        return t[jobs.length-1];
		
		
	}

	public static class EndDateComparator implements Comparator<Job> {

		@Override
		public int compare(Job o1, Job o2) {
			if(o1.end <= o2.end) {
				return -1;
			}
			return 1;
		}

	}

	public static class Job {
		int start;
		int end;
		int profit;

		Job(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
	}

	public static void main(String[] args) {
		Job jobs[] = new Job[4];
		jobs[0] = new Job(3, 10, 100);
		jobs[1] = new Job(1, 2, 200);
		jobs[2] = new Job(6, 19, 20);
		jobs[3] = new Job(2, 100, 50);
		System.out.println(maximum(jobs));
	}

}
