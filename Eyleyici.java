public class Eyleyici {
    private static Eyleyici instance = null;

    private Eyleyici() {
    }

    private void SogutucuKapat() {
        CihazDurumu.getInstance().sogutucuDurumuKapali();
    }

    private void SogutucuAc() {
        CihazDurumu.getInstance().sogutucuDurumuAcik();
    }

    public static Eyleyici getInstance() {
        if (instance == null) {
            synchronized (Eyleyici.class) {
                if (instance == null) {
                    instance = new Eyleyici();
                }
            }
        }
        return instance;
    }

    public void closeCooler() {
        SogutucuKapat();
    }

    public void openCooler() {
        SogutucuAc();
    }

}
