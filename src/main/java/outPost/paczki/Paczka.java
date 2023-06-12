package outPost.paczki;

public class Paczka implements typPaczki {

    protected double rozmiarWysokosc;
    protected double rozmiarSzerokosc;
    protected double rozmiarGlebokosc;

    protected String numerTelefonuOdbiorcy;
    protected String numerTelefonuNadawcy;
    protected String kodPaczkomatuDocelowego;
    protected String kodPaczkomatuNadajcego;
    protected String kodOdbioru;

    protected boolean dostarczona;

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
