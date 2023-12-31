package outPost.panele;

import outPost.PaczkomatGUI;
import outPost.pola.PoleTekstoweBazowe;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * klasa z panelem z danymi paczki, dziedzicząca JPanel
 */
public class PanelDanePaczki extends JPanel{

    public PanelPowrotZatwierdz dolnyPanel;
    public PoleTekstoweBazowe poleTelefonNadawcy, poleTelefonOdbiorcy, poleKodPaczkomatu;

    /**
     * konstruktor
     */
    public PanelDanePaczki() {
        setLayout(new GridBagLayout());
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);

        // Tworze panel dolny(przycsik powrot i zatwierdz) i dodaje onClicki
        dolnyPanel = new PanelPowrotZatwierdz();


        // --------------------------Napisy--------------------------------
        // Napis NrNadawcy
        JLabel napisTelefonNadawcy = new JLabel("Wpisz swoj numer:");
        napisTelefonNadawcy.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        napisTelefonNadawcy.setHorizontalAlignment(JLabel.CENTER);

        // Napis NrOdbiorcy
        JLabel napisTelefonOdbiorcy  = new JLabel("Wpisz numer odbiorcy:");
        napisTelefonOdbiorcy.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        napisTelefonOdbiorcy.setHorizontalAlignment(JLabel.CENTER);

        // Napis kodPaczkomatu
        JLabel napisKodPaczkomatu  = new JLabel("Wpisz kod paczkomatu:");
        napisKodPaczkomatu.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        napisKodPaczkomatu.setHorizontalAlignment(JLabel.CENTER);

        // --------------------------Pola input------------------------------
        // Stworzenie trzech inputow
        poleTelefonNadawcy = new PoleTekstoweBazowe();
        poleTelefonOdbiorcy = new PoleTekstoweBazowe();
        poleKodPaczkomatu = new PoleTekstoweBazowe();

        // ---------------------------Grid--------------------------------

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 0); // Ustawienie odstępów między przyciskami

        // grid y, ustawia wiersz w jakim ma byc element
        gbc.gridy = 1;
        add(napisTelefonNadawcy,gbc);

        gbc.gridy = 2;
        add(poleTelefonNadawcy, gbc);

        gbc.gridy = 3;
        add(napisTelefonOdbiorcy,gbc);

        gbc.gridy = 4;
        add(poleTelefonOdbiorcy, gbc);

        gbc.gridy = 5;
        add(napisKodPaczkomatu, gbc);

        gbc.gridy = 6;
        add(poleKodPaczkomatu, gbc);

        gbc.gridy = 7;
        add(dolnyPanel, gbc);
    }
}
