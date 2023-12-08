import java.util.Scanner;
public class Decryption{
  public static void main(String[] args) {
        String S="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s="abcdefghijklmnopqrstuvwxyz";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Input text");
        String inputtext=sc.nextLine();
        System.out.println("Enter the secret key");
        int key=sc.nextInt();
        String ciphertext="";
        for(int i=0;i<inputtext.length();i++){
            char a=inputtext.charAt(i);
            int b=0;
            if(Character.isUpperCase(a)){
                b=(S.indexOf(a)-key)%26;
                if(b<0)
                ciphertext+=S.charAt(b+26);
                else
                 ciphertext+=S.charAt(b);
            }
            else{
                b=(s.indexOf(a)-key)%26;
                if(b<0)
                ciphertext+=s.charAt(b+26);
                else
                 ciphertext+=s.charAt(b);
            }
        }
        System.out.println("Cipher text is "+ciphertext);
    }
}
     
