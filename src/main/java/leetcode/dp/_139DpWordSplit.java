package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣������������ֵ��г��ֵ�һ����������ƴ�ӳ� s �򷵻� true��
 * ע�⣺��Ҫ���ֵ��г��ֵĵ���ȫ����ʹ�ã������ֵ��еĵ��ʿ����ظ�ʹ�á�
 * ʾ�� 1��
 * ����: s = "leetcode", wordDict = ["leet", "code"]
 * ���: true
 * ����: ���� true ��Ϊ "leetcode" ������ "leet" �� "code" ƴ�ӳɡ�
 * ʾ�� 2��
 * ����: s = "applepenapple", wordDict = ["apple", "pen"]
 * ���: true
 * ����: ���� true ��Ϊ "applepenapple" ������ "apple" "pen" "apple" ƴ�ӳɡ�
 *      ע�⣬������ظ�ʹ���ֵ��еĵ���
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/23
 */
public class _139DpWordSplit {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode", list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // dp[i] ��ʾ�ַ��� s ��ǰ i ���ַ��ܷ��ֳ� wordDict �еĵ���
        boolean[] dp = new boolean[len + 1];

        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
