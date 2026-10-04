package DataStructure.Practice.Oct2026;

import java.util.*;
import java.util.stream.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts.size()<2) return accounts;

        return null;
    }
    /*
    List<List<String>> expected = Arrays.asList(
    Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
    Arrays.asList("Mary", "mary@mail.com"),
    Arrays.asList("John", "johnnybravo@mail.com")
);
     */
    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "a@mail.com"),
                Arrays.asList("John", "b@mail.com"),
                Arrays.asList("John", "a@mail.com", "b@mail.com")
        );
        var ret = accountsMerge.accountsMerge(accounts);
        System.out.println(ret);
    }
}
