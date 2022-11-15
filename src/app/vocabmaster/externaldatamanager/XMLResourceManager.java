package app.vocabmaster.externaldatamanager;

import app.vocabmaster.data.VocabRepository;
import app.vocabmaster.externaldatamanager.readerwriter.Reader;
import app.vocabmaster.externaldatamanager.readerwriter.Writer;
import app.vocabmaster.model.Vocab;

import java.net.URI;
import java.nio.file.Path;
import java.util.HashMap;

public class XMLResourceManager implements ResourceManager {

    private PathManager pathManager = new PathManager();
    private VocabRepository repository;
    private Reader reader;
    private Writer writer;

    @Override
    public void readVocab(String filepath) {
        URI uri = URI.create(filepath);
        Path path = Path.of(uri);

        Vocab vocab = reader.readVocab(path);

        pathManager.addPath(path, vocab.getName());
        repository.addVocab(vocab);
    }

    @Override
    public void saveVocab(String vocabName) {
        Path path = pathManager.getPath(vocabName);

        writer.writeVocab(path, repository.getVocab(vocabName));
    }

    private void saveVocab(Vocab vocab) {
        Path path = pathManager.getPath(vocab.getName());

        writer.writeVocab(path, vocab);
    }

    @Override
    public void saveAllUnsaved() {
        repository.getAllModified().forEach(this::saveVocab);
    }

    public void setRepository(VocabRepository repository) {
        this.repository = repository;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }


}
