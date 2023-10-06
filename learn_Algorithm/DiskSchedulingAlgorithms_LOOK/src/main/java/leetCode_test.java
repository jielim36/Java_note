import java.util.HashMap;
import java.util.Map;

public class leetCode_test {
    public static void main(String[] args) {
leetCode_test test = new leetCode_test();
        String s = "AAaaaBBbbCccc";
        System.out.println(test.frequencySort(s));
    }
    public String frequencySort(String s) {
        StringBuffer sb = new StringBuffer();
        Map<Character,Integer> charCountMap = new HashMap<>();

        int length = s.length();

        for(int i = 0 ; i < length ; i++){
            char key = s.charAt(i);
            charCountMap.put(key , charCountMap.getOrDefault(key,0) + 1 );
        }

        charCountMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(record -> {

            char key = record.getKey();
            int value = record.getValue();
            for(int i = 0 ; i < value ; i++){
                sb.append(key);
            }
        });
        return sb.toString();
    }
}
