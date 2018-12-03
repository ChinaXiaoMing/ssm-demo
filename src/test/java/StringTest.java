import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 一个字符串只有大小写字母或数字，求出出现次数最多的数字之和
 */
public class StringTest {

    public static void main(String[] args) {

        String str = "zdsadjk33sdjsk33s321ss321ss33";
        //筛选字符串中的数字
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        Map<String, Integer> map = new HashMap<String, Integer>();
        //用map的key保存筛选后的数字，用value保存对应数字出现的次数
        while (matcher.find()) {
            if (map.containsKey(matcher.group())) {
                int temp = map.get(matcher.group());
                map.put(matcher.group(), temp + 1);
            } else {
                map.put(matcher.group(), 1);
            }
        }
        //获取map中最大的value值，即数字出现最多的次数
        Collection<Integer> collection = map.values();
        int count = Collections.max(collection);
        //根据value获取对应的key值
        String key = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == count) {
                key = entry.getKey();
            }
        }
        //求出出现次数最多的数字的和
        int sum = Integer.parseInt(key) * count;
        System.out.println(sum);

    }

}
