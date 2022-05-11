package AkilliCihaz;

public interface IAgArayuzu {
    public void mesajGoruntule(String mesaj);
    public String stringVeriAl();
    public int intVeriAl();
    public void sicaklikGonder(ISicaklikAlgilayici sicaklikAlgilayici);
    public void erisimSonlandir();
    public void sogutucuyuAc(IEyleyici eyleyici);
    public void sogutucuyuKapat(IEyleyici eyleyici);
}
