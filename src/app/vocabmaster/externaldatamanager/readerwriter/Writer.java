package app.vocabmaster.externaldatamanager.readerwriter;

import app.vocabmaster.model.Vocab;

import java.nio.file.Path;

public abstract class Writer {

    public abstract void writeVocab(Path path, Vocab vocab) ;

}
