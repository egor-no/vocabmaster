package app.vocabmaster.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Word {

    private String word;
    private List<String> translations;
    private final WordScheduler wordScheduler;

    public Word(String word, String translation) {
        this.word = word;
        this.translations = new ArrayList<>();
        translations.add(translation);
        wordScheduler = new WordScheduler();
    }

    public Word(String word, List<String> translations) {
        this.word = word;
        this.translations = new ArrayList<>();
        translations.addAll(translations);
        wordScheduler = new WordScheduler();
    }

    public Word(String word, List<String> translations, int skipDays, LocalDate date) {
        this.word = word;
        this.translations = new ArrayList<>();
        translations.addAll(translations);
        wordScheduler = new WordScheduler(skipDays, date);
    }

    public void addTranslation(String variant) {
        translations.add(variant);
    }

    public void removeTranslation(String variant) {
        translations.remove(variant);
    }

    public void parseAndAddTranslations(String translations) {

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public LocalDate getScheduledDate() {
        return wordScheduler.nextScheduledDate;
    }

    public void setScheduledDate(LocalDate newDate) {
        wordScheduler.nextScheduledDate = newDate;
    }

    public int getSkipDays() {
        return wordScheduler.daysSkip;
    }

    public void setSkipDays(int skipDays) {
        wordScheduler.daysSkip = skipDays;
    }

    private class WordScheduler {
        private int daysSkip;
        private LocalDate nextScheduledDate;

        private WordScheduler() {
            daysSkip = 1;
            nextScheduledDate = LocalDate.now().plusDays(1);
        }

        private WordScheduler(int daysSkip, LocalDate date) {
            this.nextScheduledDate = date;
            this.daysSkip = daysSkip;
        }
    }
}
