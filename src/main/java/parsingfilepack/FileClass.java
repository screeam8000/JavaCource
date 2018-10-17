package parsingfilepack;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileClass {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        Map<String, String> inData = parseFile();
        Document doc = readXml();


        inData.entrySet().forEach(e->{
            getNode(e.getKey(),doc).setTextContent(e.getValue());
            System.out.println(getNode(e.getKey(), doc).getTextContent());
            System.out.println(getNode(e.getKey(),doc).getAttribute("value"));
            //Как вытащить значение из тэга?
        });

//        doc.getTextContent()

    }

    public static Element getNode (String name, Document document) {

        NodeList nodeList = document.getChildNodes().item(0).getChildNodes();
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            if ((nNode.getNodeType() == Node.ELEMENT_NODE) &&
                    (nNode.getNodeName().equals(name))) {
                return (Element) nNode;
            }
        }

        return null;
    }

    private static Map<String, String> parseFile() throws IOException {
        HashMap<String, String> data = new HashMap<>();

        Files.readAllLines(Paths.get("C:\\file2.txt"))
                .forEach(l -> {
                    String[] tmp = l.split(":");
                    data.put(tmp[0].trim(), tmp[1].trim());
                });

        return data;

    }

    public static Document readXml() throws  IOException, SAXException, ParserConfigurationException{

        File fxmlFile = new File("1.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBiilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = dBiilder.parse(fxmlFile);

        doc.getDocumentElement().normalize();

        return doc;

    }
}
