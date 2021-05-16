import java.util.Random;

public class SicaklikAlgilayici {
    private SicaklikAlgilayici() {
    }

    private static SicaklikAlgilayici instance = null;


    public static SicaklikAlgilayici getInstance() {
        if (instance == null) {
            synchronized (SicaklikAlgilayici.class) {
                if (instance == null) {
                    instance = new SicaklikAlgilayici();
                }
            }
        }
        return instance;
    }


    private int temperature(Random rand) {


        return rand.nextInt(101);

    }

    public int readTemperature(Random rand) {

        return temperature(rand);

    }
}
