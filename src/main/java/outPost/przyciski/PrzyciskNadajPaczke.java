package outPost.przyciski;

import java.awt.*;

/**
 * klasa z przyciskiem nadania paczki, dziedzicząca z przycisku bazowego
 */
public class PrzyciskNadajPaczke extends PrzyciskBazowy {
    /**
     * konstruktor
     */
    public PrzyciskNadajPaczke() {
        setText("Nadaj paczkę");
        setPreferredSize(new Dimension(500, 80));
    }
}
