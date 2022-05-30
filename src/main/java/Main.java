import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//        test01();
//        test02();
//        test03();
//        test04();
        test05();
    }

    private static void test05() {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

        System.out.println(streamSupplier.get().anyMatch(s -> true));
        System.out.println(streamSupplier.get().findFirst().get());
    }

    private static void test04() {

        String base64encodedString = null;
        try {
            base64encodedString = Base64.getEncoder().encodeToString("你好 base64".getBytes("utf-8"));
            System.out.println(new String(Base64.getDecoder().decode(base64encodedString), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
    }

    private static void test03() {

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getSum());

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println(mergedString);
    }

    private static void test01() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }

    private static void test02() {
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 重新计算鞋子打了10%折扣后的值
        int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10/100);
        prices.computeIfPresent("Bag", (key,value) ->310);
        System.out.println("Discounted Price of Shoes: " + newPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
    }
}
