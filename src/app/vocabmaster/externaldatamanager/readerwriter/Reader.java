package app.vocabmaster.externaldatamanager.readerwriter;

import app.vocabmaster.model.Vocab;

import java.nio.file.Path;

public abstract class Reader {

    public abstract Vocab readVocab(Path path);
}
