package AkilliCihaz;

import java.util.ArrayList;
import java.util.List;

public class AkilliCihaz implements IAkilliCihaz{
    private final IEyleyici eyleyici;
    private final IAgArayuzu agArayuzu;
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private final IVeritabaniRepository veritabani;
    private final ISogutucu sogutucu;

    private static final int SICAKLIK_GORUNTULEME=1;
    private static final int SOGUTUCUYU_ACMA=2;
    private static final int SOGUTUCUYU_KAPATMA=3;
    private static final int CIKIS=4;

    public AkilliCihaz(Eyleyici eyleyici,SicaklikAlgilayici sicaklikAlgilayici,AgArayuzu agArayuzu,IVeritabaniRepository veritabani,Sogutucu sogutucu)
    {
        this.eyleyici=eyleyici;
        this.sicaklikAlgilayici=sicaklikAlgilayici;
        this.agArayuzu=agArayuzu;
        this.veritabani=veritabani;
        this.sogutucu=sogutucu;
    }

    public void basla() {
        kullaniciDogrulama();
    }

    private void islemSecimi()
    {
        int secim;

        List<InternetKullanicisi> internetKullanicilari=new ArrayList<InternetKullanicisi>();
        internetKullanicilari=veritabani.tumInternetKullanicilari();

        for(int index=0;index<internetKullanicilari.size();++index)
            sogutucu.observerKaydet(internetKullanicilari.get(index));

        do {
            secim=anaMenuGoster();
            switch(secim){
                case SICAKLIK_GORUNTULEME:
                    agArayuzu.sicaklikGonder(sicaklikAlgilayici);
                    break;
                case SOGUTUCUYU_ACMA:
                    if(sogutucu.getDurum().equals("Acik")) agArayuzu.mesajGoruntule("Sogutucu acik.");
                    else
                    {
                        agArayuzu.sogutucuyuAc(eyleyici);
                        sogutucu.setDurum("Acik");
                    }
                    break;
                case SOGUTUCUYU_KAPATMA:
                    if(sogutucu.getDurum().equals("Kapali")) agArayuzu.mesajGoruntule("Sogutucu kapali.");
                    else
                    {
                        agArayuzu.sogutucuyuKapat(eyleyici);
                        sogutucu.setDurum("Kapali");
                    }
                    break;
                case CIKIS:
                    agArayuzu.erisimSonlandir();
                    break;
                default:
                    agArayuzu.mesajGoruntule("1-4 arasinda bir sayi girmelisiniz");
            }
        }while(secim!=4);
    }

    private int anaMenuGoster()
    {
        agArayuzu.mesajGoruntule("*******************************");
        agArayuzu.mesajGoruntule("Ana Menu");
        agArayuzu.mesajGoruntule("1-Sicaklik Goruntuleme");
        agArayuzu.mesajGoruntule("2-Sogutucuyu Acma");
        agArayuzu.mesajGoruntule("3-Sogutucuyu Kapatma");
        agArayuzu.mesajGoruntule("4-Cikis");
        agArayuzu.mesajGoruntule("*******************************");
        agArayuzu.mesajGoruntule("Seciminiz: ");
        return agArayuzu.intVeriAl();
    }

    private void kullaniciDogrulama()
    {
        int sayac=0;

        String kullaniciAdi=null;

        do {
            agArayuzu.mesajGoruntule("Kullanici adi: ");
            kullaniciAdi=agArayuzu.stringVeriAl();
            boolean kullaniciAdiSonuc=veritabani.kullaniciAdiDogrulama(kullaniciAdi);
            if(kullaniciAdiSonuc)
            {
                agArayuzu.mesajGoruntule("Kullanici adi dogrulandi.");
                sayac=3;
                sifreDogrulama(kullaniciAdi);
            }
            else
            {
                agArayuzu.mesajGoruntule("Kullanici adi dogrulanamadi...");
                sayac++;
                if(sayac==3) agArayuzu.erisimSonlandir();
            }
        }while(sayac!=3);
    }

    private void sifreDogrulama(String kullaniciAdi)
    {
        int sayac=0;

        do {
            agArayuzu.mesajGoruntule("Sifre: ");
            String sifre=agArayuzu.stringVeriAl();
            boolean sonuc=veritabani.sifreDogrulama(kullaniciAdi,sifre);
            if(sonuc)
            {
                agArayuzu.mesajGoruntule("Sifre dogrulandi.");
                sayac=3;
                islemSecimi();
            }
            else
            {
                agArayuzu.mesajGoruntule("Sifre dogrulanamadi...");
                sayac++;
                if(sayac==3) agArayuzu.erisimSonlandir();
            }
        }while(sayac!=3);
    }
}
