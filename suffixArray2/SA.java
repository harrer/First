package suffixArray;

import java.util.ArrayList;

public class SA{

	public static Pointer[] suffixes(String text){
		Pointer[] out = new Pointer[text.length()];
		for (int i = 0; i < text.length(); i++) {
			out[i] = new Pointer(text.substring(i), i);
		}
		return out;
	}
	
	public static int[] suffixArray(Pointer[] in){
		int[] out = new int[in.length+1];
		for (int i = 0; i < out.length-1; i++) {
			out[i+1] = in[i].getPointer()+1;
		}
		out[0] = in.length+1;
		return out;
	}
	
	
	public static Pointer[] mergeSort(Pointer[] in){
		if(in.length==1){return in;}
		else{
			Pointer[] s1 = new Pointer[in.length/2];
			for (int i = 0; i < in.length/2; i++) {
				s1[i] = in[i];
			}
			Pointer[] s2 = null;
			if(in.length%2==0){s2 = new Pointer[in.length/2];}
			else{s2 = new Pointer[(in.length/2)+1];}
			for (int i = 0; i < s2.length; i++) {
				s2[i] = in[i+(in.length/2)];
			}
			Pointer[] s11 = mergeSort(s1);
			Pointer[] s22 = mergeSort(s2);
			return merge(s11, s22);
		}
	}
	
	public static Pointer[] merge(Pointer[] in1, Pointer[] in2){
		ArrayList<Pointer> out = new ArrayList<Pointer>();
		int c1=0,c2=0;
		while(c1<in1.length&&c2<in2.length){
			if(in1[c1].getSub().compareTo(in2[c2].getSub())<=0){out.add(in1[c1]);c1++;}
			else{out.add(in2[c2]);c2++;}
		}
		while(c1<in1.length){out.add(in1[c1]);c1++;}
		while(c2<in2.length){out.add(in2[c2]);c2++;}
		Pointer[] intOut = new Pointer[out.size()];
		for (int i = 0; i < intOut.length; i++) {
			intOut[i] = out.get(i);
		}
		return intOut;
	}
	
	public static int[] SaSearch(String pattern, int[] sa, String text){
		int sp = 1 , st=text.length()+1 , m = pattern.length();
		while(sp<st){
			int s = (int) (Math.floor((sp+st)/2.0));
			try {
				if(pattern.compareTo(text.substring(sa[s], sa[s]+m-1))>0){
					sp = s+1;
				}
				else{st = s;}
			} catch (StringIndexOutOfBoundsException e) {
				return new int[] {-1,-1};
			}
		}
		int ep = sp-1 , et = text.length();
		while(ep<et){
			int e = (int) (Math.ceil((ep+et)/2.0));
			try {
				if(pattern.compareTo(text.substring(sa[e], sa[e]+m-1))==0){
					ep = e;
				}
				else{et = e-1;}
			} catch (StringIndexOutOfBoundsException e2) {
				return new int[] {-1,-1};
			}
		}
		return new int[] {sp,ep};
	}

	public static int[] suche(String text, double pos1, String pattern,Pointer[] sa, int durchgang){
		int pos = (int)pos1, comp = 0; String sub = "";
		try {
			sub = text.substring(sa[pos].getPointer(), sa[pos].getPointer()+pattern.length());
			comp = pattern.compareTo(sub);
			System.out.println(sub+" "+comp);
		} catch (StringIndexOutOfBoundsException e) {
			if(pos>0){return suche(text, pos-1, pattern, sa, durchgang);}
			else if(pos==0){return suche(text, sa.length+1, pattern, sa, durchgang);}
			if(pos<sa.length){return suche(text, pos+1, pattern, sa, durchgang);}
			else if(pos==sa.length){return suche(text, sa.length-1, pattern, sa, durchgang);}
		}
		if(comp<0){
			return suche(text,pos-Math.floor(sa.length/Math.pow(2, durchgang)),pattern,sa,durchgang+1);
		}
		else if(comp>0){
			return suche(text,pos+Math.floor(sa.length/Math.pow(2, durchgang)),pattern,sa,durchgang+1);
		}
		else{
			System.out.println(text.substring(sa[pos-1].getPointer(), sa[pos-1].getPointer()+pattern.length()));
			while(pos>0&&(text.substring(sa[pos-1].getPointer(), sa[pos-1].getPointer()+pattern.length())).equals(pattern)){
				pos--;
			}
			int end = pos+1;
			while(end<sa.length){
				sub = text.substring(sa[end].getPointer(), sa[end].getPointer()+pattern.length());
				comp =pattern.compareTo(sub);
				if(comp!=0){end--;break;}
				System.out.println(sub+" "+comp);
				end++;
			}
			return new int[] {pos,end};
		}
	}
	
	public static void main(String[] args) {
		long v = System.currentTimeMillis();
		String text = "diuebcnklimaoqbxiyot\u0000";
		String pattern = "klima";
		Pointer[] s = suffixes(text);
		Pointer[] s2 = mergeSort(s);
		//int[] s3 = suffixArray(s2);
		long n = System.currentTimeMillis();
		System.out.println("Suffix array done in "+ (n-v)+" ms");
		String out = "";
		for (int i = 0; i < s2.length; i++) {
			out+= i+" "+text.substring(s2[i].getPointer())+" ("+s2[i].getPointer()+")"+"\n";
		}
		System.out.println(out);
		int[] search = suche(text, text.length()/2, pattern, s2, 2);
		System.out.println("Von: "+search[0]+" bis: "+search[1]);
	}
}
