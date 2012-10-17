package chiffre;

public class StringNumber{
    
    private char zeichen;
    private int nummer;
    
    public StringNumber(char c, int i){
        this.nummer = i;
        this.zeichen = c;
    }
    
    public char getZeichen(){
        return zeichen;
    }
    
    public int getNummer(){
        return nummer;
    }
            
}