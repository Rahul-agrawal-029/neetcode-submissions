class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // Method1:
        // System.out.println(map);
        // List<Integer> list = new ArrayList();
        
        // list.addAll(map.keySet());
        // Collections.sort(list,(a,b) -> map.get(b)-map.get(a));
        // System.out.println(list);

        // return list.subList(0,k).stream().mapToInt(i -> i).toArray();

        // Method 2:
        // Integer[] list = new Integer[map.size()];
        // map.keySet().toArray(list);
        // Arrays.sort(list, (a,b)-> map.get(b) - map.get(a));
        // System.out.println(list);
        // int[] result = new int[k];
        // for (int i = 0; i<k; i++){
        //     result[i] = list[i];
        // }
        // return result;

        // Method3:
        // Step 2: Create a Min-Heap based on frequency
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
    //     // Step 3: Keep only the top k elements in the heap
    //     for (int key : map.keySet()) {
    //         minHeap.add(key);
    //         if (minHeap.size() > k) {
    //             minHeap.poll(); // Kick out the element with the lowest frequency
    //         }
    //     }
        
    //     // Step 4: Extract the elements into an array
    //     int[] result = new int[k];
    //     for (int i = 0; i < k; i++) {
    //         result[i] = minHeap.poll();
    //     }
        
    //     return result;
    // }
    // Step 2: Create an array of lists (buckets)
        // Size is nums.length + 1 because the max possible frequency is the length of the array
        List<Integer>[] buckets = new List[nums.length + 1];
        
        // Step 3: Populate the buckets
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        
        // Step 4: Read the buckets from right to left (highest frequency to lowest)
        int[] result = new int[k];
        int index = 0;
        
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        return result; // Stop as soon as we have k elements
                    }
                }
            }
        }
        
        return result;
    }
}
