package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词
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
        // dp[i] 表示字符串 s 的前 i 个字符能否拆分成 wordDict 中的单词
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
