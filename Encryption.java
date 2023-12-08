import java.util.Scanner;
public class Encryption{
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
            if(Character.isUpperCase(a)){
                ciphertext+=S.charAt((S.indexOf(a)+key)%26);
            }
            else{
                ciphertext+=s.charAt((s.indexOf(a)+key)%26);
            }
        }
        System.out.println("Cipher text is "+ciphertext);
    }
}
     
