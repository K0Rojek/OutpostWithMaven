package outPost.panele;

import javax.swing.*;

import outPost.PaczkomatGUI;
import outPost.przyciski.PrzyciskBazowy;
import outPost.paczki.Paczka;

import java.awt.*;
import java.util.ArrayList;


/**
 * klasa z panelem admina, dziedzicząca JPanel
 */
public class PanelADMIN extends JPanel {
    public JPanel panelPaczki;
    public JLabel labelADMIN;
    public JLabel labelPaczki;
    public JButton buttonPowrot;

    public ArrayList<Paczka> listaPaczek;

    /**
     * konstruktor klasy PanelADMIN
     */
    public PanelADMIN() {
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);
        setLayout(new BorderLayout());
        listaPaczek = new ArrayList<>();

        // Header
        labelADMIN = new JLabel("PACZKI W PACZKOMACIE:");
        labelADMIN.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
        labelADMIN.setHorizontalAlignment(JLabel.CENTER);
        labelADMIN.setForeground(Color.RED);

        // Panel na wyswietlanie listy paczek
        panelPaczki = new JPanel(new BorderLayout());
        panelPaczki.setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);

        // Label do paczek
        labelPaczki = new JLabel();
        labelPaczki.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        labelPaczki.setHorizontalAlignment(JLabel.CENTER);

        // Scroll do paczek
        JScrollPane scrollPane = new JScrollPane(panelPaczki);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // ButtonPowrot
        buttonPowrot = new PrzyciskBazowy("Powrót");

        add(labelADMIN, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPowrot, BorderLayout.SOUTH);
    }

    /**
     * metoda labelująca paczuszki
     */
    public void setTekstPaczek() {
        String paczki = "<html> ";
        for (Paczka p: listaPaczek) {
            paczki += p.toString() + "<br>"; // POLIMORFIZM
        }
        paczki += "</html>";

        labelPaczki.setText(paczki);
        panelPaczki.add(labelPaczki, BorderLayout.NORTH);
    }
}
