package Strings;

/**
 *
 * @author mattoop
 */
public class StringToInteger {

    public static void main(String[] str) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("  -0012a42"));
    }

    public int myAtoi(String str) {
        if (str == null || str.length() < 1 || str.contains("+-") || str.contains("-+")) {
            return 0;
        }

        str = str.trim();

        boolean signFlag = false;
        double result = 0;
        char[] charBuffer = str.toCharArray();
        for (int i = 0; i < charBuffer.length; i++) {
            if (!(charBuffer[i] >= '0' && charBuffer[i] <= '9') && charBuffer[0] != '-' && charBuffer[0] != '+') {
                if(charBuffer[0] != '-' || charBuffer[0] != '+') 
                    break;
            } else {
                if (charBuffer[i] != ' ') {
                    if (charBuffer[i] == '-') {
                        signFlag = true;
                    } else if (charBuffer[i] != '+') {
                        result = result * 10 + charBuffer[i] - '0';
                    }
                }
            }
        }
        if (signFlag) {
            result = result * -1;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

}
