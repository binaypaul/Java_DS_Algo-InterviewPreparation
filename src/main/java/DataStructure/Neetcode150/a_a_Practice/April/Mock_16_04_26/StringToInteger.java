package DataStructure.Neetcode150.a_a_Practice.April.Mock_16_04_26;

import java.math.*;
import javax.xml.stream.events.*;

public class StringToInteger {
    public static int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty() ||
                (!Character.isDigit(s.charAt(0)) &&
                        s.charAt(0)!='-' &&
                        s.charAt(0)!='+')) {
            return 0;
        }

        int r=0;
        if(s.charAt(0)=='-' || s.charAt(0)=='+') {
            r++;
        }
        while (r < s.length() && Character.isDigit(s.charAt(r))) {
            r++;
        }
        s = s.substring(0,r);
        if(s.equals("-") || s.equals("+")) return 0;

        BigInteger bi = new BigInteger(s);
        if(bi.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))==1) {
            return Integer.MAX_VALUE;
        } else if (bi.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))==-1) {
            return Integer.MIN_VALUE;
        } else return bi.intValue();
    }

    public static void main(String[] args) {
        System.out.println(StringToInteger.myAtoi("21474836481"));
    }
}
