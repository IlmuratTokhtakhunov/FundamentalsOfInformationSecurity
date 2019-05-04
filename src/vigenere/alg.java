package vigenere;
import java.util.*;
//This is implementation of vigenere cipher, made by Tokhtakhunov Il'murat 3 course student of IT University(Almaty), specialty: CSSE
public class alg {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		Scanner sc1  = new Scanner(System.in);
		Scanner sc2  = new Scanner(System.in);
		Scanner sc3  = new Scanner(System.in);
		System.out.println("[1] - To encrypt");
		System.out.println("[2] - To decipher");
		System.out.println("Please enter command: ");
		int z = sc.nextInt();
		boolean x = true;
		String res = "";
		if(z==1){
			System.out.println("Please enter string, which you want to encrypt: ");
			String st = sc1.nextLine();
			st = st.trim();
			st = st.toLowerCase();
			for(int i=0;i<st.length();i++) {
				if(st.charAt(i)==' ') {
					st = st.substring(0, i) + st.substring(i+1);
					i--;
				}
			}
			System.out.println(st);	
			System.out.println("Please enter key: ");
			String key = sc2.nextLine();
			key = key.trim();
			key = key.toLowerCase();
			for(int i=0;i<key.length();i++) {
				if(key.charAt(i)==' ') {
					key = key.substring(0, i) + key.substring(i+1);
					i--;
				}
			}
			System.out.println("Please enter step in vigenere table: ");
			int d = sc3.nextInt();
			int s = 0;
			for(int i=0;i<st.length();i++) {
				if((int) st.charAt(i)<97||(int) st.charAt(i)>122) {
					System.out.println("Wrong symbol in entered string: "+st.charAt(i));
					x=false;
					break;
				}
				int f = st.charAt(i);
				if((int) key.charAt(s)<97||(int) key.charAt(s)>122) {
					System.out.println("Wrong symbol in entered key: "+key.charAt(s));
					x=false;
					break;
				} 
				int f2 = key.charAt(s);
				int c = f+f2%97+d;
				if(c>122) {
					c = 97+c%123;
				}
				res = res + (char)c;
				s++;
				if(s==key.length()) {
					s = 0;
				}
			}
		}
		if(z==2){
			System.out.println("Please enter string, which you want to decipher: ");
			String st = sc1.nextLine();
			st = st.trim();
			st = st.toLowerCase();
			for(int i=0;i<st.length();i++) {
				if(st.charAt(i)==' ') {
					st = st.substring(0, i) + st.substring(i+1);
					i--;
				}
			}
			System.out.println(st);	
			System.out.println("Please enter key: ");
			String key = sc2.nextLine();
			key = key.trim();
			key = key.toLowerCase();
			for(int i=0;i<key.length();i++) {
				if(key.charAt(i)==' ') {
					key = key.substring(0, i) + key.substring(i+1);
					i--;
				}
			}
			int s = 0;
			System.out.println("Please enter step in vigenere table: ");
			int d = sc3.nextInt();
			for(int i=0;i<st.length();i++) {
				if((int) st.charAt(i)<97||(int) st.charAt(i)>122) {
					System.out.println("Wrong symbol in entered string: "+st.charAt(i));
					x=false;
					break;
				}
				int f = st.charAt(i);
				if((int) key.charAt(s)<97||(int) key.charAt(s)>122) {
					System.out.println("Wrong symbol in entered string: "+key.charAt(s));
					x=false;
					break;
				} 
				int f2 = key.charAt(s);
				int c = f-f2%97-d;
				if(c<97) {
					c = 123+c-97;
				}
				res = res + (char)c;
				s++;
				if(s==key.length()) {
					s = 0;
				}
			}
		}
		if(x){
			System.out.println("Encrypted str"+ "ing: "+res);
		}
	}
}
