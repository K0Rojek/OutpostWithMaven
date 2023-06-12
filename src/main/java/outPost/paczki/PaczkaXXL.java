package outPost.paczki;

public class PaczkaXXL extends Paczka{
    final double szerokosc = 20.0;
    final double wysokosc = 20.0;
    final double glebokosc = 20.0;
    public PaczkaXXL() {};
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
