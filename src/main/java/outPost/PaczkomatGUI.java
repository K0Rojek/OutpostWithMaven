package outPost;

import outPost.paczki.Paczka;
import outPost.paczki.PaczkaM;
import outPost.paczki.PaczkaS;
import outPost.paczki.PaczkaXXL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class PaczkomatGUI implements Comparable<PaczkomatGUI> {
    //private static final long serialVersionUID = 1L; //tymczasowo serialVersionUID z wartością domyślną

    public class Kolory {
        static final public Color kolorTlaTytulu = new Color(255, 224, 179);
        static final public Color kolorPrzyciskow = new Color(255, 218, 137);
    }

     Ramka ramka;
     PanelPIN panelPIN;
     PanelADMIN panelADMIN;
     PanelGlowny panelGlowny;
     PanelOutpost panelOutpost;
     PanelOdbioru panelOdbioru;
     PanelPlatnosc panelPlatnosc;
     PanelDanePaczki panelDanePaczki;
     PanelKoniecNadania panelKoniecNadania;
     PanelWybierzPaczke panelWybierzPaczke;
     PanelPowrotZatwierdz panelPowrotZatwierdz;
     PanelOtwarciaSkrytki panelOtwarciaSkrytki;

    String nazwaPaczkomatuX;

    // Paczka
    String nrTelefonuNadawcy;
    String nrTelefonuOdbiorcy;
    String kodPaczkomatuDocelowego;
    String kodOdbioru;
    int typPaczki;

    // Paczkomat
    String kodPaczkomatu;
    ArrayList<Paczka> listaPaczek;

    // ------------------------------- PACZKOMAT ----------------------------------------

    public PaczkomatGUI(String nazwaPaczkomatu, String kodPaczkomatu) {
        ramka =  new Ramka();
        ramka.setTitle(nazwaPaczkomatu);
        stworzPanele();

        this.nazwaPaczkomatuX = nazwaPaczkomatu;
        this.kodPaczkomatu = kodPaczkomatu;

        listaPaczek = new ArrayList<>();

        actionListenery();
    }


    public PaczkomatGUI() {
        ramka =  new Ramka();
        ramka.setTitle(nazwaPaczkomatuX);
        stworzPanele();
        actionListenery();
    }

    void stworzPanele(){
        panelPIN = new PanelPIN();
        panelADMIN = new PanelADMIN();
        panelGlowny = new PanelGlowny();
        panelOutpost = new PanelOutpost();
        panelOdbioru = new PanelOdbioru();
        panelPlatnosc = new PanelPlatnosc();
        panelDanePaczki = new PanelDanePaczki();
        panelKoniecNadania = new PanelKoniecNadania();
        panelWybierzPaczke = new PanelWybierzPaczke();
        panelPowrotZatwierdz = new PanelPowrotZatwierdz();
        panelOtwarciaSkrytki = new PanelOtwarciaSkrytki();
    }

    void actionListenery(){
        //--------------------------------- ACTION LISTENERY GUI ----------------------------------------

        // ------------------------------- PANEL PIN ----------------------------------------
        panelPIN.dolnyPanel.buttonPowrot.addActionListener(e -> {
            panelPIN.remove(panelPIN.napisZlyPIN);
            ramka.remove(panelPIN);
            ramka.add(panelGlowny);
            redraw();
        });

        panelPIN.dolnyPanel.buttonZatwierdz.addActionListener(e -> {
            if (panelPIN.polePIN.getText().equals(panelPIN.PIN)) {
                panelPIN.remove(panelPIN.napisZlyPIN);
                ramka.remove(panelPIN);
                ramka.add(panelADMIN);
                redraw();
            }
            else {
                panelPIN.add(panelPIN.napisZlyPIN, panelPIN.gbc);
                redraw();
            }
        });

        // ------------------------------- PANEL ADMIN ----------------------------------------
        panelADMIN.buttonPowrot.addActionListener(e -> {
            ramka.remove(panelADMIN);
            ramka.add(panelGlowny);
            redraw();
        });

        // ------------------------------- PANEL GLOWNY ----------------------------------------
        panelGlowny.buttonNadaj.addActionListener(e -> {
            ramka.remove(panelGlowny);
            ramka.add(panelWybierzPaczke, BorderLayout.CENTER);
            redraw();
        });

        panelGlowny.buttonOdbierz.addActionListener(e -> {
            ramka.remove(panelGlowny);
            ramka.add(panelOdbioru, BorderLayout.CENTER);
            redraw();
        });

        panelGlowny.buttonADMIN.addActionListener(e -> {
            panelADMIN.listaPaczek = listaPaczek;
            panelADMIN.setTekstPaczek();
            System.out.println(listaPaczek.toString());
            ramka.remove(panelGlowny);
            ramka.add(panelPIN);
            redraw();
        });

        // ------------------------------- PANEL KONIEC NADANIA ----------------------------------------
        panelKoniecNadania.buttonPowrot.addActionListener(e -> {
            ramka.remove(panelKoniecNadania);
            ramka.add(panelGlowny);
            redraw();
        });

        // ------------------------------- PANEL ODBIORU ----------------------------------------
        panelOdbioru.dolnyPanel.buttonPowrot.addActionListener(e -> {
            ramka.remove(panelOdbioru);
            ramka.add(panelGlowny);
            panelOdbioru.remove(panelOdbioru.zleDane);
            redraw();
        });

        panelOdbioru.dolnyPanel.buttonZatwierdz.addActionListener(e -> {
            // ----------------- Sprawdzanie danych i usuwanie z listy --------------------------------
            boolean flaga = false;
            for (Paczka p : listaPaczek){
                if(p.getKodOdbioru().equals(panelOdbioru.poleKodOdbioru.getText()) &&
                        p.getNumerTelefonuOdbiorcy().equals(panelOdbioru.poleTelefon.getText()) &&
                        p.isDostarczona()){
                    listaPaczek.remove(p);
                    flaga = true;
                    break;
                }
            }
            if(!flaga){
                panelOdbioru.add(panelOdbioru.zleDane,panelOdbioru.gbc);
                redraw();
            }
            else{
                ramka.remove(panelOdbioru);
                ramka.add(panelOtwarciaSkrytki);
                redraw();
//                Timer timer = new Timer(5000, new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        ramka.remove(panelOtwarciaSkrytki);
//                        ramka.add(panelGlowny);
//                        redraw();
//                    }
//                });
//                timer.setRepeats(false);
//                timer.start();
            }
        });

        // ------------------------------- PANEL OTWARCIA SKRYTKI ----------------------------------------
        panelOtwarciaSkrytki.buttonPowrot.addActionListener(e -> {
            ramka.remove(panelOtwarciaSkrytki);
            ramka.add(panelGlowny);
            redraw();
            ramka.repaint();
        });

        // ------------------------------- PANEL PLATNOSC ----------------------------------------
        // ------------------------ DODAWANIE PACZEK DO LISTY TUTAJ ----------------------------------------
        panelPlatnosc.buttonPowrot.addActionListener(e -> {
            ramka.remove(panelPlatnosc);
            ramka.add(panelDanePaczki);
            redraw();
        });

        panelPlatnosc.buttonZaplac.addActionListener(e -> {
            Paczka paczkaDoNadania;
            stworzKodOdbioru();
            String wymiarPaczki = "";
            switch (typPaczki){
                case 1 -> paczkaDoNadania = new PaczkaXXL(nrTelefonuOdbiorcy,nrTelefonuNadawcy,kodPaczkomatuDocelowego,kodPaczkomatu,false,kodOdbioru);
                case 2 -> paczkaDoNadania = new PaczkaM(nrTelefonuOdbiorcy,nrTelefonuNadawcy,kodPaczkomatuDocelowego,kodPaczkomatu,false,kodOdbioru);
                case 3 -> paczkaDoNadania = new PaczkaS(nrTelefonuOdbiorcy,nrTelefonuNadawcy,kodPaczkomatuDocelowego,kodPaczkomatu,false,kodOdbioru);
                default -> paczkaDoNadania = new PaczkaXXL();
            }
            listaPaczek.add(paczkaDoNadania);
            wymiarPaczki = paczkaDoNadania.wyswietlKod(); // Polimorficzne wywołanie
            wymiarPaczki = "Twoj rozmiar paczki to: " + wymiarPaczki + " , Kod Twojej paczki to: " + kodOdbioru;
            JOptionPane.showMessageDialog(ramka,wymiarPaczki);
            ramka.remove(panelPlatnosc);
            ramka.add(panelKoniecNadania);
            redraw();
        });

        // ------------------------------- PANEL WYBIERZ PACZKE ----------------------------------------
        panelWybierzPaczke.buttonXXL.addActionListener(e -> {
            typPaczki = 1;
            ramka.remove(panelWybierzPaczke);
            ramka.add(panelDanePaczki);
            redraw();
        });

        // ButtonM onClick
        panelWybierzPaczke.buttonM.addActionListener(e -> {
            typPaczki = 2;
            ramka.remove(panelWybierzPaczke);
            ramka.add(panelDanePaczki);
            redraw();
        });

        // ButtonS onClick
        panelWybierzPaczke.buttonS.addActionListener(e -> {
            typPaczki = 3;
            ramka.remove(panelWybierzPaczke);
            ramka.add(panelDanePaczki);
            redraw();
        });

        panelWybierzPaczke.przyciskPowrot.addActionListener(e -> {
            ramka.remove(panelWybierzPaczke);
            ramka.add(panelGlowny, BorderLayout.CENTER);
            redraw();
        });

        // ------------------------------- PANEL DANE PACZKI ----------------------------------------
        panelDanePaczki.dolnyPanel.buttonPowrot.addActionListener(e -> {
            ramka.remove(panelDanePaczki);
            ramka.add(panelWybierzPaczke);
            redraw();
        });

        panelDanePaczki.dolnyPanel.buttonZatwierdz.addActionListener(e -> {
            kodPaczkomatuDocelowego = panelDanePaczki.poleKodPaczkomatu.getText();
            nrTelefonuNadawcy = panelDanePaczki.poleTelefonNadawcy.getText();
            nrTelefonuOdbiorcy = panelDanePaczki.poleTelefonOdbiorcy.getText();

            try {
                if ( kodPaczkomatuDocelowego.isEmpty() || nrTelefonuOdbiorcy.isEmpty() || nrTelefonuNadawcy.isEmpty() ) {
                    throw new WprowadzonoBledneDaneWyjatek(ramka);
                }
                else {
                    boolean flaga = false;
                    for(PaczkomatGUI paczkomacik:Outpost.paczkomaty) {
                        if(kodPaczkomatuDocelowego == paczkomacik.kodPaczkomatu)
                            flaga = true;
                    }
                    if (flaga != true) {
                        throw new WprowadzonoBledneDaneWyjatek(ramka);
                    }
                    else {
                        ramka.remove(panelDanePaczki);
                        ramka.add(panelPlatnosc);
                        redraw();
                    }
                }
            }
            catch (WprowadzonoBledneDaneWyjatek ex) {
                ex.napisBledneDane();
            }
        });

        ramka.add(panelOutpost, BorderLayout.NORTH);
        ramka.add(panelGlowny, BorderLayout.CENTER);
        ramka.setVisible(true);
        redraw();
    }

    void redraw() {
        ramka.revalidate();
        ramka.repaint();
    }

    void stworzKodOdbioru(){
        int kodLiczba = (int) ((Math.random() * (9999 - 1000)) + 1000);
        System.out.println(kodLiczba);
        kodOdbioru = Integer.toString(kodLiczba);

    }

    public String getKodPaczkomatu() {
        return this.kodPaczkomatu;
    }
    public ArrayList<Paczka> getListaPaczek() {
        return this.listaPaczek;
    }
    public void setListaPaczek(ArrayList<Paczka> listaPaczek) {
        this.listaPaczek = listaPaczek;
    }
    public String getNazwaPaczkomatuX() {
        return nazwaPaczkomatuX;
    }
    @Override
    public int compareTo(PaczkomatGUI o) {
        return 0;
    }
}
