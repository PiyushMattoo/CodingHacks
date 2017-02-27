package com.codinghacks.java;

import java.io.*;
import java.util.*;
import java.lang.Integer;

/**
 * @HackerRank: https://www.hackerrank.com/challenges/crush
 * @author mattoop
 */
public class Solution {// O(KN)
    private static long [] performListComputation(int lowerBound, int upperBound, int valueToAdd, long[] intList) {
        for(int listIndex = lowerBound-1; listIndex <= upperBound-1; listIndex++) {
            intList[listIndex] = intList[listIndex] + valueToAdd;
        }
        return intList;
    }
    
    private static long findMaxValueOfList(long[] intList) {
        long max=0;
        for (int index=0; index < intList.length; index++) {
            if(intList[index] > max) {
                         max = intList[index];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Scanner inScan = new Scanner(System.in);
        int sizeOfList = inScan.nextInt();
        //Use long or BigInteger to avoid integer overflow
        long [] intList = new long [sizeOfList + 1];
        int numberOfOperations = inScan.nextInt();
        
        for(int index=0; index < numberOfOperations; index++) {
            int lowerBound = inScan.nextInt();
            int upperBound = inScan.nextInt();
            int valueToAdd = inScan.nextInt();
           
            //intList = performListComputation(lowerBound, upperBound, valueToAdd, intList);
            intList[lowerBound-1] = intList[lowerBound-1] + valueToAdd;
            intList[upperBound] = intList[upperBound] - valueToAdd;
        }
        //System.out.println(findMaxValueOfList(intList));
        inScan.close();
        
        long prefixSum = 0;
        long maxValue = 0;
        // O(K+N)
        for (int indexOverDiffArray = 0; indexOverDiffArray < sizeOfList; indexOverDiffArray++) {
            prefixSum = prefixSum + intList[indexOverDiffArray];
            maxValue = Math.max(maxValue, prefixSum);
        }
        
        System.out.println(maxValue);
    }
}