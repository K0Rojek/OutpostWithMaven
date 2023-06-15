package outPost.paczki;

/**
 * klasa dla małej paczki, dziedzicząca Paczkę
 */
public class PaczkaS extends Paczka {
    /**
     * stała szerokosc
     */
    final double szerokosc = 10.0;
    /**
     * stała wysokosc
     */
    final double wysokosc = 10.0;
    /**
     * stała glebokosc
     */
    final double glebokosc = 10.0;
    /**
     * konstruktor dla małej Paczki
     * @param numerTelefonuOdbiorcy numer telefonu odbiorcy
     * @param numerTelefonuNadawcy numer telefonu nadawcy
     * @param kodPaczkomatuDocelowego kod paczkomatu docelowego
     * @param kodPaczkomatuNadajcego kod paczkomatu nadawczego
     * @param czyDostarczona informacja czy paczka została dostarczona
     * @param kodOdbioru kod odbioru paczki
     */
    public PaczkaS(String numerTelefonuOdbiorcy,
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
        return "S";
    }
}
