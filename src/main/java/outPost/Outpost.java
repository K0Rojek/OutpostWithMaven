package outPost;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import outPost.paczki.Paczka;
import outPost.panele.PanelCentrala;
import outPost.panele.PanelOutpost;

/**
 * klasa zawierająca metodę main
 */
public class Outpost{
    Ramka ramka;
    PanelOutpost panelOutpost = new PanelOutpost();
    PanelCentrala panelCentrala = new PanelCentrala();
    static ArrayList<PaczkomatGUI> paczkomaty = new ArrayList<>();

    /**
     * metoda main
     * @param args argumenty wykonania
     */
    public static void main(String[] args) {
        Outpost outpost = new Outpost();
//        PaczkomatGUI paczkomat1 = new PaczkomatGUI("Paczkomat Krakow 1111", "1111");
//        PaczkomatGUI paczkomat2 = new PaczkomatGUI("Paczkomat Myslenice 2222", "2222"); // <3
//
//        paczkomaty.add(paczkomat1);
//        paczkomaty.add(paczkomat2);
    }

    /**
     * konstruktor klasy Outpost, w którym na start dane z pliku są deserializowane
     */
    public Outpost() {
        try {
            paczkomaty = deserializePaczkomaty();
            for (PaczkomatGUI paczkomacik:paczkomaty) {
                paczkomacik.ramka.setTitle(paczkomacik.getNazwaPaczkomatuX());
                paczkomacik.ramka.setVisible(true);
            }
        }
        catch(Exception e) {
            paczkomaty = new ArrayList<>();
        }

        ramka = new Ramka();
        ramka.setTitle("CENTRALA");
        ramka.add(panelOutpost);
        ramka.add(panelCentrala);
        ramka.setVisible(true);

        panelCentrala.przyciskBazowy.addActionListener(e -> {
            przeslijPaczki(panelCentrala.poleWysylka.getText());
        });
    }

    /**
     * metoda przesyla paczki z paczkomaty nadawczego do docelowego
     * @param kod kod paczkomatu nadawczego
     */
    void przeslijPaczki(String kod) {
        PaczkomatGUI paczkomat = znajdzPaczkomatZaPomocaKodu(kod);
        if (paczkomat != null) {
            ArrayList<Paczka> listaPaczek = new ArrayList<>(paczkomat.getListaPaczek());
            Iterator<Paczka> iterator = listaPaczek.iterator();
            while (iterator.hasNext()) {
                Paczka paczka = iterator.next();
                PaczkomatGUI paczkomatDocelowy = znajdzPaczkomatZaPomocaKodu(paczka.getKodPaczkomatuDocelowego());
                paczka.setDostarczona(paczkomatDocelowy.getKodPaczkomatu() == paczkomat.getKodPaczkomatu());
                if (paczkomatDocelowy != null && !paczka.isDostarczona()) {
                    paczka.setDostarczona(true);
                    paczkomatDocelowy.getListaPaczek().add(paczka);
                    iterator.remove();
                }
            }
            paczkomat.setListaPaczek(listaPaczek);
        }
    }

    /**
     * metoda znajduje paczkomat przy pomocy kodu
     * @param kod kod paczkomatu
     * @return szukany paczkomat lub null
     */
    PaczkomatGUI znajdzPaczkomatZaPomocaKodu(String kod) {
        for (PaczkomatGUI paczkomat : paczkomaty) {
            if (kod.equals(paczkomat.getKodPaczkomatu())) {
                return paczkomat;
            }
        }
        return null;
    }

    /**
     * metoda serializuje paczkomaty i ich zawartość
     */
    public static void serializePaczkomaty() {
        File xmlik = new File("paczkomaty1.xml");
        XmlMapper mapper = new XmlMapper();
        try {
            mapper.writeValue(xmlik,paczkomaty);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * metoda deserializuje paczkomaty
     * @return array list z paczkomatami
     */
    public static ArrayList<PaczkomatGUI> deserializePaczkomaty() {
        File xmlik = new File("paczkomaty1.xml");
        XmlMapper mapper = new XmlMapper();
        try {
            return  mapper.readValue(xmlik,new TypeReference<ArrayList<PaczkomatGUI>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}