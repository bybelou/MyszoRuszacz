/**
 * 
 */
package MyszoRuszacz;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Kamil
 *
 */
public class Start {
	//public static MyszoRuszacz obiekt = new MyszoRuszacz();
	public static MyszoRuszacz obiekt;
	static Point staryPunkt = new Point();
	static boolean szejker = false;
	static boolean kwadrat = false;
	static boolean wirtualka = false;
	static int czas = 0;
	static int minutDoRuszaniaMysza;
		
	//konstruktor
	public Start(){
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = null;
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Podaj czas oczekiwania:");
			a = in.readLine();
			minutDoRuszaniaMysza = 60*Integer.parseInt(a);
			System.out.println("Wykorzystaj szejker [s], kwadrat[k], wirtualka [w]:");
			a = null;
			a = in.readLine();
			if (a.equals("s")) szejker = true;
			else if (a.equals("k")) kwadrat = true;
			else wirtualka = true;
		}catch(IOException e){
			e.printStackTrace();
		}
		
		obiekt = new MyszoRuszacz();
		
		while(true){
			if (szejker) obiekt.ustawRobienieSzejka(true);
			else if (kwadrat) obiekt.ustawRobienieKwadratu(true);
			else if (wirtualka) obiekt.ustawRobienieWirtualki(true);
			
			staryPunkt = obiekt.pobierzPozycjeKursora();
			
			czas = 0;
			while (czas<minutDoRuszaniaMysza){
			//while (czas<5){
				//obiekt.ustawNowaPozycje();
				obiekt.oczekiwanie(1000);
				czas++;
				//nowyPunkt = obiekt.pobierzPozycjeKursora();
				
				//if (!staryPunkt.equals(nowyPunkt)){
				if (!staryPunkt.equals(obiekt.pobierzPozycjeKursora())){
					czas=0;
					staryPunkt = obiekt.pobierzPozycjeKursora();
				}
			}
			
			//System.out.println("KURSOR: wys: "+nowyPunkt.x+" szer: "+nowyPunkt.y);
			
			if (szejker) obiekt.zrobSzejkera();
			else if (kwadrat) obiekt.zrobKwadrat();
			else if (wirtualka) obiekt.zrobWirtualke();
		}
	}
}
