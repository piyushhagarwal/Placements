package Strings;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer ans = new StringBuffer(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            StringBuffer prefix = new StringBuffer("");
            int j = 0;
            while (j < ans.length() && j < strs[i].length() && ans.charAt(j) == strs[i].charAt(j)) {
                prefix.append(ans.charAt(j));
                j++;
            }
            ans = prefix;
        }
        return ans.toString();
    }
}
