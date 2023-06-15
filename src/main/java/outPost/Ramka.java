package outPost;

import outPost.Outpost.*;

import javax.swing.JFrame;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static outPost.Outpost.serializePaczkomaty;

/**
 * klasa Ramka dziedzicząca JFrame
 */
public class Ramka extends JFrame {

    /**
     * konstruktor ramki, posiadający listener nasłuchujący zamknięcia okna
     */
    public Ramka() {
        //listener nasłuchujący eventu zamknięcia okna X
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //serializacja sie dzieje
                serializePaczkomaty();
                //właściwe zamkniecie okienka
                System.exit(0);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
    }
}
