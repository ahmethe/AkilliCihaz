package AkilliCihaz;

public class InternetKullanicisi implements IObserver{
    private String kullaniciAdi;

    public InternetKullanicisi(String kullaniciAdi)
    {
        this.kullaniciAdi=kullaniciAdi;
    }

    public void guncelle(String durum) {
        System.out.println(kullaniciAdi+" kullanıcısına \"Sogutucu "+durum+" durumuna getirildi.\" mesajı gönderildi.");
    }
}
