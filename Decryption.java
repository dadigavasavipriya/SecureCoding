import java.util.Scanner;
public class Decryption{
  public static void main(String[] args) {
        String S="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s="abcdefghijklmnopqrstuvwxyz";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Cipher text");
        String ciphertext=sc.nextLine();
        System.out.println("Enter the secret key");
        int key=sc.nextInt();
        String plaintext="";
        for(int i=0;i<ciphertext.length();i++){
            char a=ciphertext.charAt(i);
            int b=0;
            if(Character.isUpperCase(a)){
                b=(S.indexOf(a)-key)%26;
                if(b<0)
                plaintext+=S.charAt(b+26);
                else
                 plaintext+=S.charAt(b);
            }
            else{
                b=(s.indexOf(a)-key)%26;
                if(b<0)
                plaintext+=s.charAt(b+26);
                else
                 plaintext+=s.charAt(b);
            }
        }
        System.out.println("Plain text is "+plaintext);
    }
}
     
