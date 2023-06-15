package outPost.przyciski;

import java.awt.*;
/**
 * klasa z przyciskiem odbioru paczki, dziedzicząca z przycisku bazowego
 */
public class PrzyciskOdbierzPaczke extends PrzyciskBazowy {
    /**
     * konstruktor
     */
    public PrzyciskOdbierzPaczke() {
        setText("Odbierz paczkę");
        setPreferredSize(new Dimension(500, 80));
    }
}
