package magsq;

import java.util.Scanner;
import java.util.*;
//implementing the Magic Square cipher algorithm, made by Tokhtakhunov Il'murat 3 course student of IT University(Almaty), specialty: CSSE
public class alg2 {
	public static void main(String args[]) {
		Scanner sc  = new Scanner(System.in);
		Scanner sc1  = new Scanner(System.in);
		Scanner sc2  = new Scanner(System.in);
		System.out.println("[1] - To encrypt");
		System.out.println("[2] - To decipher");
		System.out.println("Please enter command: ");
		int z = sc.nextInt();
		boolean x = true;
		String res = "";
		if(z==1){
			System.out.println("Please enter string, which you want to encrypt: ");
			String st = sc1.nextLine();
			st = st.toLowerCase();
			st = st.trim();
			System.out.println("Please enter key: [key] - to generate magic key");
			String key = sc2.nextLine();
			key = key.trim();
			int y=3;
			if(key.indexOf("key")!=-1) {
				while(y*y<st.length()) {
					y = y+2;
				}
				int[][] arr1 = new int[y][y];
				int x1 = (int) Math.floor(y/2);
				int y1 = 0;
				arr1[y1][x1] = 1;
				for(int i=2;i<=y*y;i++) {
					int x2=x1+1;
					int y2=y1-1;
					if(x2>y-1)
						x2 = 0;
					if(y2<0)
						y2 = y-1;
					if(arr1[y2][x2]!=0){
						if(y1+1>y-1)
							y1 = -1;
						arr1[y1+1][x1] = i;
						y1 = y1+1;
					}else{
						arr1[y2][x2] = i;
						x1 = x2;
						y1 = y2;
					}
				}
				key = "";
				for(int i=0;i<y;i++) {
					for(int j=0;j<y;j++) {
						key = key+" "+arr1[i][j];
					}
				}
				System.out.println("Generated key: "+key);
			}
			Scanner nado = new Scanner(key);
			Random rand = new Random();
			int it = (int)st.charAt(0);
			while(true) {
				try {
					int c = nado.nextInt();
					if(c>st.length()) {
						if(c==st.length()+1) {
							res = res + (char)(it-32);
						}else {
							z = rand.nextInt(25);
							int d2 = rand.nextInt(2);
							if(d2==1) {
								res = res + (char)(z+97);
							}
							else {
								res = res + (char)(z+65);
							}
						}
					}else{
						res = res + st.charAt(c-1);
					}
				}catch(Exception ex){
					break;
				}
			}
		}
		if(z==2){
			System.out.println("Please enter string, which you want to decipher: ");
			String st = sc1.nextLine();
			System.out.println("Please enter key: ");
			String key = sc2.nextLine();
			key = key.trim();
			int in = 1;
			Scanner nado = new Scanner(key);
			ArrayList<Integer> arr = new ArrayList<Integer>();
			while(true) {
				try {
					arr.add(nado.nextInt());
				}catch(Exception ex){
					break;
				}
			}
			for(int i=0;i<arr.size();i++) {
				if(arr.get(i)==in) {
					if(in!=1&&(int)st.charAt(i)+32==(int)res.charAt(0)) {
						break;
					}
					res = res + st.charAt(i);
					i=-1;
					in++;
				}
			}
		}
		if(x){
			System.out.println("Encrypted string: "+res);
		}
	}

}
