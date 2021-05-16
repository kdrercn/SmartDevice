import java.util.Scanner;

public class Sogutucu {

    public static void main(String[] args) {

        System.out.println("-----------------------------------------------------");
        System.out.println("\t\tHoşgeldiniz - Welcome");
        System.out.println("-----------------------------------------------------");

        System.out.print("Kullanıcı Adı/Username : ");
        Scanner input = new Scanner(System.in);
        String user_name = input.next();
        System.out.print("\nŞifre/Password : ");
        String pass_word = input.next();


        if (Database.getInstance().veritabaniOku(user_name, pass_word)) {
            while (true) {


                System.out.println("\n1-) Cihazı Aç - Open Device\n\n2-) Sıcaklığı Görüntüle - Show Temperature\n\n3-) Soğutucuyu Aç - Open Cooler\n\n4-) Soğutucuyu Kapat - Close Cooler\n\n5-) Cihazı Kapat - Close Device\n\n6-) Kullanıcı Çıkışı - Exit\n\n");
                Scanner inputted = new Scanner(System.in);
                int choice = inputted.nextInt();

                if (choice == 1) {

                    AnaIslemPlatformu.getInstance().cihaziAc(CihazDurumu.getInstance());


                } else if (choice == 2) {

                    if (CihazDurumu.getInstance().cihazAcikMi()) {
                        AnaIslemPlatformu.getInstance().showTemperature(SicaklikAlgilayici.getInstance(), CihazDurumu.getInstance());
                    } else {
                        System.out.println("Cihaz kapalı durumdayken işlem yapamazsınız.");
                    }

                } else if (choice == 3) {


                    if (CihazDurumu.getInstance().cihazAcikMi()) {
                        AnaIslemPlatformu.getInstance().sogutucuAc(Eyleyici.getInstance());
                    } else {
                        System.out.println("Cihaz kapalı durumdayken işlem yapamazsınız.");
                    }

                } else if (choice == 4) {


                    if (CihazDurumu.getInstance().cihazAcikMi()) {
                        AnaIslemPlatformu.getInstance().sogutucuKapat(Eyleyici.getInstance());
                    } else {
                        System.out.println("Cihaz kapalı durumdayken işlem yapamazsınız.");
                    }

                } else if (choice == 5) {

                    if (CihazDurumu.getInstance().cihazAcikMi()) {
                        AnaIslemPlatformu.getInstance().cihaziKapat(CihazDurumu.getInstance());
                    } else {
                        System.out.println("Cihaz zaten kapalı");
                    }

                } else if (choice == 6) {
                    break;
                }


            }
        } else {
            System.out.println("Sistemde kullanıcı kaydınız bulunmamaktadır.");
        }

    }
}
