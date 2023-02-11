import java.util.*;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  
public class encryptedpassword   
{  
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException  
    {  
        /* MessageDigest instance for hashing using SHA256 */  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        /* digest() method called to calculate message digest of an input and return array of byte */  
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    }  
      
    public static String toHexString(byte[] hash)  
    {  
        /* Convert byte array of hash into digest */  
        BigInteger number = new BigInteger(1, hash);  
  
        /* Convert the digest into hex value */  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        /* Pad with leading zeros */  
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    }  
  
    /* Driver code */  
    public static void main(String args[])  
    {  Scanner sc=new Scanner(System.in);

        try  
        { 
            System.out.print("How many random Password you want to generate");
            int total=sc.nextInt();
            System.out.print("Length of random Password you want to generate");
            int length=sc.nextInt();
            for(int i=0;i<total;i++){
                String string="";
                for(int j=0;j<length;j++) {
                    string+=ranchar();
                }
            
            System.out.println("\n" + string + " : " + toHexString(getSHA(string)));  
        }
          
        }  
        catch (NoSuchAlgorithmException e)   
        {  
            System.out.println("Exception thrown for incorrect algorithm: " + e);  
        }  
    } 
    public static char ranchar(){
        int rno=(int)(Math.random()*62);
if(rno<=9){
    int ascii=rno+48;
    return (char)(ascii);
          }
else if(rno<=35){
    int ascii=rno+55;
    return (char)(ascii);    
                }
else {
    int ascii=rno+36;
    return (char)(ascii);
    }

    }
    

}