package com.codinghacks.java;

import java.util.regex.*;
/**
 *
 * @author mattoop
 */
public class Test {

    public static void main(String[] str) {
        Test t = new Test();
        t.parseDouble(".123");

    }

    public Double parseDouble(String input) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regexDouble = regexDecimal + "|" + regexInteger;
        String parsedValue = null;
        Pattern p = Pattern.compile("[+-]?\\d*\\.?\\d+");
        
        Matcher m = p.matcher("+00034.120  ");
        if(m.find()) {
            
        
        String matchedString = m.group();
        if(m.group().charAt(0) == '+' || m.group().charAt(0) == '-') {
            parsedValue = m.group().substring(1);
        }
        System.out.println("Here: "+ parsedValue);
        }
        //double output;
       // output = Double.parseDouble(input.trim());
        return 0.0;
    }
}
