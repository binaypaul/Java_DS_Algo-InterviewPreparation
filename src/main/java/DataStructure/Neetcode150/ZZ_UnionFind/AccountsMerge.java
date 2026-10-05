package DataStructure.Neetcode150.ZZ_UnionFind;

import java.util.*;
import java.util.stream.*;

public class AccountsMerge {
    //helper maps
    HashMap<String, Integer> emailIdxMap = new HashMap<>();
    HashMap<Integer,String> idxEmailMap = new HashMap<>();
    HashMap<String, String> emailNameMap = new HashMap<>();

    //unionFind's required lists
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts.size()<2) return accounts;

        //initialize
        int idx = 0;
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if(!emailIdxMap.containsKey(account.get(i))) {
                    emailIdxMap.put(account.get(i), idx);
                    idxEmailMap.put(idx, account.get(i));
                    emailNameMap.put(account.get(i), account.getFirst());

                    parent.add(idx);
                    rank.add(0);
                    idx++;
                }
            }
        }
        //grouping by union
        for (List<String> account : accounts) {
            var x = emailIdxMap.get(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                unionByRank(x, emailIdxMap.get(account.get(i)));
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        for (int i = 0; i < parent.size(); i++) {
            List<String> l = null;
            if(!groups.containsKey(parent.get(findUP(i)))) {
                l = new ArrayList<>();
                l.addFirst(emailNameMap.get(idxEmailMap.get(parent.get(findUP(i)))));
                groups.put(parent.get(findUP(i)), l);
            } else {
                l = groups.get(parent.get(findUP(i)));
            }
            l.add(idxEmailMap.get(i));
        }
        return groups.values().stream()
                .map(l -> {
                    List<String> sortedEmails = l.subList(1, l.size()).stream().sorted().toList();
                    List<String> result = new ArrayList<>();
                    result.add(l.get(0));
                    result.addAll(sortedEmails);
                    return result;
                })
                .collect(Collectors.toList());
    }

    private int findUP(int node) {
        if(parent.get(node)==node) return node;

        var up = findUP(parent.get(node));
        parent.set(node, up);
        return up;
    }

    private void unionByRank(int u, int v) {
        int up_u = findUP(u);
        int up_v = findUP(v);

        if(up_u==up_v) return;

        if(rank.get(up_u)<rank.get(up_v)) {
            parent.set(up_u, up_v);
        } else if(rank.get(up_v)<rank.get(up_u)) {
            parent.set(up_v, up_u);
        } else {
            parent.set(up_v, up_u);
            rank.set(up_u, rank.get(up_u)+1);
        }
    }

    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );
        var ret = accountsMerge.accountsMerge(accounts);
        System.out.println(ret);
    }
}
