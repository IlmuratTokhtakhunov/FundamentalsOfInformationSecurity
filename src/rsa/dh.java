package rsa;
import java.util.*;
//implementing the Diffie-Hellman algorithm, made by Tokhtakhunov Il'murat 3 course student of IT University(Almaty), specialty: CSSE
public class dh {
	public static void main(String args[]) {
		System.out.println("Please enter p and q");
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int q = sc.nextInt();
		System.out.println("Please enter your secret number");
		int a = sc.nextInt();
		int res1 = p;
		for(int i=1;i<a;i++) {
			res1 = (res1*p)%q;
		}
		System.out.println("Transmit: from YOU to 1 receiver: "+res1);
		Random rand = new Random();
		int b = rand.nextInt(1000);
		int res2 = res1;
		for(int i=1;i<b;i++) {
			res2 = (res2*res1)%q;
		}
		System.out.println("Transmit: from 1 receiver to 2 receiver: "+res2);
		int c = rand.nextInt(1000);
		int res3 = res2;
		for(int i=1;i<c;i++) {
			res3 = (res3*res2)%q;
		}
		int s2 = res3;
		System.out.println("2 Receiver secret key "+s2);
		
		res1 = p;
		for(int i=1;i<c;i++) {
			res1 = (res1*p)%q;
		}
		System.out.println("Transmit: from 2 receiver to YOU: "+res1);
		res2 = res1;
		for(int i=1;i<a;i++) {
			res2 = (res2*res1)%q;
		}
		System.out.println("Transmit: from YOU to 2 receiver: "+res2);
		res3 = res2;
		for(int i=1;i<b;i++) {
			res3 = (res3*res2)%q;
		}
		int s1 = res3;
		System.out.println("1 Receiver secret key "+s1);
		
		res1 = p;
		for(int i=1;i<b;i++) {
			res1 = (res1*p)%q;
		}
		System.out.println("Transmit: from 1 receiver to 2 receiver: "+res1);
		res2 = res1;
		for(int i=1;i<c;i++) {
			res2 = (res2*res1)%q;
		}
		System.out.println("Transmit: from 2 receiver to YOU: "+res2);
		res3 = res2;
		for(int i=1;i<a;i++) {
			res3 = (res3*res2)%q;
		}
		int s0 = res3;
		System.out.println("YOUR secret key "+s0);
		System.out.println("-----------Results----------- ");
		System.out.println("YOUR secret key "+s0);
		System.out.println("1 Receiver secret key "+s1);
		System.out.println("2 Receiver secret key "+s2);
	}

}
