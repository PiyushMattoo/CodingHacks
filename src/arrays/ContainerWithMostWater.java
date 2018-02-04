/*
https://leetcode.com/problems/container-with-most-water/description/
 */

package arrays;

/**
 *
 * @author mattoop
 */
public class ContainerWithMostWater {
    public static void main(String[] str) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[] {1,2,3,4,5}));
    }
    
    private int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0; int right = height.length-1;
        while(left < right) {
            maxArea = Math.max(maxArea, (right-left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    
}
