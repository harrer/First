package chiffre;

public class SnIa{
    
    private int[] ia;
    private StringNumber[] sn;
    
    public SnIa(int[] ia, StringNumber[] sn){
        this.ia = ia;
        this.sn = sn;
    }
    
    public StringNumber[] getSn(){
        return this.sn;
    }
    
    public int[] getIa(){
        return this.ia;
    }
    
    public String printCode(){
        String s = "";
        for(int i=0;i<75;i++){
            s+=this.ia[i]+"@";
        }
        return s;
    }
    
}