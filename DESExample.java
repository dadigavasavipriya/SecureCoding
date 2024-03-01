import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.util.Scanner;
public class DESExample
{
public static void main(String[] argv) {
try{

 KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
 SecretKey myDesKey = keygenerator.generateKey();
 Cipher desCipher;
 Scanner sc=new Scanner(System.in);
 System.out.println("enter data:");
 String data=sc.nextLine();
desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
 desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
 byte[] text = data.getBytes();
 System.out.println("Message : " + new String(text));
 System.out.println("Message [Byte Format] : " + text);
 
 byte[] textEncrypted = desCipher.doFinal(text);
 System.out.println("Encrypted Message: " + textEncrypted);
 desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
 byte[] textDecrypted = desCipher.doFinal(textEncrypted);
 System.out.println("Decrypted Message: " + new 
String(textDecrypted));
}catch(Exception e){
e.printStackTrace();
}
}}