package outPost.paczki;

/**
 * klasa Paczka, która zawiera wszystkie informacje o paczce oraz implementuje interfejs typPaczki
 */
public class Paczka implements typPaczki {

    protected double rozmiarWysokosc;
    protected double rozmiarSzerokosc;
    protected double rozmiarGlebokosc;

    protected String numerTelefonuOdbiorcy;
    protected String numerTelefonuNadawcy;
    protected String kodPaczkomatuDocelowego;
    protected String kodPaczkomatuNadajcego;
    protected String kodOdbioru;

    /**
     * boolowska zmienna, przechowyjąca informacje o tym czy paczka zostala dostarczona
     */
    protected boolean dostarczona;

    /**
     * konstruktor dla klasy Paczka
     * @param numerTelefonuOdbiorcy numer telefonu odbiorcy
     * @param numerTelefonuNadawcy numer telefonu nadawcy
     * @param kodPaczkomatuDocelowego kod paczkomatu docelowego
     * @param kodPaczkomatuNadajcego kod paczkomatu nadawczego
     * @param dostarczona informacja czy paczka została dostarczona
     * @param kodOdbioru kod odbioru paczki
     */
    public Paczka(String numerTelefonuOdbiorcy,
                  String numerTelefonuNadawcy,
                  String kodPaczkomatuDocelowego,
                  String kodPaczkomatuNadajcego,
                  boolean dostarczona,
                  String kodOdbioru) {
        this.numerTelefonuOdbiorcy = numerTelefonuOdbiorcy;
        this.numerTelefonuNadawcy = numerTelefonuNadawcy;
        this.kodPaczkomatuDocelowego = kodPaczkomatuDocelowego;
        this.kodPaczkomatuNadajcego = kodPaczkomatuNadajcego;
        this.dostarczona = dostarczona;
        this.kodOdbioru = kodOdbioru;
    }

    /**
     * domyślny konstruktor dla klasy Paczka
     */
    public Paczka() {};

    @Override
    public String toString() {
        return "Paczka\n"  +
                "wysokosc = " + rozmiarWysokosc +
                "szerokosc = " + rozmiarSzerokosc +
                "glebokosc = " + rozmiarGlebokosc +

                "numerOdbiorcy =" + numerTelefonuOdbiorcy +
                " numerNadawcy =" + numerTelefonuNadawcy +
                " kodPaczkomatuDoc =" + kodPaczkomatuDocelowego +
                " czyDostarczona =" + isDostarczona();
    }

    @Override
    public String wyswietlTyp(){
        return "Default";
    }
    public String getNumerTelefonuOdbiorcy() {
        return numerTelefonuOdbiorcy;
    }
    public String getKodPaczkomatuDocelowego() {
        return kodPaczkomatuDocelowego;
    }
    public String getKodOdbioru() {
        return kodOdbioru;
    }
    public boolean isDostarczona() {
        return dostarczona;
    }
    public void setDostarczona(boolean dostarczona) {
        this.dostarczona = dostarczona;
    }

    public double getRozmiarWysokosc() {
        return rozmiarWysokosc;
    }
    public double getRozmiarSzerokosc() {
        return rozmiarSzerokosc;
    }
    public double getRozmiarGlebokosc() { return rozmiarGlebokosc;}
    public String getNumerTelefonuNadawcy() {
        return numerTelefonuNadawcy;
    }
    public String getKodPaczkomatuNadajcego() {
        return kodPaczkomatuNadajcego;
    }

}
