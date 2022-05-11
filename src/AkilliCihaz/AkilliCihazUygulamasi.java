package AkilliCihaz;

public class AkilliCihazUygulamasi {
    public static void main(String[] args){
        IAkilliCihaz akilliCihaz=AkilliCihazFactory.factoryMethod();
        akilliCihaz.basla();
    }
}
