class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // System.out.println(map);
        List<Integer> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,(a,b) -> map.get(b)-map.get(a));
        // System.out.println(list);

        return list.subList(0,k).stream().mapToInt(i -> i).toArray();
    }
}
