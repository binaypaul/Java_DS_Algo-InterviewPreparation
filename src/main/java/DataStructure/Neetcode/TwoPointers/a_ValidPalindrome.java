package DataStructure.Neetcode.TwoPointers;

public class a_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;

        while (l<r) {
            if(!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
