package app.vocabmaster.service;

import app.vocabmaster.model.Word;

import java.util.List;

public interface VocabService {

    void setCurrentVocab(String vocabName);
    List<Word> getAllWordsForToday();
    List<Word> getAllWords();

    void addWord(Word word);
    Word getWord(String word);
    void editWord(String oldWord, Word editedWord);
    Word deleteWord(Word word);

}
