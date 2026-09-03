class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int start = 0;
        StringBuilder str = new StringBuilder("");
        for(int i = 0;i<n;i++){
            if(Character.isLetterOrDigit(s.charAt(i)) && s.charAt(i)!=' ') str.append(s.charAt(i));
        }
        String sb = str.toString();
        n = sb.length();
        int end = n-1;
        while(start<end){
            char left = sb.charAt(start);
            char right = sb.charAt(end);
            if(Character.toLowerCase(left)!=Character.toLowerCase(right)) return false;
            start++;
            end--;
        }
        return true;
    }
}
