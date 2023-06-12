package outPost;

import javax.swing.*;

public class WprowadzonoBledneDaneWyjatek extends Exception{
    JFrame ramka;
    public WprowadzonoBledneDaneWyjatek(JFrame ramka) {
        this.ramka = ramka;
    }
    void napisBledneDane() {
        JOptionPane.showMessageDialog(ramka,"Wprowadzono bledne dane!");
    }
}
