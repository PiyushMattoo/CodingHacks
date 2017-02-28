package com.codinghacks.java;

import java.util.*;

/**
 * @HackerRank https://www.hackerrank.com/challenges/sparse-arrays
 * @author mattoop
 */
public class SparseArray {

    public static void main(String[] args) {
        Scanner inScan = new Scanner(System.in);
        int countOfString = inScan.nextInt();
        Map<String, Integer> mapOfStringCounts = new HashMap<>();
        for (int index = 0; index < countOfString; index++) {
            String inputString = inScan.next();
            /*Integer value = mapOfStringCounts.get(inputString);
             if(value != null) {
             mapOfStringCounts.put(inputString, value+1);
             } else {
             mapOfStringCounts.put(inputString, 1);
             }*/
            mapOfStringCounts.compute(inputString, (k, v) -> v == null ? 1 : v + 1);

        }
        int queryCount = inScan.nextInt();
        for (int queryIndex = 0; queryIndex < queryCount; queryIndex++) {
            String queryString = inScan.next();
            /*if(mapOfStringCounts.get(queryString) != null) {
             System.out.println(mapOfStringCounts.get(queryString));
             } else {
             System.out.println("0");
             }*/
            System.out.println(mapOfStringCounts.getOrDefault(queryString, 0));
        }

    }
}
