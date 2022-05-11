package AkilliCihaz;

import java.util.ArrayList;
import java.util.List;

public class Sogutucu implements ISogutucu{
    private String durum;
    private List<IObserver> observers=new ArrayList<IObserver>();
    public Sogutucu()
    {
        durum="Kapali";
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
        observerlaraBildir();
    }

    public void observerKaydet(IObserver observer) {
        observers.add(observer);
    }

    public void observerSil(IObserver observer) {
        observers.remove(observer);
    }

    public void observerlaraBildir() {
        for(var observer : observers) observer.guncelle(durum);
    }
}
