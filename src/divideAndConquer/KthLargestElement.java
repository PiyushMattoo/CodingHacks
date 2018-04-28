package divideAndConquer;

import java.util.*;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * @author mattoop
 */
public class KthLargestElement {

    public static void main(String[] str) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] inputArray = {3,2,1,5,6,4};
        System.out.println(kthLargestElement.findKthLargest(inputArray, 2));
    }

    public Integer findKthLargest(int[] nums, int k) {
        Integer outputElement = null;
        Queue priorityQueue = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
        }
        int j=nums.length;
        while(j > nums.length-k+1) {
            j--;
            priorityQueue.poll();
        }
        outputElement = (Integer) priorityQueue.poll();
        return outputElement;
    }
    
}
