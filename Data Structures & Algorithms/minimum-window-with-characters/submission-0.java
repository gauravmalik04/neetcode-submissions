class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0,right=0,required=m,minleft = 0;
        int minlen = Integer.MAX_VALUE;
        while(right<n){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch)>0) required--;
                map.put(ch,map.get(ch)-1);
            }
            right++;
            while(required==0){
                if(right-left < minlen){
                    minlen = right-left;
                    minleft=left;
                }
                char leftchar = s.charAt(left);
                if(map.containsKey(leftchar)){
                    map.put(leftchar,map.get(leftchar)+1);
                    if(map.get(leftchar) > 0 )required++;
                }
                left++;
            }
        }
        if(minlen == Integer.MAX_VALUE) return "";
        return s.substring(minleft,minleft+minlen);
    }
}
