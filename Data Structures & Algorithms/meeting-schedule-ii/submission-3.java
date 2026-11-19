/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
        if(n<=1) return n;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval meet : intervals){
            int start = meet.start;
            int end = meet.end;
            if(pq.size() == 0) pq.add(end);
            else if(start < pq.peek()) pq.add(end);
            else{
                pq.poll();
                pq.add(end);
            }
        }
        return pq.size();
    }
}
