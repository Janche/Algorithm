package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lirong
 * @ClassName: _003LengthOfLongestSubstring
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date 2019-12-11 17:41
 */
public class _003LengthOfLongestSubstring {

    public static void main(String[] args) {

        test01();

        test02();

        test03();

        test04();

    }

    private static void test04() {
        String s = "sdabcdgjabklabcjg3abb24";
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        for (int end = 0, start = 0; end < s.length(); end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        System.out.println(ans);
    }

    private static void test03() {
        String s = "abcabcdabfhua";
        Map<Character,Integer> map = new HashMap<>(16);
        int ans = 0;
        for (int start =0, i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                int temp = map.get(s.charAt(i)) + 1;
                for (int j = start; j < temp; j++) {
                    map.remove(s.charAt(j));
                }
                start = temp;
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - start + 1);
        }
        System.out.println(ans);

    }

    private static void test02() {
        String s = "abcabcdabfhua";
        Map<Character,Integer> map = new HashMap<>(16);
        int start = 0, end = 0, max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                int temp = map.get(chars[i]) + 1;
                for (int j = start; j < temp; j++) {
                    map.remove(chars[j]);
                }
                start = temp;
                end = i;
            }
            map.put(chars[i], i);
            end++;
            if (max < end -start){
                max = end - start;
            }
        }
        System.out.println(max);

    }

    private static void test01() {
        String s = "abcabcbb";
        int max = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (str.contains(c + "")){
                str = str.substring(str.indexOf(c)+1) + c;
            }else {
                str += c + "";
            }
            if (max <= str.length()){
                max = str.length();
            }
        }

        System.out.println(max);
    }
}
