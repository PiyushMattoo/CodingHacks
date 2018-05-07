package recursion;

/**
   https://leetcode.com/problems/minimum-factorization/description/
 * @author mattoop
 */
public class MinimumFactorization {

    public static void main(String[] str) {
        MinimumFactorization minimumFactorization = new MinimumFactorization();
        System.out.println(minimumFactorization.smallestFactorization(18));
    }

    public int smallestFactorization(int input) {
        int res = 0, mul = 1;
        if (input <2 || input > Integer.MAX_VALUE) {
            return input;
        }
        for (int index = 9; index >= 2; index--) {
            while (input % index == 0) {
                input = input / index;
                res = mul * index + res;
                mul = mul * 10;
            }
        }
         return input < 2 && res <= Integer.MAX_VALUE ? res : 0;
    }
}
