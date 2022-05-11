package AkilliCihaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLSurucu implements IVeritabaniRepository{

    private Connection baglan()
    {
        Connection conn=null;
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akillicihaz",
                    "postgres", "17.05.2001ahe39");

        } catch (Exception e) {
            System.out.println("Bağlantı girişimi başarısız !");
            e.printStackTrace();
        }
        return conn;
    }

    public boolean kullaniciAdiDogrulama(String kullaniciAdi) {

        Araclar.bekle(2000);

        boolean sonuc=false;

        Connection conn=this.baglan();

        try
        {
            String sql= "SELECT *  FROM \"KullaniciHesabi\" WHERE \"kullaniciadi\"=\'"+ kullaniciAdi+"\'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            sonuc=rs.next();

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sonuc;
    }

    public boolean sifreDogrulama(String kullaniciAdi,String sifre) {

        Araclar.bekle(2000);

        boolean sonuc=false;

        Connection conn=this.baglan();

        try
        {
            String sql= "SELECT *  FROM \"KullaniciHesabi\" WHERE \"kullaniciadi\"=\'"+ kullaniciAdi+"\'"+"AND \"sifre\"=\'"+sifre+"\'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            sonuc=rs.next();

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sonuc;
    }

    public List<InternetKullanicisi> tumInternetKullanicilari()
    {
        Araclar.bekle(2000);

        List<InternetKullanicisi> internetKullanicilari=new ArrayList<InternetKullanicisi>();

        Connection conn=this.baglan();

        try
        {
            String sql="SELECT * FROM \"KullaniciHesabi\"";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            String kullaniciAdi;

            while(rs.next())
            {
                kullaniciAdi=rs.getString("kullaniciadi");
                internetKullanicilari.add(new InternetKullanicisi(kullaniciAdi));
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return internetKullanicilari;
    }
}
