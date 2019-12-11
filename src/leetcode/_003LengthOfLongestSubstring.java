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
        String s = "pwwkew";
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
