package app.vocabmaster.externaldatamanager;

import app.vocabmaster.data.VocabRepository;
import app.vocabmaster.model.Vocab;

public interface ResourceManager {

    public void readVocab(String filepath);
    public void saveVocab(String vocabName);
    public void saveAllUnsaved();
}
