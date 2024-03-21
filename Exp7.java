import java.security.*;
import java.security.spec.*;
import java.util.*;
public class Exp7{
 public static void main(String[] args){
  try{
   KeyPair keypair=generateKeyPair();
   Scanner sc=new Scanner(System.in);
   PrivateKey privatekey=keypair.getPrivate();
   PublicKey publickey=keypair.getPublic();
   System.out.println("Enter the message");
   String msg=sc.next();
   byte[] signature=sign(msg,privatekey);
   System.out.println("Signature "+signature);
   System.out.println("Digital Signature "+Base64.getEncoder().encodeToString(signature));
   boolean verification=verify(msg,signature,publickey);
   System.out.println("Signature Verification "+verification);
}
 catch(Exception e){
   e.printStackTrace();
  }

 }
 public static KeyPair generateKeyPair() throws Exception{
   KeyPairGenerator keypair=KeyPairGenerator.getInstance("RSA");
   keypair.initialize(2048);
   return keypair.generateKeyPair();
  }
 public static byte[] sign(String message,PrivateKey privatekey) throws Exception{
     Signature sgn=Signature.getInstance("SHA256withRSA");
     sgn.initSign(privatekey);
     sgn.update(message.getBytes());
     return sgn.sign();
 }
 public static boolean verify(String message,byte[] signature,PublicKey publickey) throws Exception{
    Signature sgn=Signature.getInstance("SHA256withRSA");
    sgn.initVerify(publickey);
    sgn.update(message.getBytes());
    return sgn.verify(signature);
 }
}