package rsa;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//implementing the RSA algorithm, made by Tokhtakhunov Il'murat 3 course student of IT University(Almaty), specialty: CSSE
public class rsa {
	public static void main(String args[]) {
		Scanner sc  = new Scanner(System.in);
		Scanner sc1  = new Scanner(System.in);
		Scanner sc2  = new Scanner(System.in);
		Random rand = new Random();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=2;i<1000;i++) {
			boolean b1 = true;
			for(int j=0;j<arr.size();j++) {
				if(i%arr.get(j)==0) {
					b1 = false;
					}
			}
			if(b1) {
				arr.add(i);
			}
		}
		int p = -1000;
		int q = -1000;
		int e = -1000;
		int d = -1000;
		int n = -1000;
		int z55 = 1;
		while(z55==1) {
			try {
				z55 = 2;
				p = arr.get(rand.nextInt(arr.size()));
				q = arr.get(rand.nextInt(arr.size()));
				while(p==q) {
					q = arr.get(rand.nextInt(arr.size()));
				}
				n = p*q;
				int f = (p-1)*(q-1);
				ArrayList<Integer> arr2 = new ArrayList<Integer>();
				for(int i=0;i<arr.size();i++) {
					if(arr.get(i)>f) {
						break;
					}
					if(f%arr.get(i)!=0&&arr.get(i)%f!=0) {
						arr2.add(arr.get(i));
					}
				}
				e = arr2.get(rand.nextInt(arr2.size()));
				
				ArrayList<Integer> arr3 = new ArrayList<Integer>();
				for(int i=1;i<100000;i++) {
					if((i*e)%f==1) {
						arr3.add(i);
					}
				}
				d = arr3.get(rand.nextInt(arr3.size()));
			}catch(Exception ex) {
				z55 = 1;
			}
		}
		System.out.println("p: "+p+", q: "+q);
		System.out.println("e: "+e+", n: "+n);
		System.out.println("d: "+d+", n: "+n);
		
		String res = "";
		System.out.println("Please enter string which you want to encrypt: ");
		String st = sc1.nextLine();
		st = st.trim();
		int x3 = (int) st.charAt(0);
		int x4 = 0;
		int z4 = 1;
		while(true) {
			try {
				int g1 = x3;
				for(int i=0;i<e-1;i++) {
					g1 = (g1*x3)%n;
				}
				g1 = g1+x4;
				res = res + g1 + " ";
				x4 = st.charAt(z4-1);
				x3 = st.charAt(z4);
				z4++;
			}catch(Exception ex){
				break;
			}
		}
		System.out.println(res);
		Scanner ds = new Scanner(res);
		String res2 = "";
		while(true) {
			try{
				res2 = res2+(char)((ds.nextInt()%104)+22);
			}catch(Exception es){
				break;
			}
		}
		System.out.println(res2);
		Scanner ds2 = new Scanner(res);
		res2 = "";
		String res3 = "";
		int g2=0;
		while(true) {
			try {
				int v1 = ds2.nextInt()-g2;
				long re = v1;
				for(int i=0;i<d-1;i++) {
					re = (re*v1)%n;
				}
				res2 = res2+(char)re;
				res3 = res3+" "+re;
				g2 = (int) re;
			}catch(Exception ex){
				break;
			}
		}
		System.out.println("Encrypted string: "+res3);
		System.out.println("Encrypted string: "+res2);
	}
}
