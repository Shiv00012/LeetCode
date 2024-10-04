class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        
        boolean[][] dp = new boolean[n][n];  
        int start = 0, maxLength = 1;  

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }


        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;  
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}