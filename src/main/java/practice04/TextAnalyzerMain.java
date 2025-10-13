package practice04;

import java.util.Map;
import java.util.Scanner;

// Main class
public class TextAnalyzerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text (type 'END' on a new line to finish):");
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("END")) break;
            sb.append(line).append(" ");
        }

        String text = sb.toString().trim();
        TextAnalyzer analyzer = new TextAnalyzer(text);

        System.out.println("\n--- Text Analysis ---");
        System.out.println("Total Words: " + analyzer.countWords());
        System.out.println("Total Sentences: " + analyzer.countSentences());

        Map<String, Integer> vc = analyzer.countVowelsAndConsonants();
        System.out.println("Vowels: " + vc.get("Vowels"));
        System.out.println("Consonants: " + vc.get("Consonants"));

        Map<String, Integer> ds = analyzer.countDigitsAndSpecialChars();
        System.out.println("Digits: " + ds.get("Digits"));
        System.out.println("Special Characters: " + ds.get("SpecialCharacters"));

        System.out.println("Top 5 Frequent Words: " + analyzer.mostFrequentWords(5));
        System.out.println("Palindromes: " + analyzer.findPalindromes());

        sc.close();
    }
}