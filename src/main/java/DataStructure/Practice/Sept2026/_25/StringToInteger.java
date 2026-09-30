package DataStructure.Practice.Sept2026._25;

public class StringToInteger {
    public int myAtoi(String s) {
        int result = 0;
        boolean isNegative = false;
        char[] cs = s.trim().toCharArray();
        for (int i = 0; i<cs.length; i++) {
            if(Character.isDigit(cs[i]) || ((cs[i]=='-'||cs[i]=='+') && i==0)) {
                if(Character.isDigit(cs[i])) {
                    int digit = Integer.parseInt(String.valueOf(cs[i]));
                    if((result > Integer.MAX_VALUE/10 ||
                            (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10))) {
                        return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
                    }
                    result = result*10 + digit;
                } else if(cs[i]=='-') {
                    isNegative=true;
                }
            } else {
                break;
            }
        }
        return isNegative? result*-1 : result;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        String s = "2147483646"; //42
//        s = "   -042"; //-42
//        s = "   -+042"; //0
//        s = "1337c0d3";//1337
//        s = "words and 987";//0
//        s = "91283472332";//2147483647

        var ret = stringToInteger.myAtoi(s);
        System.out.println(ret);
    }
}
