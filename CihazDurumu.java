public class CihazDurumu {

    private CihazDurumu() {
    }


    private String deviceStatus = "Cihaz açık ve beklemede";

    private String coolerStatus;


    private static CihazDurumu instance = null;

    public static CihazDurumu getInstance() {
        if (instance == null) {
            synchronized (CihazDurumu.class) {
                if (instance == null) {
                    instance = new CihazDurumu();
                }
            }
        }
        return instance;
    }


    public void closeDevice() {
        deviceStatus = "Cihaz Kapatıldı";
        System.out.println(deviceStatus);
    }

    public void waitDevice() {
        deviceStatus = "Cihaz açık ve beklemede";
        System.out.println(deviceStatus);
    }

    public void controlDevice() {
        deviceStatus = "Cihaz kontrol durumunda";
        System.out.println(deviceStatus);
    }


    public void sogutucuDurumuKapali() {
        coolerStatus = "Soğutucu Kapatıldı";
        System.out.println(coolerStatus);
    }

    public void sogutucuDurumuAcik() {
        coolerStatus = "Soğutucu Açıldı";
        System.out.println(coolerStatus);
    }

    public boolean cihazAcikMi() {
        if (deviceStatus.equals("Cihaz Kapatıldı")) {
            return false;
        } else {
            return true;
        }

    }
}
