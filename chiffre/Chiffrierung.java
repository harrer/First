package chiffre;

import java.util.Random;

public class Chiffrierung{
    
    private StringNumber[] alleZeichen;
    public String url = "qwertzuiopasdfghjklmnbvcxyQWERTZUIOPLKJHGFDSAYXCVBNM1234567890.-_@?=:;/+%#$";
    
    public void instanciateAlleZeichen(){
        alleZeichen = new StringNumber[url.length()];
        for(int i=0;i<url.length();i++){
            alleZeichen[i] = new StringNumber(this.url.charAt(i),i);
        }
    }
    
    public int[] vertausche(){
        int length = url.length();
        Random r = new Random();
        int[] ia = new int[length];
        boolean flag = true;
        for(int i=0;i<length-1;i++){
            int next = r.nextInt(length);
            for(int j=0;j<=i;j++){
                if(ia[j]==next){
                    i--;
                    flag = false;
//                    System.out.println("ia bei "+j+" besetzt mit "+next);
                    break;
                }
            }
            if(flag){
                ia[i] = next;
                System.out.println(i+" besetz mit "+next);
            }
            flag = true;
        }
        ia[ia.length-1] = 0;
        return ia;
    }
    
    public SnIa chiffriereAlleZeichen(){
        int length = url.length();
        StringNumber[] sn = new StringNumber[length];
        int[] ia = this.vertausche();
        
        for(int i=0;i<length;i++){
            sn[i] = new StringNumber(this.alleZeichen[ia[i]].getZeichen(), ia[i]);
            //System.out.println(i);
        }
        return new SnIa(ia, sn);
    }
    
    public String codierterInput(String input){
        String s = "";
        this.instanciateAlleZeichen();
        SnIa schlüssel = this.chiffriereAlleZeichen();
        for(int i=0;i<input.length();i++){
            for(int j=0;j<this.url.length();j++){
                if(input.charAt(i)==this.alleZeichen[j].getZeichen()){
                    int number = this.alleZeichen[j].getNummer();
                    s+=schlüssel.getSn()[number].getZeichen();
                }
            }
        }
        return s+" "+schlüssel.printCode();
    }
    
    public String entschlüsseln(String input, String code){
        String s = "";
        this.instanciateAlleZeichen();
        int[] ia = new int[url.length()];
        for(int i=0;i<url.length();i++){
            for(int j=0;j<code.length();j++){
                if(code.charAt(j)=='@'){
                    ia[i] = Integer.parseInt(code.substring(0, j));
                    code = code.substring(j+1);
                    break;
                }
            }
        }
        for(int i=0;i<input.length();i++){
            for(int j=0;j<url.length();j++){
                if(this.alleZeichen[j].getZeichen()==input.charAt(i)){
                    for(int k=0;k<75;k++){
                        if(ia[k]==j){
                            s+= this.alleZeichen[k].getZeichen();
                            break;
                        }
                    }
                }
            }
        }
        return s;
    }
    
    public static void main(String[] args){
        Chiffrierung c = new Chiffrierung();
        String input = "web.de";
        String verschlüsselt = c.codierterInput(input);
        System.out.println(verschlüsselt);
        System.out.println(c.entschlüsseln(verschlüsselt.substring(0, input.length()), verschlüsselt.substring(input.length()+1)));
        
//      c.instanciateAlleZeichen();
//      SnIa s = c.chiffriereAlleZeichen();
        }
}