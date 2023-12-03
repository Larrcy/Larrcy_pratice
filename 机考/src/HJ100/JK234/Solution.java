package HJ100.JK234;
import java.util.*;
//字符串重新排列
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strs = s.split(" ");
        HashMap<String, Word> wordMap = new HashMap<>();
        ArrayList<Word> words = new ArrayList<>();

        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedChars= new String(strChars);

            if (!wordMap.containsKey(sortedChars)) {
                Word newWord = new Word(sortedChars, 1, str.length());
                wordMap.put(sortedChars, newWord);
                words.add(newWord);
            } else {
                wordMap.get(sortedChars).count++;
            }
        }

        words.sort((a, b) -> {
            if (a.count != b.count) {
                return b.count - a.count;
            }
            if (a.length != b.length) {
                return a.length - b.length;
            }
            return a.word.compareTo(b.word);
        });
        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            for (int j = 0; j < word.count; j++) {
                sb.append(word.word).append(" ");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}

    class Word {
        String word;
        int count;
        int length;

        public Word(String word, int count, int length) {
            this.word = word;
            this.count = count;
            this.length = length;
        }
    }


