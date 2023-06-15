package outPost.panele;

import javax.swing.JPanel;

import outPost.PaczkomatGUI;
import outPost.pola.PoleTekstoweBazowe;
import javax.swing.*;
import java.awt.*;

/**
 * klasa z panelem PIN, dziedzicząca JPanel
 */
public class PanelPIN extends JPanel {
    public PanelPowrotZatwierdz dolnyPanel;
    public PoleTekstoweBazowe polePIN;
    public JLabel napisZlyPIN;
    public final String PIN;
    public GridBagConstraints gbc;

    /**
     * konstruktor
     */
    public PanelPIN() {
        PIN =  "1234";
        setLayout(new GridBagLayout());
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);

        // Tworze panel dolny(przycsik powrot i zatwierdz) i dodaje onClicki
        dolnyPanel = new PanelPowrotZatwierdz();

        // --------------------------Napisy--------------------------------
        JLabel napisPIN = new JLabel("WPROWADZ PIN:");
        napisPIN.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        napisPIN.setHorizontalAlignment(JLabel.CENTER);

        napisZlyPIN = new JLabel("WPROWADZONO ZLY PIN, SPROBÓJ PONOWNIE");
        napisZlyPIN.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        napisZlyPIN.setHorizontalAlignment(JLabel.CENTER);
        napisZlyPIN.setForeground(Color.RED);

        // --------------------------Pola input------------------------------
        polePIN = new PoleTekstoweBazowe();

        // ---------------------------Grid--------------------------------
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 0); // Ustawienie odstępów między przyciskami

        // grid y, ustawia wiersz w jakim ma byc element
        add(napisPIN, gbc);
        gbc.gridy = 1;
        add(polePIN, gbc);
        gbc.gridy = 2;
        add(dolnyPanel, gbc);
        gbc.gridy = 3;


    }
}
