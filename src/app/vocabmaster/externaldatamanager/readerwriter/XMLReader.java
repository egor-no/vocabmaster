package app.vocabmaster.externaldatamanager.readerwriter;

import app.vocabmaster.model.Vocab;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.vocabmaster.model.Word;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLReader extends Reader {

    @Override
    public Vocab readVocab(Path path) {
        Vocab vocab = null;
        try {
            Document doc = null;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(path.toFile());

            Element root = doc.getDocumentElement();

            String name = root.getAttributes().getNamedItem("name").getTextContent();
            String languageFrom = root.getAttributes().getNamedItem("to").getTextContent();
            String languageTo = root.getAttributes().getNamedItem("from").getTextContent();
            vocab = new Vocab(name, languageFrom, languageTo);

            NodeList info = root.getElementsByTagName("info");
            if (info.getLength() > 0) {
                String description = info.item(0).getTextContent();
                vocab.setDescription(description);
            }

            NodeList words = root.getElementsByTagName("word");
            for (int i = 0; i < words.getLength(); i++) {
                if (words.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element wordEl = (Element) words.item(i);
                    String original = wordEl.getElementsByTagName("original").item(0).getTextContent();

                    NodeList translationNodes = wordEl.getElementsByTagName("translation");
                    List<String> translations = new ArrayList<>();
                    for (int j = 0; j<translationNodes.getLength(); j++) {
                        translations.add(translationNodes.item(j).getTextContent());
                    }

                    String skipdays = wordEl.getAttributes().getNamedItem("skipdays").getTextContent();
                    String dateString = wordEl.getElementsByTagName("nextdate").item(0).getTextContent();
                    LocalDate date = LocalDate.parse(dateString);

                    Word word = new Word(original, translations,
                            Integer.parseInt(skipdays), date);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }

        return vocab;
    }
}
