/*
 https://leetcode.com/problems/4sum/description/
 */
package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mattoop
 */
public class FourSum {

    public static void main(String[] str) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.computeFourSum(new int[] {1,0,-1,1,-2,2}, 0));
    }

    private List<List<Integer>> computeFourSum(int[] nums, int target) {
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length <4) return outputList;
        for (int i = 0; i < nums.length-3; i++) {
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break; //First element too large
            if (nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target) continue; //First element too small
            if(i > 0 && nums[i] == nums[i-1]) continue; //prevent duplicates
            
                for (int j = i + 1; j < nums.length-2; j++) {
                    if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break; //Second element too large
                    if (nums[i] + nums[j] + nums[nums.length-1] + nums[nums.length-2] < target) continue; //Second element too small
                    if(j > i+1 && nums[j] == nums[j-1]) continue; //prevent duplicates
                    int k = j + 1;
                    int l = nums.length-1;
                    while (k < l) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                            l = l - 1;
                        } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                            k = k + 1;
                        } else if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            outputList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            while(nums[k] == nums[k+1]) k++;
                            while(nums[l] == nums[l-1]) l--;
                            k++;
                            l--;
                        }
                    }
            }
        }
        return outputList;
    }
}
