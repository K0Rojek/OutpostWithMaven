package outPost;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Testowa {
    public static void main(String[] args) {
        PaczkomatGUI paczkamat = new PaczkomatGUI("XD","XDDKOD");
        XmlMapper x = new XmlMapper();
        String xml = "";
        try {
            xml = x.writeValueAsString(paczkamat);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(xml);
    }
}
