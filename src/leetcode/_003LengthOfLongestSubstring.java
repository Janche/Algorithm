package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lirong
 * @ClassName: _003LengthOfLongestSubstring
 * @Description: ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * @date 2019-12-11 17:41
 */
public class _003LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "abcdabcbbabccde";

        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, end-start);
        }



        // System.out.println(ans);
    }
}
