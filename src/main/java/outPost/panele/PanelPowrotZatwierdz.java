package outPost.panele;

import outPost.PaczkomatGUI;
import outPost.przyciski.PrzyciskBazowy;
import outPost.przyciski.PrzyciskPowrot;
import outPost.przyciski.PrzyciskZatwierdz;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * klasa z panelem powróć/zatwierdź, dziedzicząca JPanel
 */
public class PanelPowrotZatwierdz extends JPanel {
    public PrzyciskBazowy buttonZatwierdz, buttonPowrot;

    /**
     * konstruktor
     */
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
