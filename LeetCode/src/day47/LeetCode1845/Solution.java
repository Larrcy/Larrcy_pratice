package day47.LeetCode1845;
import java.util.*;
public class Solution {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    public void SeatManager(int n) {
        for (int i = 1; i <= n; i++)
            queue.offer(i);
    }
    public int reserve() {
        return queue.poll();
    }
    public void unreserve(int seatNumber) {
        queue.offer(seatNumber);
    }

}
