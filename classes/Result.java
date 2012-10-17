package classes;

public class Result {
	
	private int balance, bet;
	private boolean won;
	private Color color;
	
	public Result(int bal, int bet, boolean w, Color c){
		balance = bal;
		this.bet = bet;
		won = w;
		color = c;
	}

	public int getBalance(){
		return balance;
	}
	
	public int getBet(){
		return bet;
	}
	
	public boolean getWon(){
		return won;
	}
	
	public Color getColor(){
		return color;
	}
}
