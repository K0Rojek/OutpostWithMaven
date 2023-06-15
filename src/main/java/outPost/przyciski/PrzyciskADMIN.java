package outPost.przyciski;

import java.awt.Dimension;

/**
 * klasa z przyciskiem admina, dziedzicząca z przycisku bazowego
 */
public class PrzyciskADMIN extends PrzyciskBazowy {

    /**
     * konstruktor
     */
    public PrzyciskADMIN() {
        setText("ADMIN");
        setPreferredSize(new Dimension(200, 50));
    }
}
