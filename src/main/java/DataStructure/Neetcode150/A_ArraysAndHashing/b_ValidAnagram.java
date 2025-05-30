package DataStructure.Neetcode150.A_ArraysAndHashing;

public class b_ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("racecar", "carrace"));

    }

    public static boolean isAnagram(String s, String t) {

        int[] sLetters = new int[26];
        int[] tLetters = new int[26];

        //base
        if (s.length() != t.length()) {
            return false;
        }

        int length = s.length();

        for (int i = 0; i < length; i++) {
            int sInd = s.charAt(i) - 'a';
            int tInd = t.charAt(i) - 'a';
            sLetters[sInd]++;
            tLetters[tInd]++;
        }
        for (int i = 0; i < 26; i++) {
            if (sLetters[i] != tLetters[i]) {
                return false;
            }
        }
        return true;
    }
}
