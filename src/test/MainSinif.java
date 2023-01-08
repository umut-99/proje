package test;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;



public class MainSinif {

	public static void main(String[] args) {
		
		//Processleri tutan liste
		ArrayList<Process> pliste = new ArrayList<Process>();
		
		//txt dosyasından process bilgilerini okuma işlemi yapılıyor ve processler oluşturuluyor.
		//Oluşturulan processler listeye kaydediliyor. Tüm processler pliste isimli listede tutuluyor.
		
		try {
			System.out.println("Txt dosya yolunu giriniz.");
			Scanner girdi = new Scanner(System.in);
			String dosyayolu = girdi.nextLine();
			File file = new File(dosyayolu);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String s = reader.readLine();
			
			while(s != null)
			{
				String[] arrSplit = s.split(", ");
				Process p = new Process();
				p.pid = pliste.size();
				p.varis = Integer.parseInt(arrSplit[0]);
				p.oncelik = Integer.parseInt(arrSplit[1]);
				p.burst = Integer.parseInt(arrSplit[2]);
				p.kalan = p.burst;
				pliste.add(p);
				s = reader.readLine(); 
			}

        }
        catch (FileNotFoundException e){
            System.out.println("-> Aradığınız Dosyaya Ulaşamadım.\n-> Hata Mesajım: "+ e.getMessage());
        }
	    catch (IOException e){
            System.out.println("-> Aradığınız Dosya Üzerinde Veri Okuyamıyorum.\n-> Hata Mesajım: "+ e.getMessage());
        }
		
			
			
		
		
		//Processlerin çalışmasını düzenleyen gorevlendirici nesnesi oluşturuluyor ve fonksiyonu çalıştırılıyor.
		Gorevlendirici gorevlendirici = new Gorevlendirici();
		gorevlendirici.gorev(pliste);

	}

}
