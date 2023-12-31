package outPost.panele;

import outPost.PaczkomatGUI;
import outPost.przyciski.PrzyciskBazowy;
import outPost.pola.PoleTekstoweBazowe;

import javax.swing.*;
import java.awt.*;

/**
 * klasa z panelem centrali, dziedzicząca JPanel
 */
public class PanelCentrala extends JPanel {
    public PrzyciskBazowy przyciskBazowy;
    public PoleTekstoweBazowe poleWysylka;

    /**
     * konstruktor klasy PanelCentrala
     */
    public PanelCentrala() {
        setLayout(new GridBagLayout());
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);

        // --------------------------Napisy--------------------------------
        // Napis kodu odbioru
        JLabel napisWysylka = new JLabel("Wpisz kod paczkomatu z ktorego chcesz przeslac paczki:");
        napisWysylka.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        napisWysylka.setHorizontalAlignment(JLabel.CENTER);


        // --------------------------Pola input------------------------------
        // Stworzenie trzech inputow
        poleWysylka = new PoleTekstoweBazowe();
        przyciskBazowy = new PrzyciskBazowy("WYSLIJ");

        // ---------------------------Grid--------------------------------

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 0); // Ustawienie odstępów między przyciskami

        // grid y, ustawia wiersz w jakim ma byc element
        gbc.gridy = 1;
        add(napisWysylka,gbc);
        gbc.gridy = 2;
        add(poleWysylka, gbc);
        gbc.gridy = 3;
        add(przyciskBazowy,gbc);

    }
}

