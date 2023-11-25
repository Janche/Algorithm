package leetcode.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author: lirong
 * @date: 2023/7/16
 * @description:
 */
public class TopKFrequent {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};

        Arrays.stream(topKFrequent(nums, 2)).forEach(System.out::println);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> num2Count = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(e -> e, Collectors.reducing(0, e -> 1, Integer::sum)));
//        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            num2Count.put(nums[i], num2Count.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> que = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[1]));
        num2Count.forEach((key, val) -> {
            if (que.size() < k) {
                que.add(new int[]{key, val});
            } else if (val > que.peek()[1]) {
                que.poll();
                que.add(new int[]{key, val});
            }
        });
        int[] ans = new int[k];
        int i = 0;
        while (!que.isEmpty()) {
            ans[i++] = que.poll()[0];
        }
        return ans;
    }
}
