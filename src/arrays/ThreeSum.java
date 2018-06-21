package arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author mattoop
 */
public class ThreeSum {

    public List<List<Integer>> computeThreeSum(int[] inputIntList) {
        Arrays.sort(inputIntList);
        List<List<Integer>> threeSumListofLists = new ArrayList<>();
        Set<List<Integer>> threeSumSetOfLists = new HashSet<>();

        for (int index = 0; index < inputIntList.length; index++) {
            int secondPointer = index+1;
            int thirdPointer = inputIntList.length - 1;

            while (secondPointer < thirdPointer) {
                int sum = inputIntList[index] + inputIntList[secondPointer] + inputIntList[thirdPointer];
                if (sum > 0) {
                    thirdPointer = thirdPointer - 1;
                } else if (sum < 0) {
                    secondPointer = secondPointer + 1;
                } else if (sum == 0) {
                    List<Integer> threeSumsList = new ArrayList<>();
                    threeSumsList.add(inputIntList[index]);
                    threeSumsList.add(inputIntList[secondPointer]);
                    threeSumsList.add(inputIntList[thirdPointer]);
                    threeSumSetOfLists.add(threeSumsList);
                    secondPointer = secondPointer + 1;
                    thirdPointer = thirdPointer - 1; 
                }
            }
        }
        threeSumListofLists.addAll(threeSumSetOfLists);
        return threeSumListofLists;
    }
}
