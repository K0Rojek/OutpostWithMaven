package outPost.panele;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import outPost.PaczkomatGUI;
import outPost.przyciski.PrzyciskPowrot;

/**
 * klasa z panelem na koniec nadania, dziedzicząca JPanel
 */
public class PanelKoniecNadania extends JPanel {
    public JButton buttonPowrot;
    public JLabel labelPlatnosc;
    public JLabel labelPlatnosc2;

    /**
     * konstruktor
     */
    public PanelKoniecNadania() {
        setLayout(new GridBagLayout());
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);

        // Buttony
        buttonPowrot = new PrzyciskPowrot();

        // Label z wyswietlona kwota do zaplaty
        labelPlatnosc = new JLabel("PLATNOSC ZAAKCEPTOWANA");
        labelPlatnosc.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
        labelPlatnosc.setHorizontalAlignment(JLabel.CENTER);

        labelPlatnosc2 = new JLabel("PROSZE WLOZYC PACZKE DO SKRYTKI");
        labelPlatnosc2.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
        labelPlatnosc2.setHorizontalAlignment(JLabel.CENTER);

        // Ulozenie elementow na gridzie
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 0); // Ustawienie odstępów między przyciskami
        
        add(labelPlatnosc, gbc); gbc.gridy = 1;
        add(labelPlatnosc2, gbc); gbc.gridy = 2;
        add(buttonPowrot, gbc);
    }

}
