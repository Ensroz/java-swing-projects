package Hafta11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.net.HttpURLConnection;
import java.io.InputStreamReader;

public class proje_2416501082 {
    //Türkçe karakterler için UTF8'i aktif etmek için konsola chcp 65001 yaziniz
    public static void main(String[] args) throws IOException {
        String dosyaAdi="d:\\meals.txt";
        
        Scanner giris=new Scanner(System.in);
        int secim;
        boolean cikis=false;
        while(!cikis){
        System.out.println("[1] Veriyi al ve dosyaya yazdir");
        System.out.println("[2] Listele");
        System.out.println("[3] güncelle");
        System.out.println("[4] sil");
        System.out.println("[5] çikiş");
        secim=giris.nextInt();
        giris.nextLine();
        switch(secim){
        case 1: AlmaDosyayaYazdirma();
                break;
        case 2: VeriyiListele();
        break;
        case 3: VeriyiGüncelle();
        break;
        
        case 4: VeriyiSil();
        break;
        case 5:
        cikis=true; 
        break;
        default:
        System.out.println("Geçersiz seçim, tekrar deneyiniz");
        break;       






        }
        }
        System.out.println("Program sonlandiriliyor...");


        }
        public static void AlmaDosyayaYazdirma(){
    try {
        File file=new File("d:\\meals.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

        URI uri = URI.create(apiURL);
        URL url = uri.toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder result = new StringBuilder();
        String satir;
        while ((satir = reader.readLine()) != null) {
            result.append(satir);
        }
        reader.close();

        String json = result.toString();

        
        List<String> yemekAdlari = parcaGetir(json, "\"strMeal\":\"");
        List<String> yemekTurleri = parcaGetir(json, "\"strCategory\":\"");
        List<String> ulkeler = parcaGetir(json, "\"strArea\":\"");
        List<String> tarifler = parcaGetir(json, "\"strInstructions\":\"");
        
        

 
        if (yemekAdlari.size() == yemekTurleri.size() &&
            yemekAdlari.size() == tarifler.size() &&
            yemekAdlari.size() == ulkeler.size()) {

            BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\meals.txt", false));
            for (int i = 0; i < yemekAdlari.size(); i++) {
                String tarif = tarifler.get(i).replace("\n", " ").replace("\r", " ");
                String satirYaz = yemekAdlari.get(i) + ";" + yemekTurleri.get(i) + ";" + ulkeler.get(i) + ";" + tarif;

                writer.write(satirYaz);
                writer.newLine();
            }
            writer.close();

            System.out.println("Veriler dosyaya başariyla yazildi .");
        } else {
            System.out.println("Veri uzunluklari eşleşmiyor.");
        }

    } catch (Exception e) {
        System.out.println("Hata oluştu: " + e.getMessage());
    }finally {
        System.out.println("Veri başariyla çekildi.");
        System.out.println("Veri başariyla dosyaya yazdirildi.");
    }



        }
        public static void VeriyiSil(){
        Scanner giris=new Scanner(System.in);
        int secim;
        boolean cikis=false;
        while(!cikis){
            System.out.println("[1] yumurta bulunan yemekleri sil");
            System.out.println("[2] Tavuk yemeklerini sil");
            System.out.println("[3] cikis");
            secim=giris.nextInt();
            giris.nextLine();
            switch(secim){
                case 1: YumurtaSil();
                break;
                case 2: TavukSil(); 
                break;
                case 3: cikis=true;
                break;
                default : System.out.println("Hatali secim tekrar deneyiniz");
            }
        }

        }
        public static void TavukSil(){
                  Scanner giris = new Scanner(System.in);
    String dosyaAdi = "d:\\meals.txt";
    List<String> yeniListe = new ArrayList<>();
    List<String> silinecekler = new ArrayList<>();

    try {
        BufferedReader oku = new BufferedReader(new FileReader(dosyaAdi));
        String satir;

       
        while ((satir = oku.readLine()) != null) {
            if (satir.toLowerCase().contains("chicken")) {
                silinecekler.add(satir);
            } else {
                yeniListe.add(satir);
            }
        }
        oku.close();

        // 
        if (silinecekler.isEmpty()) {
            System.out.println("Tavuk içeren yemek bulunamadı.");
            return;
        }

        System.out.println("Tavuk içeren yemekler:");
        for (String s : silinecekler) {
            System.out.println(s);
        }

        System.out.print("Bu veriler silinsin mi? (e/h): ");
        String secim = giris.nextLine().trim().toLowerCase();

        if (secim.equals("e")) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi));
            for (String yeniSatir : yeniListe) {
                writer.write(yeniSatir);
                writer.newLine();
            }
            writer.close();
            System.out.println("Tavuk içeren yemekler başariyla silindi.");
        } else {
            System.out.println("Silme işlemi iptal edildi.");
        }

    } catch (IOException e) {
        System.out.println("Silme işleminde hata oluştu: " + e.getMessage());
    }
        }
      
    public static void YumurtaSil(){
         Scanner giris = new Scanner(System.in);
    String dosyaAdi = "d:\\meals.txt";
    List<String> yeniListe = new ArrayList<>();
    List<String> silinecekler = new ArrayList<>();

    try {
        BufferedReader oku = new BufferedReader(new FileReader(dosyaAdi));
        String satir;

       
        while ((satir = oku.readLine()) != null) {
            if (satir.toLowerCase().contains("egg")) {
                silinecekler.add(satir);
            } else {
                yeniListe.add(satir);
            }
        }
        oku.close();

        // 
        if (silinecekler.isEmpty()) {
            System.out.println("Yumurta içeren yemek bulunamadı.");
            return;
        }

        System.out.println("Yumurta içeren yemekler:");
        for (String s : silinecekler) {
            System.out.println(s);
        }

        System.out.print("Bu veriler silinsin mi? (e/h): ");
        String secim = giris.nextLine().trim().toLowerCase();

        if (secim.equals("e")) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi));
            for (String yeniSatir : yeniListe) {
                writer.write(yeniSatir);
                writer.newLine();
            }
            writer.close();
            System.out.println("Yumurta içeren yemekler başarıyla silindi.");
        } else {
            System.out.println("Silme işlemi iptal edildi.");
        }

    } catch (IOException e) {
        System.out.println("Silme işleminde hata oluştu: " + e.getMessage());
    }
 

   
    }




        
        public static void VeriyiListele(){
        boolean cikis =false;
        int secim;
        Scanner giris=new Scanner(System.in);
        while(!cikis){
            System.out.println("[1] Ülkeye göre listele");
            System.out.println("[2] içinde yumurta bulunan yemekleri listele");
            System.out.println("[3] İstediğiniz harf ile başlayan yemekleri listele");
            System.out.println("[4] favori yemek türünü listele");
            System.out.println("[5] Bütün yemekleri listele");
            System.out.println("[6] İstediğiniz yemeğin tarifi");
            System.out.println("[7] çikiş");
        
       
        secim=giris.nextInt();
        giris.nextLine();
        switch(secim){
            case 1: ÜlkeListele();
            break;
            case 2: YumurtaListele();
            break;
            case 3: HarfiListele();
            break;
            case 4:  YemekTürüListele();
            break;
            case 5: HepsiniListele();
            break;
            case 6: TarifiListele();
            break;
            case 7: cikis=true;
            break;
            default: System.out.println("Yanliş seçim tekrar deneyiniz");
            break;

        }
        }

            
        

        }
        public static void TarifiListele(){
        Scanner giris=new Scanner(System.in);
        System.out.println("İstediğiniz yemeği giriniz");
        String yemek;
        yemek=giris.nextLine().toLowerCase();
        try{
            String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + URLEncoder.encode(yemek, "UTF-8");

            URI uri = URI.create(apiURL);
            URL url = uri.toURL();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            String json = result.toString();
List<String> meals = parcaGetir(json, "\"strMeal\":\"");
List<String> instructions = parcaGetir(json, "\"strInstructions\":\"");
if(meals!=null){
    System.out.println("yemek:"+meals);
    System.out.println("Tarifi: "+instructions);

}
        }
        catch(IOException e){
            System.out.println("Hata oluştu."+e.getMessage());
        }
        }
        public static void HepsiniListele(){
        try{
            String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

            URI uri = URI.create(apiURL);
            URL url = uri.toURL();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            String json = result.toString();
          List  <String> meal = parcaGetir(json, "\"strMeal\":\"");
          if(meal!=null){
            System.out.println("Yemekler:");
            for(String sonuc :meal){
                System.out.println(sonuc);
            }

          }


        }
        catch(Exception e){
            System.out.println("Hata oluştu."+e.getMessage());
        }



        }
      
        public static void ÜlkeListele(){
            try{
                String ülke;
                Scanner giris=new Scanner(System.in);
                System.out.println("Bir ülke giriniz");
                ülke=giris.nextLine().toLowerCase();

                
                String apiURL = "https://www.themealdb.com/api/json/v1/1/filter.php?a="+ URLEncoder.encode(ülke, "UTF-8");

            URI uri = URI.create(apiURL);
            URL url = uri.toURL();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            String json=result.toString();
            List<String> meals = parcaGetir(json, "\"strMeal\":\"");
           if (meals!=null) {
                System.out.println(ülke + " mutfağindan yemekler:");
                for (String sonuc : meals) {
                    System.out.println(sonuc);
                }
            } else {
                System.out.println(ülke + " mutfağindan yemek bulunamadı.");
            }

        } catch (Exception e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
            

            }
          

            
            
            
            
            
           



        
         static List <String> parcaGetir(String veri, String anahtar) {
       List<String> sonuc = new ArrayList<>();
        int i = 0;
        while ((i = veri.indexOf(anahtar, i)) != -1) {
            int basla = i + anahtar.length();
            int bitis = veri.indexOf("\"", basla);
            if (bitis == -1) break;
            String parca = veri.substring(basla, bitis).replace("\\r\\n", "\n");
            sonuc.add(parca);
            i = bitis + 1;
        
    }
    return sonuc;
}
    public static void YumurtaListele(){
        
    try {
        String yumurta = "egg";
        String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + URLEncoder.encode(yumurta, "UTF-8");

        URL url = new URL(apiURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        String json = result.toString();

        List<String> meals = parcaGetir(json, "\"strMeal\":\"");
        if (meals != null) {
            System.out.println("Yumurta içeren yemekler:");
            for (String sonuc : meals) {
                System.out.println(sonuc);
            }
        } else {
            System.out.println("Yumurta içeren yemek bulunamadı.");
        }

    } catch (Exception e) {
        System.out.println("Hata oluştu: " + e.getMessage());
    }
        }
    
        public static void VeriyiGüncelle(){
Scanner giris=new Scanner(System.in);
int secim;
boolean cikis=false;
while(!cikis){
    System.out.println("[1] Yemek ismi ve tarifini güncelle");
    System.out.println("[2] çikiş");
    secim=giris.nextInt();
    giris.nextLine();
    switch(secim){
        case 1: TarifGüncelle();
        break;
        case 2: cikis=true;
        break;
    }
}
        }
      public static void TarifGüncelle(){
      try {
        Scanner giris=new Scanner(System.in);
        String dosyaAdi = "d:\\meals.txt";
        File dosya = new File(dosyaAdi);

        if (!dosya.exists()) {
            System.out.println("Dosya bulunamadı: " + dosyaAdi);
            return;
        }

        Path filePath = dosya.toPath();
        List<String> stringList = Files.readAllLines(filePath, StandardCharsets.UTF_8);

        System.out.print("Değişecek yemek ismini giriniz: ");
        String degisecek = giris.nextLine().trim();

        System.out.print("Yeni yemek ismini giriniz: ");
        String yeniIsim = giris.nextLine().trim();
        System.out.println("Eski tarifi giriniz");
        String eskiTarif=giris.nextLine().trim();
        System.out.println("Yeni tarifi giriniz");
        String yeniTarif=giris.nextLine().trim();

        boolean bulundu = false;

        for (int i = 0; i < stringList.size(); i++) {
            String satir = stringList.get(i);
            String[] parcalar = satir.split(";");

            if(parcalar[0].equals(degisecek) && parcalar[3].equals(eskiTarif)){
                System.out.print(" Tarif: "+parcalar[3]);
                System.out.println("***********");
                   System.out.print("Değiştirilsin mi? (e/h): ");
                String cevap = giris.nextLine().trim();

                if (cevap.equalsIgnoreCase("e")) {
                    String yeniSatir = yeniIsim + ";" + parcalar[1] + ";" + parcalar[2] + ";" + yeniTarif;
                    stringList.set(i, yeniSatir);
                    bulundu = true;
                }
                
            }
               
            
        }

        if (bulundu) {
          
            try  {
                BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi));
                
                for (String satir : stringList) {
                    writer.write(satir);
                    writer.newLine();
                }
                System.out.println("Dosya başariyla güncellendi.");
                writer.close();
            }catch(Exception e){
                System.out.println("Hata oluştu."+e.getMessage());
            }
        } else {
            System.out.println("Eşleşen bir yemek adi bulunamadi.");
        }

    } catch (IOException e) {
        System.out.println("Dosya hatasi: " + e.getMessage());
    } 

      }

    
public static void YemekTürüListele(){
               try {
                Scanner giris=new Scanner(System.in);
                System.out.println("Favori yemek türünüz ne ?");
                String tür;
                tür=giris.nextLine();
        
        String apiURL = "https://www.themealdb.com/api/json/v1/1/filter.php?c=" + URLEncoder.encode(tür, "UTF-8");

        URI uri = URI.create(apiURL);
        URL url = uri.toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream())
        );
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        String json = result.toString();

        List<String> meals = parcaGetir(json, "\"strMeal\":\"");
        if(meals!=null){
            System.out.println("Favori türünüze göre yemekler:");
            for(String sonuc : meals){
                System.out.println(sonuc);
            }
        } else {
            System.out.println("Favori türünüzü içeren yemek bulunamadi.");
        }

    } catch(Exception e){
        System.out.println("Hata oluştu: "+e.getMessage());
    }

}



    

    

        


        
    
    

    public static void HarfiListele () {
       try {
        Scanner giris=new Scanner(System.in);
        String harf ;
        System.out.println("Bir  harf giriniz");
        harf=giris.nextLine();

        String apiURL = "https://www.themealdb.com/api/json/v1/1/search.php?f="+  URLEncoder.encode(harf, "UTF-8");

        URI uri = URI.create(apiURL);
        URL url = uri.toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream())
        );
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();
           
        String json = result.toString();

        List<String> meals = parcaGetir(json, "\"strMeal\":\"");
        if(meals!=null){
            System.out.println(harf+" ile başlayan yemekler:");
            for(String sonuc : meals){
                System.out.println(sonuc);
            }
        } else {
            System.out.println("A ile başlayan yemek bulunamadi.");
        }

    } catch(Exception e){
        System.out.println("Hata oluştu:"+e.getMessage());
    }


}
}


  

    
        


        

  
    

