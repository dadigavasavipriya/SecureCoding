
        
import java.util.Scanner;
public class Caesarcipher{
  public static void main(String[] args) {
        String S="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s="abcdefghijklmnopqrstuvwxyz";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Input text");
        String inputtext=sc.nextLine();
        System.out.println("Enter the secret key");
        int key=sc.nextInt();
        String ciphertext=Ciphertext(S,s,inputtext,key);
        System.out.println("Cipher text is "+ciphertext);
        int secretkey=0;
        String Finaltext="";
        String a[]=Decryption(S,s,inputtext,ciphertext);
        System.out.println();
        System.out.println("Plaintext is obtained "+a[0]+ " at key "+a[1]);
    }
    public static String Ciphertext(String S,String s,String inputtext,int key){
       String ciphertext="";
        for(int i=0;i<inputtext.length();i++){
            char a=inputtext.charAt(i);
            if(!Character.isLetter(a)){
               ciphertext+=a;
            }
            else if(Character.isUpperCase(a)){
                ciphertext+=S.charAt((S.indexOf(a)+key)%26);
            }
            else{
                ciphertext+=s.charAt((s.indexOf(a)+key)%26);
            }
        }
        return ciphertext;
      }
      public static String[] Decryption(String S,String s,String inputtext,String ciphertext){
        String ar[]=new String[2];
        for(int deckey=1;deckey<=26;deckey++){
          String plaintext="";
        for(int i=0;i<ciphertext.length();i++){
            char a=ciphertext.charAt(i);
            int b=0;
            if(!Character.isLetter(a)){
              plaintext+=a;
            }
            else if(Character.isUpperCase(a)){
                b=(S.indexOf(a)-deckey)%26;
                if(b<0)
                plaintext+=S.charAt(b+26);
                else
                 plaintext+=S.charAt(b);
            }
            else{
                b=(s.indexOf(a)-deckey)%26;
                if(b<0)
                plaintext+=s.charAt(b+26);
                else
                 plaintext+=s.charAt(b);
            }
            if(plaintext.equals(inputtext)){
              ar[0]=plaintext;
              ar[1]=Integer.toString(deckey);
              return ar;
            }
        }
        System.out.println("plain text at serect key "+deckey+" is "+plaintext);
        }
        return ar;
      }
  }
