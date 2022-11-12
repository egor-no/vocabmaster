package app.vocabmaster.service;

import app.vocabmaster.model.Vocab;

public interface LibraryService {

    Vocab getVocab(String name);
    void addVocab(Vocab newVocab);
    void saveVocab(Vocab editedVocab);

}
