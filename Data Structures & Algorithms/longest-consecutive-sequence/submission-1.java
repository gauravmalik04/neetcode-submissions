class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int maxCount = 0;
        for(int x : set){
            if(!set.contains(x-1)){
                int count = 0;
                while(set.contains(x++)) count++;
                maxCount = Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
