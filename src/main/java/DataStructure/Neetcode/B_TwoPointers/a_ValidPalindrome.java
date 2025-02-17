package DataStructure.Neetcode.B_TwoPointers;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise. 
 * Input: s = "A man, a plan, a canal: Panama" 
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome. 
 * https://leetcode.com/problems/valid-palindrome/description/
 */
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
