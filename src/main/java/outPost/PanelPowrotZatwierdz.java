package outPost;

import outPost.przyciski.PrzyciskBazowy;
import outPost.przyciski.PrzyciskPowrot;
import outPost.przyciski.PrzyciskZatwierdz;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanelPowrotZatwierdz extends JPanel {
    public PrzyciskBazowy buttonZatwierdz, buttonPowrot;

    public PanelPowrotZatwierdz() {
        // Ustawienie atrybutow JPanel
        setLayout(new BorderLayout());
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);

        // Tworzenie przycisku "Zatwierdz"
        buttonZatwierdz = new PrzyciskZatwierdz();

        // Tworzenie przycisku "Powrót"
        buttonPowrot = new PrzyciskPowrot();

        // Dodanie buttonikow do JPanel
        add(buttonZatwierdz, BorderLayout.EAST);
        add(buttonPowrot, BorderLayout.WEST);
    }
}
