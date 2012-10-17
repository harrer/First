package classes;

import java.util.ArrayList;
import java.util.Random;

public class Tisch {
	
	public static int getNumber(){// liefert eine Zufallszahl >=0 und <=36
		Random r = new Random();
		return r.nextInt(37);
	}
	
	public static Color getColor(int n){//liefert die Farbe rot/schwarz bzw. zero zur Zahl
		if(n==0) return Color.zero;
		if(n<=10){
			if(n%2==0) return Color.black;
			else return Color.red;
		}
		else if(n<=18){
			if(n%2==0) return Color.red;
			else return Color.black;
		}
		else if(n<=28){
			if(n%2==0) return Color.black;
			else return Color.red;
		}
		else if(n%2==0) return Color.red;
		else return Color.black;
	}
	
	public static boolean winColor(Color c){//prüft, ob eine Farbe gewinnt
		return c.equals(getColor(getNumber()));
	}
	
	public static Result play(int balance, int bet, Color c){//führt den Spielzug durch
		if(winColor(c)){
			return new Result(balance+bet, bet, true, c);
		}
		else return new Result(balance-bet, bet, false, c);
	}
	
	public static Color opposite(Color c){//gibt bei rot schwarz zurück und umgekehrt, bei zero wird schwarz per default zurückgegeben
		if(c.equals(Color.red)) return Color.black;
		else if(c.equals(Color.black)) return Color.red;
		else return Color.black; //Falls zero drankommt
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		int balance = 50;//Initiales Guthaben
		int bet = 10;//Basis-Einsatz
		Result r = play(balance, bet, Color.red);
		int games = 0;//Zählt die Anzahl der Spiele
		while(r.getBalance()<=1000){//bestimmt das Limit nach oben
			if(r.getWon()){//Falls gerade gewonnen wurde
				System.out.println(r.getBet()+" gewonnen mit "+r.getColor()+" Summe: "+r.getBalance());
				list.add(r.getBalance());
				r = play(r.getBalance(), bet, opposite(r.getColor()));//...setze den Basis-Einsatz auf die andere Farbe
			}
			else{//Falls man verloren hat
				System.out.println(r.getBet()+" verloren mit "+r.getColor()+" Summe: "+r.getBalance());
				list.add(r.getBalance());
				r = play(r.getBalance(), 2*r.getBet(), r.getColor());//...setze den doppelten Einsatz auf die gleiche Farbe
			}
			games++;
		}
		System.out.println(r.getBalance()+" nach "+games+" Spielen.");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)+"\n");
		}
		FileHandler.putToFile(sb.toString(), "C:\\Users\\Tobias\\Desktop\\Roulette.txt", true);
	}
}
