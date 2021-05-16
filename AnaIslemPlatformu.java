import java.util.Random;

public class AnaIslemPlatformu {
    private AnaIslemPlatformu() {
    }

    private static AnaIslemPlatformu instance = null;


    public static AnaIslemPlatformu getInstance() {
        if (instance == null) {
            synchronized (AnaIslemPlatformu.class) {
                if (instance == null) {
                    instance = new AnaIslemPlatformu();
                }
            }
        }
        return instance;
    }


    public void showTemperature(SicaklikAlgilayici read, CihazDurumu status) {
        Random r = new Random();
        status.controlDevice();
        System.out.println(read.readTemperature(r) + " Derece");
    }


    public void sogutucuAc(Eyleyici eyleyici) {
        eyleyici.openCooler();
    }

    public void sogutucuKapat(Eyleyici eyleyici) {
        eyleyici.closeCooler();
    }

    public void cihaziKapat(CihazDurumu cDurumu) {
        cDurumu.closeDevice();
    }

    public void cihaziAc(CihazDurumu cDurumu) {
        cDurumu.waitDevice();
    }
}
