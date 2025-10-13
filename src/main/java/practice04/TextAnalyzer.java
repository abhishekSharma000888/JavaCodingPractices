package practice04;

import java.util.*;
import java.util.stream.Collectors;

class TextAnalyzer {

    private String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    // Count words
    public int countWords() {
        String[] words = text.split("\\s+");
        return words.length;
    }

    // Count sentences
    public int countSentences() {
        String[] sentences = text.split("[.!?]+");
        return sentences.length;
    }

    // Count vowels and consonants
    public Map<String, Integer> countVowelsAndConsonants() {
        int vowels = 0, consonants = 0;
        for (char ch : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) vowels++;
                else consonants++;
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("Vowels", vowels);
        result.put("Consonants", consonants);
        return result;
    }

    // Count digits and special characters
    public Map<String, Integer> countDigitsAndSpecialChars() {
        int digits = 0, special = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isDigit(ch)) digits++;
            else if (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) special++;
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("Digits", digits);
        result.put("SpecialCharacters", special);
        return result;
    }

    // Find most frequent words
    public List<String> mostFrequentWords(int topN) {
        String[] words = text.toLowerCase().split("\\W+");
        Map<String, Long> freqMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        return freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Find palindromes
    public List<String> findPalindromes() {
        String[] words = text.split("\\W+");
        return Arrays.stream(words)
                .filter(w -> w.length() > 1 && w.equalsIgnoreCase(new StringBuilder(w).reverse().toString()))
                .distinct()
                .collect(Collectors.toList());
    }
}
