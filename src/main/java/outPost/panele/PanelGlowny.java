package outPost.panele;

import outPost.PaczkomatGUI;
import outPost.przyciski.PrzyciskADMIN;
import outPost.przyciski.PrzyciskBazowy;
import outPost.przyciski.PrzyciskNadajPaczke;
import outPost.przyciski.PrzyciskOdbierzPaczke;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * klasa z panelem głównym, dziedzicząca JPanel
 */
public class PanelGlowny extends JPanel{
    public JLabel napisWyboru;
    public PrzyciskBazowy buttonOdbierz, buttonNadaj, buttonADMIN;

    /**
     * konstruktor
     */
    public PanelGlowny() {
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);
        setLayout(new GridBagLayout());

        // --------------------------Napisy--------------------------------

        // Napis wyboru
        napisWyboru = new JLabel("Co chciałbyś dzisiaj zrobić?");
        napisWyboru.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        napisWyboru.setHorizontalAlignment(JLabel.CENTER);


        // ------------------------Przyciski----------------------------

        // Tworzenie button1 - odbierz paczke
        buttonOdbierz = new PrzyciskOdbierzPaczke();

        // // Tworzenie button2 - nadaj paczke
        buttonNadaj = new PrzyciskNadajPaczke();

        // Przycisk ADMIN
        buttonADMIN = new PrzyciskADMIN();

        // -----------------Action Listenery Przyciskow------------------


        // ---------------------------Grid--------------------------------

        // To sprawia ze mozemy ulozyc elementy w gridzie
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 30, 0); // Ustawienie odstępów między przyciskami

        gbc.gridy = 0; // wiersz 0 - to sprawia ze te 3 elementy nie nachodza na siebie a są pod sobą
        add(napisWyboru, gbc);
        gbc.gridy = 1; // wiersz 1
        add(buttonOdbierz, gbc);
        gbc.gridy = 2; // wiersz 2
        add(buttonNadaj, gbc);
        gbc.gridy = 3; // wiersz 3
        add(buttonADMIN, gbc);
    }
}
