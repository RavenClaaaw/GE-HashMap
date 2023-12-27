import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HMap {
    public static void main(String[] args) {
        HMap functions = new HMap();

        String text = "  I live in Surat. Surat is an amazing place. Surat is safe. I enjoy living in Surat.  ??";
        functions.findFrequency(text);
        functions.findIndex(text);

        functions.removeWord(text, "Surat");
    }

    public void findFrequency(String text){
        // Find Frequency:-
        HashMap<String, Integer> frequency = new HashMap<>();

        String cleantext = cleanText(text);

        String[] words = cleantext.split("\\s");
        System.out.println(Arrays.toString(words));

        for(String word : words) frequency.put(word, frequency.getOrDefault(word, 0) + 1);

        System.out.println("\nFREQUENCY:- ");
        System.out.println(frequency.toString());
    }

    public void findIndex(String text){
        HashMap<String, ArrayList<Integer>> indexes = new HashMap<>();

        String cleantext = cleanText(text);

        String[] words = cleantext.split("\\s");
        System.out.println(Arrays.toString(words));

        for(int i=0; i<words.length; i++){
            if(!indexes.containsKey(words[i])){
                indexes.put(words[i], new ArrayList<>());
            }

            indexes.get(words[i]).add(i);
        }

        System.out.println("\nINDEXES:- ");
        System.out.println(indexes.toString());
    }

    public String removeWord(String text, String removeWord){
        String cleantext = cleanText(text);
        String[] words = cleantext.split("\\s");

        ArrayList<String> tokens = new ArrayList<>();
        for(String word : words){
            if(removeWord.compareToIgnoreCase(word) != 0){
                tokens.add(word);
            }
        }

        String processed = String.join(" ", tokens);
        System.out.printf("\nWORD REMOVAL:- (%s) = %s", removeWord, processed);
        return processed;
    }

    public String cleanText(String text){
        return text.replaceAll("[.,?]", "") 
                            .replace("\\s+", "\\s") 
                            .strip() 
                            .toLowerCase();
    }
}
