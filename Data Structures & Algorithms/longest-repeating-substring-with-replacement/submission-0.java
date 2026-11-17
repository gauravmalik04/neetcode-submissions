class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left=0;
        int right=0;
        int maxFreq = 0;
        int[] freq = new int[26];
        int maxlen = Integer.MIN_VALUE;
        while(right<n){
            char ch = s.charAt(right);
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq,freq[ch-'A']);
            int window = right-left+1;
            if(maxFreq+k < window){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}
