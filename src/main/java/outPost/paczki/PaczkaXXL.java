package outPost.paczki;

/**
* klasa dla dużej paczki, dziedzicząca Paczkę
*/
public class PaczkaXXL extends Paczka {
    /**
     * stała szerokosc
     */
    final double szerokosc = 20.0;
    /**
     * stała wysokosc
     */
    final double wysokosc = 20.0;
    /**
     * stała glebokosc
     */
    final double glebokosc = 20.0;

    /**
     * domyślny konstruktor dla dużej paczki
     */
    public PaczkaXXL() {};
    /**
     * konstruktor dla dużej Paczki
     * @param numerTelefonuOdbiorcy numer telefonu odbiorcy
     * @param numerTelefonuNadawcy numer telefonu nadawcy
     * @param kodPaczkomatuDocelowego kod paczkomatu docelowego
     * @param kodPaczkomatuNadajcego kod paczkomatu nadawczego
     * @param czyDostarczona informacja czy paczka została dostarczona
     * @param kodOdbioru kod odbioru paczki
     */
    public PaczkaXXL(String numerTelefonuOdbiorcy,
                   String numerTelefonuNadawcy,
                   String kodPaczkomatuDocelowego,
                   String kodPaczkomatuNadajcego,
                   boolean czyDostarczona,
                   String kodOdbioru) {

        super(numerTelefonuOdbiorcy,
                numerTelefonuNadawcy,
                kodPaczkomatuDocelowego,
                kodPaczkomatuNadajcego,
                czyDostarczona,
                kodOdbioru);

        rozmiarSzerokosc = szerokosc;
        rozmiarWysokosc = wysokosc;
        rozmiarGlebokosc = glebokosc;
    }
    @Override
    public String wyswietlTyp(){
        return "XXL";
    }
}
