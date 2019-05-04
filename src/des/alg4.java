package des;
//Implementing the DES algorithm;
import java.util.*;
import java.security.*;
import javax.crypto.*;
public class alg4 {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
		Scanner sc  = new Scanner(System.in);
		Scanner sc1  = new Scanner(System.in);
		Scanner sc2  = new Scanner(System.in);
		Scanner sc3  = new Scanner(System.in);
		KeyGenerator keygen = KeyGenerator.getInstance("DES");
	    SecretKey key = keygen.generateKey();
	    while(true) {
	    System.out.println("key: " + key.toString());
		System.out.println("[1] - To encrypt");
		System.out.println("[2] - To decipher");
		System.out.println("[0] - To exit");
		System.out.println("Please enter command: ");
		int z = sc.nextInt();
		if(z==1){
			Cipher enc;
		    enc = Cipher.getInstance("DES");
		    enc.init(Cipher.ENCRYPT_MODE, key);
			System.out.println("Please enter string, which you want to encrypt: ");
			String st = sc1.nextLine();
			st = st.trim();
			byte[] st1 = st.getBytes();
		    System.out.println("String [Byte Format] : " + st1);
		    byte[] res = enc.doFinal(st1);
		    System.out.println("String Encryted[Byte Format] : "+res);
		    System.out.println("String Encryted : [" + new String(res)+"]");
		}
		if(z==2){
			Cipher dec;
			dec = Cipher.getInstance("DES");
			System.out.println("Please enter string(not Byte[] format), which you want to decipher: ");
			String st = sc1.nextLine();
			st = st.trim();
			dec.init(Cipher.DECRYPT_MODE, key);
		    // Decrypt the text
		    byte[] res = dec.doFinal(st.getBytes());
		    System.out.println("String Decryted : " + new String(res));
			}
		if(z==0) {
			break;
		}
	    }
	}
}
