package DataStructure.Problems;

public class LongestCommonSubsequense {
    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        String A = scn.nextLine();
//        String B = scn.nextLine();
        String A = "JAVABLOG";
        String B = "ABLGOUTPOT";

        System.out.println(LCS(A, B));

    }

    public static int LCS(String A, String B) {
        /*if one String is exhausted or is empty then
         * there can not be any matching characters in
         * string A and B*/
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }
        /*As on this state of recursion we are working
         * on first characters of strings, in next recursion
         *  we need to recur for remaining strings with first
         *  characters removed */
        String remA = A.substring(1);
        String remB = B.substring(1);
        /* if the current first characters of both strings
         * matches then we add 1 to the LCS length and then
         * recur to find answer for remaining Strings*/
        if (A.charAt(0) == B.charAt(0)) {
            int remRes = LCS(remA, remB);
            return 1 + remRes;
        } else {
            /*if the current first characters of both strings
             * does not match, then maximum length of LCS of
             * current string will be the max LCS of
             * (remaining A and B) or (A and remaining B) */
            int remRes = Math.max(LCS(remA, B), LCS(A, remB));
            return remRes;
        }
    }
}
