package AkilliCihaz;

import java.util.List;

public interface IVeritabaniRepository {
    public boolean kullaniciAdiDogrulama(String kullaniciAdi);
    public boolean sifreDogrulama(String kullaniciAdi,String sifre);
    public List<InternetKullanicisi> tumInternetKullanicilari();
}
