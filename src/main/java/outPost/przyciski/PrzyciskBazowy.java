package outPost.przyciski;

import outPost.PaczkomatGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

/**
 * klasa z bazowym przyciskiem, dziedziczącym JButton
 */
public class PrzyciskBazowy  extends JButton {

    public PrzyciskBazowy() {
        setText(" ");
        setBackground(PaczkomatGUI.Kolory.kolorPrzyciskow);
        setForeground(Color.DARK_GRAY);
        setFont(new Font("Tahoma", Font.BOLD, 28));
        setFocusPainted(false);
        setPreferredSize(new Dimension(250, 50));
    }
    /**
     * Konstruktor przycisku z zadanym tekstem
     * @param text treść przycisku
     */
    public PrzyciskBazowy(String text) {
        setText(text);
        setBackground(PaczkomatGUI.Kolory.kolorPrzyciskow);
        setForeground(Color.DARK_GRAY);
        setFont(new Font("Tahoma", Font.BOLD, 28));
        setFocusPainted(false);
        setPreferredSize(new Dimension(250, 50));
    }

}
