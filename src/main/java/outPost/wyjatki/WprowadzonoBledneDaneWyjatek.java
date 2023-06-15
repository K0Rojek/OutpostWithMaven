package outPost.wyjatki;

import javax.swing.*;

/**
 * klasa dla wyjątku dotyczącego wprowadzenia w GUI błędnych danych
 */
public class WprowadzonoBledneDaneWyjatek extends Exception{
    /**
     * ramka z klasy JFrame
     */
    JFrame ramka;

    /**
     * wyjątek
     * @param ramka ramka
     */
    public WprowadzonoBledneDaneWyjatek(JFrame ramka) {
        this.ramka = ramka;
    }

    /**
     * metoda do wyświetlenia komunikatu o błędnych danych
     */
    public void napisBledneDane() {
        JOptionPane.showMessageDialog(ramka,"Wprowadzono bledne dane!");
    }
}
