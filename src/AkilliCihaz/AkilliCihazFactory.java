package AkilliCihaz;

public class AkilliCihazFactory {
    public static IAkilliCihaz factoryMethod()
    {
        Eyleyici eyleyici=new Eyleyici();
        AgArayuzu agArayuzu=new AgArayuzu();
        SicaklikAlgilayici sicaklikAlgilayici=new SicaklikAlgilayici();
        IVeritabaniRepository veritabanı=new PostgreSQLSurucu();
        Sogutucu sogutucu=new Sogutucu();
        AkilliCihaz akilliCihaz=new AkilliCihaz(eyleyici,sicaklikAlgilayici,agArayuzu,veritabanı,sogutucu);
        return akilliCihaz;
    }
}
