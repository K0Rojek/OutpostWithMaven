package outPost.panele;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import outPost.PaczkomatGUI;
import outPost.przyciski.PrzyciskBazowy;
import outPost.przyciski.PrzyciskPowrot;

/**
 * klasa z panelem płatności, dziedzicząca JPanel
 */
public class PanelPlatnosc extends JPanel {
    public JButton buttonPowrot;
    public JButton buttonZaplac;
    public JLabel labelKwota;
    public double kwotaDoZaplaty;

    /**
     * konstruktor
     */
    public PanelPlatnosc() {
        setLayout(new GridBagLayout());
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);
        kwotaDoZaplaty = 19.99;

        // Buttony
        buttonPowrot = new PrzyciskPowrot();
        buttonZaplac = new PrzyciskBazowy("ZAPLAC KARTA");

        // Label z wyswietlona kwota do zaplaty
        labelKwota = new JLabel("KWOTA DO ZAPLATY: " + kwotaDoZaplaty);
        labelKwota.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
        labelKwota.setHorizontalAlignment(JLabel.CENTER);

        // Ulozenie elementow na gridzie
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 0); // Ustawienie odstępów między przyciskami
        
        add(labelKwota, gbc); gbc.gridy = 1;
        add(buttonZaplac, gbc); gbc.gridy = 2;
        add(buttonPowrot, gbc);
    }
}
