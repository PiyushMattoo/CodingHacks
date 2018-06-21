/*
 https://leetcode.com/problems/add-bold-tag-in-string/description/
 */
package Strings;

/**
 *
 * @author mattoop
 */
public class BoldTag {

    public static void main(String[] str) {
        BoldTag boldTag = new BoldTag();
        //System.out.println(boldTag.addBoldTagToInputString("aaabbcc", new String[]{"aaa", "aab", "bc"}));
        System.out.println(boldTag.addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"}));
    }
    
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String d: dict) {
            for (int i = 0; i <= s.length() - d.length(); i++) {
                if (s.substring(i, i + d.length()).equals(d)) {
                    for (int j = i; j < i + d.length(); j++)
                        bold[j] = true;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (bold[i]) {
                res.append("<b>");
                while (i < s.length() && bold[i])
                    res.append(s.charAt(i++));
                res.append("</b>");
            } else
                res.append(s.charAt(i++));
        }
        return res.toString();
    }

    private String addBoldTagToInputString(String input, String[] dict) {
        StringBuilder sb = new StringBuilder();
        String tempString=input.substring(0, 1);
        int startIndex=0;
        //Create a boolean array
        boolean[] ifBoldedArray = new boolean[input.length()];
        for (int index = 0; index < input.length(); index++) {
            for (int indexTwo = 0; indexTwo < dict.length; indexTwo++) {
                if (dict[indexTwo].equalsIgnoreCase(tempString)) {
                    ifBoldedArray[index] = true;
                    tempString = input.substring(startIndex, index+2 < input.length() ? index+2 : input.length()); // start index should be when last char didn't match +1
                    break;
                } else {
                    ifBoldedArray[index] = false;
                    //if(tempString.length() <=1)
                        tempString = input.substring(index, index+2 < input.length() ? index+2 : input.length());
                   // else
                        //tempString = tempString.substring(1);
                    startIndex = index+1;
                }
            }
        }
        System.out.println(ifBoldedArray[0] + " " + ifBoldedArray[1] + " " + ifBoldedArray[2] + " " + ifBoldedArray[3] + " " + ifBoldedArray[4]
        + " " + ifBoldedArray[5] + " " + ifBoldedArray[6]);
        
        
        //Insert start <b> and end </b>
        for(int boolIndex=0; boolIndex < ifBoldedArray.length; boolIndex++) {
            if(ifBoldedArray[boolIndex] && (boolIndex ==0 || !ifBoldedArray[boolIndex-1])) {
                sb.append("<b>");
                sb.append(input.charAt(boolIndex));
            } else if(ifBoldedArray[boolIndex] && (boolIndex == ifBoldedArray.length-1 || !ifBoldedArray[boolIndex+1])) {
                sb.append("</b>");
            } else {
                sb.append(input.charAt(boolIndex));
            }
        }
        return sb.toString();
    }

}
