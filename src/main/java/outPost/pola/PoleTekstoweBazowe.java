package outPost.pola;

import javax.swing.*;
import java.awt.*;


/**
 * klasa dla pola tekstowego, dziedzicząca JTextField
 */
public class PoleTekstoweBazowe extends JTextField {

    /**
     * domyślny konstruktor dla pola tekstowego
     */
    public PoleTekstoweBazowe() {
        setFont(new Font("Tahoma", Font.BOLD, 13));
        setHorizontalAlignment(JTextField.CENTER);
        setPreferredSize(new Dimension(200, 40));
    }

    /**
     * Konstruktor pola tekstowego z zadanym tekstem
     * @param text treść pola tekstowego
     */
    public PoleTekstoweBazowe(String text) {
        setText(text);
        setFont(new Font("Tahoma", Font.BOLD, 13));
        setHorizontalAlignment(JTextField.CENTER);
        setPreferredSize(new Dimension(200, 40));
    }
}
