package AkilliCihaz;

import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu{
    public void mesajGoruntule(String mesaj)
    {
        System.out.println(mesaj);
    }

    public String stringVeriAl() {
        Scanner input=new Scanner(System.in);
        return input.nextLine();
    }

    public int intVeriAl() {
        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }

    public void sicaklikGonder(ISicaklikAlgilayici sicaklikAlgilayici)
    {
        mesajGoruntule("Sicaklik okunuyor...");
        Araclar.bekle(1500);
        mesajGoruntule("Sicaklik: "+sicaklikAlgilayici.sicaklikOku()+"°C");
    }

    public void sogutucuyuAc(IEyleyici eyleyici)
    {
        mesajGoruntule("Sogutucu aciliyor...");
        eyleyici.sogutucuyuAc();
        mesajGoruntule("Sogutucu acildi.");
    }

    public void sogutucuyuKapat(IEyleyici eyleyici)
    {
        mesajGoruntule("Sogutucu kapatiliyor...");
        eyleyici.sogutucuyuKapat();
        mesajGoruntule("Sogutucu kapatildi.");
    }

    public void erisimSonlandir()
    {
        mesajGoruntule("Erisim sonlandiriliyor...");
        Araclar.bekle();
    }
}
