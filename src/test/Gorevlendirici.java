package test;
import java.util.ArrayList;

public class Gorevlendirici {
	
	//Processlerin sıralanması ve çalıştırılması işlemlerini gorev fonksiyonu gerçekleştirir
	public void gorev(ArrayList<Process> pliste)
	{
		ArrayList<Process> kuyruk0 = new ArrayList<Process>();
		ArrayList<Process> kuyruk1 = new ArrayList<Process>();
		ArrayList<Process> kuyruk2 = new ArrayList<Process>();
		ArrayList<Process> kuyruk3 = new ArrayList<Process>();
		
		int n=0;
		int t=0;
		int giris=0;
		
		
		
	    while(kuyruk0.size() != 0 || kuyruk1.size() != 0 || kuyruk2.size() != 0 || kuyruk3.size() != 0 || t == 0)
		{
			// Processlerin varış zamanı geldi mi diye kontrol ediliyor. Geldiyse o process uygun kuyruğa eklenecek.
			for(int i = 0; i < pliste.size(); i++)
			{
				if(t==pliste.get(i).varis)
				{
					int oncelik=pliste.get(i).oncelik;
					
					if(oncelik==0)
						kuyruk0.add(pliste.get(i));
					if(oncelik==1)
						kuyruk1.add(pliste.get(i));
					if(oncelik==2)
						kuyruk2.add(pliste.get(i));
					if(oncelik==3)
						kuyruk3.add(pliste.get(i));
				}
			}
			
			//Sırasıyla kuyruklar boş mu dolu mu kontrolü yapılıyor.
			//Kuyruk boş değilse o kuyruktaki processler çalıştırılıyor.
			if(kuyruk0.size() != 0)
			{
				if(kuyruk0.get(0).kalan == kuyruk0.get(0).burst)
				{
					System.out.println("t=" + t + " process başladı" + "(id:" + kuyruk0.get(0).pid + " oncelik:" + kuyruk0.get(0).oncelik + " kalan:" + kuyruk0.get(0).kalan + "sn)");
					kuyruk0.get(0).kalan--;
					t++;
					if(kuyruk0.get(0).kalan == 0)
					{
						System.out.println("t=" + t + " process sonlandi" + "(id:" + kuyruk0.get(0).pid + " oncelik:" + kuyruk0.get(0).oncelik + " kalan:" + kuyruk0.get(0).kalan + "sn)");
						kuyruk0.remove(0);
					}
				}
				else
				{
					System.out.println("t=" + t + " process yurutuluyor" + "(id:" + kuyruk0.get(0).pid + " oncelik:" + kuyruk0.get(0).oncelik + " kalan:" + kuyruk0.get(0).kalan + "sn)");
					kuyruk0.get(0).kalan--;
					t++;
					if(kuyruk0.get(0).kalan == 0)
					{
						System.out.println("t=" + t + " process sonlandi" + "(id:" + kuyruk0.get(0).pid + " oncelik:" + kuyruk0.get(0).oncelik + " kalan:" + kuyruk0.get(0).kalan + "sn)");
						kuyruk0.remove(0);
					}
				}

				continue;
			}
			else if(kuyruk1.size() != 0)
			{	
				System.out.println("t=" + t + " process başladı" + "(id:" + kuyruk1.get(0).pid + " oncelik:" + kuyruk1.get(0).oncelik + " kalan:" + kuyruk1.get(0).kalan + "sn)");
				kuyruk1.get(0).kalan--;
				t++;
			
				if(kuyruk1.get(0).kalan == 0)
				{
					System.out.println("t=" + t + " process sonlandi" + "(id:" + kuyruk1.get(0).pid + " oncelik:" + kuyruk1.get(0).oncelik + " kalan:" + kuyruk1.get(0).kalan + "sn)");
					kuyruk1.remove(0);
				}
				else
				{
					kuyruk1.get(0).oncelik = 2;
					System.out.println("t=" + t + " process askıda" + "(id:" + kuyruk1.get(0).pid + " oncelik:" + kuyruk1.get(0).oncelik + " kalan:" + kuyruk1.get(0).kalan + "sn)");
					kuyruk2.add(kuyruk1.get(0));
					kuyruk1.remove(0);
				}
				continue;
			}
			else if(kuyruk2.size() != 0)
			{
				if(giris==0)
				{
					System.out.println("t=" + t + " process başladı" + "(id:" + kuyruk2.get(0).pid + " oncelik:" + kuyruk2.get(0).oncelik + " kalan:" + kuyruk2.get(0).kalan + "sn)");
					kuyruk2.get(0).kalan--;
					giris=1;
					t++;
				}
				if(kuyruk2.get(0).kalan == 0)
				{
					System.out.println("t=" + t + " process sonlandi" + "(id:" + kuyruk2.get(0).pid + " oncelik:" + kuyruk2.get(0).oncelik + " kalan:" + kuyruk2.get(0).kalan + "sn)");
					kuyruk2.remove(0);
					giris=0;
				}
				else
				{
					kuyruk2.get(0).oncelik =3;
					System.out.println("t=" + t + " process askıda" + "(id:" + kuyruk2.get(0).pid + " oncelik:" + kuyruk2.get(0).oncelik + " kalan:" + kuyruk2.get(0).kalan + "sn)");
					kuyruk3.add(kuyruk2.get(0));
					kuyruk2.remove(0);
					giris=0;
				}
				continue;
			}
			
			
			else if(kuyruk3.size() != 0)
			{
				System.out.println("t=" + t + " process başladı" + "(id:" + kuyruk3.get(0).pid + " oncelik:" + kuyruk3.get(0).oncelik + " kalan:" + kuyruk3.get(0).kalan + "sn)");
				t++;
				kuyruk3.get(n).kalan--;

				if(kuyruk3.get(n).kalan == 0)
				{
					System.out.println("t=" + t + " process sonlandi" + "(id:" + kuyruk3.get(0).pid + " oncelik:" + kuyruk3.get(0).oncelik + " kalan:" + kuyruk3.get(0).kalan + "sn)");
					kuyruk3.remove(n);
				}
				else
				{
					System.out.println("t=" + t + " process askıda" + "(id:" + kuyruk3.get(0).pid + " oncelik:" + kuyruk3.get(0).oncelik + " kalan:" + kuyruk3.get(0).kalan + "sn)");
					n++;
				}
				
				if(n == kuyruk3.size())
					n=0;
				
				continue;
			}
			
		}
	}
}
