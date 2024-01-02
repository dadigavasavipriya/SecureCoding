import java.util.*;
class OneTimePad{
 public static void main(String[] args){
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the PlainText");
   String inputtext=sc.nextLine();
   System.out.println("Enter the Key");
   String key=sc.nextLine();
   Ciphertext(inputtext,key);
 }
 public static void Ciphertext(String inputtext,String key){
   String cipher="";
   String temp=key;
   int n=temp.length();
   int i=0;
   while(key.length()<inputtext.length()){
    if(i==n){
      i=0;
    }
    key+=temp.charAt(i);
    i++;
   }
   //System.out.println(key);
   for(int j=0;j<inputtext.length();j++){
     String a=Integer.toBinaryString(inputtext.charAt(j));
     String b=Integer.toBinaryString(key.charAt(j));
     String c=xorop(a,b);
     cipher+=c+" ";
  }
  System.out.println("Cipher text is "+cipher);
  decrypt(cipher,key);
 }
 public static String xorop(String a,String b){
  String c="";
  for(int i=0;i<a.length();i++){
   if(a.charAt(i)==b.charAt(i))
     c+="0";
  else
    c+="1";
  }
  return c;
 }
 public static void decrypt(String cipher,String key){
   String[] a=cipher.split(" ");
   String plain="";
   for(int i=0;i<a.length;i++)
   {
      String b=Integer.toBinaryString(key.charAt(i));
     String c=xorop(a[i],b);
     int decimal=Integer.parseInt(c,2);
     plain+=(char)decimal;
   }
   System.out.println("Plain text is "+plain);
 }
 
}
