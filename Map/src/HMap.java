import java.util.Arrays;
import java.util.HashMap;

public class HMap {
    public static void main(String[] args) {
        // Find Frequency:-
        HashMap<String, Integer> frequency = new HashMap<>();

        String text = "  I live in Surat. Surat is an amazing place. Surat is safe. I enjoy living in Surat.  ??";
        String cleantext = text.replaceAll("[.,?]", "") 
                            .replace("\\s+", "\\s") 
                            .strip() 
                            .toLowerCase();

        String[] words = cleantext.split("\\s");
        System.out.println(Arrays.toString(words));

        for(String word : words) frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        System.out.println(frequency.toString());
    }   
}
