package app.vocabmaster.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vocab {

    private String name;
    private String languageFrom;
    private String languageTo;
    private String description;
    private List<Word> words;
    private final VocabScheduler scheduler;

    public Vocab(String name, String languageFrom, String languageTo) {
        this.name = name;
        this.languageFrom = languageFrom;
        this.languageTo = languageTo;
        words = new ArrayList<>();
        scheduler = new VocabScheduler();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public boolean removeWord(Word word) {
        return words.remove(word);
    }

    public List<Word> getTodayWords() {
        return scheduler.getTodayWords();
    }

    public Word searchWord(String key) {
        return words.stream().filter(word -> {
            return word.getWord().equals(key);
        })
            .findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguageFrom() {
        return languageFrom;
    }

    public void setLanguageFrom(String languageFrom) {
        this.languageFrom = languageFrom;
    }

    public String getLanguageTo() {
        return languageTo;
    }

    public void setLanguageTo(String languageTo) {
        this.languageTo = languageTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public boolean contains(Word word) {
        if (searchWord(word.getWord()) != null)
            return true;
        return false;
    }

    private class VocabScheduler {

        private List<Word> getTodayWords() {
            return words.stream()
                    .filter(word -> { return word.getScheduledDate().isBefore(LocalDate.now().plusDays(1)); })
                    .collect(Collectors.toList());
        }
    }
}
