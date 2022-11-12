package app.vocabmaster.data;

import app.vocabmaster.model.Vocab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VocabRepository {

    private HashMap<String, Vocab> vocabs;
    private List<String> modifiedVocabs;

    public VocabRepository() {
        vocabs = new HashMap<>();
        modifiedVocabs = new ArrayList<>();
    }

    public Vocab getVocab(String name) {
        return vocabs.get(name);
    }

    public void createVocab(Vocab newVocab) {
        vocabs.put(newVocab.getName(), newVocab);
        modifiedVocabs.add(newVocab.getName());
    }

    public void addVocab(Vocab vocab) {
        vocabs.put(vocab.getName(), vocab);
    }

    public void setModified(String name) {
        modifiedVocabs.add(name);
    }

    public void clearModificationStatus(String name) {
        modifiedVocabs.remove(name);
    }

    public List<Vocab> getAllModified() {
        return modifiedVocabs.stream()
                .map(name -> {
                    return vocabs.get(name);
                })
                .collect(Collectors.toList());
    }

}
