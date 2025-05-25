package com.proj.ResumeAnalyzer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JDmatcher {


    static public int calculteScore(String jobDescription, String resumeTxt) {
        List<String> words = extractKeywords(jobDescription);

        String resumeLowerCase = resumeTxt.toLowerCase();

        int matches = 0;
        for (String word : words) {
            if (resumeLowerCase.contains(word.toLowerCase())) {
                matches++;
            }
        }
        return (int) ((matches / (double) words.size()) * 100);
    }





    public static List<String> extractKeywords(String text) {
        return Arrays.stream(text.toLowerCase().split("\\W+"))  // splits on non-word characters
                .filter(word -> word.length() > 2)              // filter short/common words
                .distinct()
                .collect(Collectors.toList());
    }


}
