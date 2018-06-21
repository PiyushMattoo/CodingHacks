/*
 https://leetcode.com/problems/generate-parentheses/description/
 */
package recursion;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author mattoop
 */
public class ParanthesesGeneration {

    public static void main(String[] str) {
        ParanthesesGeneration paranthesesGeneration = new ParanthesesGeneration();
        System.out.println(paranthesesGeneration.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> listOfParanthesis=  new ArrayList<>();
        int openParenthesis = 0;
        int closedParenthesis = 0;
        generateParenthesesRecursively(listOfParanthesis, n, "", openParenthesis, closedParenthesis);
        return listOfParanthesis;
    }

    private void generateParenthesesRecursively(List<String> listOfParanthesis, int max, String s, int openParenthesis, int closedParenthesis) {
        // base case
        if (s.length() == max * 2) {
            listOfParanthesis.add(s);
            return;
        }
        if (openParenthesis < max) {
            openParenthesis++;
            generateParenthesesRecursively(listOfParanthesis, max, s + "(", openParenthesis, closedParenthesis);
        }
        if (closedParenthesis < openParenthesis) {
            closedParenthesis++;
            generateParenthesesRecursively(listOfParanthesis, max, s + ")", openParenthesis, closedParenthesis);
        }
    }

}
