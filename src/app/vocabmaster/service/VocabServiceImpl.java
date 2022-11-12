package app.vocabmaster.service;

import app.vocabmaster.data.VocabRepository;
import app.vocabmaster.model.Vocab;
import app.vocabmaster.model.Word;

import java.util.List;

public class VocabServiceImpl implements VocabService {

    private VocabRepository repository;
    private Vocab currentVocab;

    @Override
    public List<Word> getAllWordsForToday() {
        return currentVocab.getTodayWords();
    }

    @Override
    public List<Word> getAllWords() {
        return currentVocab.getWords();
    }

    @Override
    public void addWord(Word word) {
        currentVocab.addWord(word);
        repository.setModified(currentVocab.getName());
    }

    @Override
    public Word getWord(String word) {
        return currentVocab.searchWord(word);
    }

    @Override
    public void editWord(String oldWordKey, Word editedWord) {
        Word oldWord = currentVocab.searchWord(oldWordKey);
        if (!oldWord.equals(editedWord)) {
            currentVocab.removeWord(oldWord);
            currentVocab.addWord(editedWord);
            repository.setModified(currentVocab.getName());
        }

    }

    @Override
    public Word deleteWord(Word word) {
        return null;
    }

    @Override
    public void setCurrentVocab(String vocabName) {
        currentVocab = repository.getVocab(vocabName);
    }

    public void setRepository(VocabRepository repository) {
        this.repository = repository;
    }
}
