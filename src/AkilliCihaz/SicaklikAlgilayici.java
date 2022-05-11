package AkilliCihaz;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{
    public int sicaklikOku()
    {
        Random random=new Random();
        int sicaklik= random.nextInt(15);
        return sicaklik;
    }
}
