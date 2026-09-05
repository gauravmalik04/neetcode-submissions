class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] anagramArr = str.toCharArray();
            Arrays.sort(anagramArr);
            String ana = new String(anagramArr);
            if(map.containsKey(ana)){
                map.get(ana).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(ana,list);
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for(String key : map.keySet()){
            answer.add(map.get(key));
        }
        return answer;
    }
}
