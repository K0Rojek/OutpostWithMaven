package outPost.panele;

import outPost.PaczkomatGUI;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * klasa z panelem outpost, dziedzicząca JPanel
 */
public class PanelOutpost extends JPanel {
    public JLabel tytul;

    /**
     * konstruktor
     */
    public PanelOutpost() {
        // Ustawienie background kolor panelu
        setBackground(PaczkomatGUI.Kolory.kolorTlaTytulu);

        // Napis tytul
        tytul = new JLabel("OutPost");
        tytul.setFont(new Font(Font.DIALOG, Font.BOLD, 50));
        tytul.setHorizontalAlignment(JLabel.CENTER);

        // Dodanie napisu do panelu
        add(tytul);
    }
}
