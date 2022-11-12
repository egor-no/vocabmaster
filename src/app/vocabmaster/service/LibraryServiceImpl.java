package app.vocabmaster.service;

import app.vocabmaster.data.VocabRepository;
import app.vocabmaster.model.Vocab;

public class LibraryServiceImpl implements LibraryService {

    private VocabRepository repository;

    @Override
    public Vocab getVocab(String name) {
        return repository.getVocab(name);
    }

    @Override
    public void addVocab(Vocab newVocab) {
        repository.createVocab(newVocab);
    }

    @Override
    public void saveVocab(Vocab editedVocab) {

    }

    public void setRepository(VocabRepository repository) {
        this.repository = repository;
    }
}
