package app.vocabmaster.externaldatamanager;

import java.nio.file.Path;
import java.util.HashMap;

public class PathManager {

    private HashMap<String, Path> paths;

    public void addPath(Path path, String vocabName) {
        paths.put(vocabName, path);
    }

    public Path getPath(String vocabName) {
        return paths.get(vocabName);
    }

    public boolean containsPath(String vocabName) {
        if (paths.containsKey(vocabName))
            return true;
        return false;
    }

}
