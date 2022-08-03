package com.tlglearning.wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class WordCounter {
  private final Set<String> BORING_WORDS = Set.of("and", "of", "the", "in","on", "i", "then", "out", "a");

  private final Map<String, Integer> counts = new HashMap<>();

  private int totalWords;


  public Set<String> words() {
    return counts.keySet();
  }

  public int get(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(counts);
  }

  public void add(String text) {
    String trimmedLine = text.trim();
    if (!trimmedLine.isEmpty()) {
      String[] words = splitWords(trimmedLine);
      countWords(words);
    }
  }

  public int size(){
    return counts.size();
  }
   public int total(){
    return totalWords;
   }

  @Override
  public String toString() {
    return counts.toString();
  }

  String[] splitWords(String text) {
    return text
        .toLowerCase()
        .split("[\\W_]+");
  }
  // DONE Check if word is already present as a key in counts;
  //  if it's not present, add it to counts with a value of 1;
  //  otherwise, get the current value, add 1 to it, and update the map with the new value.

  void countWords(String[] words) {
    Arrays
        .stream(words)
        .map(String::trim)
        .filter((word) -> !word.isEmpty())
        .filter((word) -> word.length()> 5)
        .filter((word) -> !BORING_WORDS.contains(word))
        .forEach((word) -> counts.put(word, 1+ counts.getOrDefault(word, 0)));
//    for (String word : words) {
//      counts.put(word, get(word) + 1);
//      totalWords++;
//    }
  }


}
