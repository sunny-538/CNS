/*Start

Read plaintext (in pairs of 2 letters)

Read the 2×2 key matrix

Convert letters to numbers (A=0, B=1…)

Multiply matrix × vector

Take mod 26

Convert back to letters

Output ciphertext

For decryption, multiply by inverse matrix

Stop*/
import java.util.Scanner;

public class Hill {

    
   
    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return -1;
    }

    public static String hillEncrypt(String text, int[][] key) {
        text = text.replaceAll("\\s", "").toUpperCase();

        if (text.length() % 2 != 0) text += "X";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            int p1 = text.charAt(i) - 'A';
            int p2 = text.charAt(i+1) - 'A';

            int c1 = (key[0][0] * p1 + key[0][1] * p2) % 26;
            int c2 = (key[1][0] * p1 + key[1][1] * p2) % 26;

            result.append((char)(c1 + 'A'));
            result.append((char)(c2 + 'A'));
        }
        return result.toString();
    }

    public static String hillDecrypt(String cipher, int[][] key) {
        int det = key[0][0] * key[1][1] - key[0][1] * key[1][0];
        det = (det % 26 + 26) % 26;

        int invDet = modInverse(det, 26);
        if (invDet == -1) return "Inverse does not exist!";

        int[][] inv = {
            {( key[1][1] * invDet) % 26, ((-key[0][1] + 26) * invDet) % 26},
            {((-key[1][0] + 26) * invDet) % 26, ( key[0][0] * invDet) % 26}
        };

        return hillEncrypt(cipher, inv);
    }
     public static void main(String[] args){

         Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine();



         
        int[][] hillKey = { {3, 3}, {2, 5} };
        String hillEnc = hillEncrypt(text, hillKey);
        System.out.println("Encrypted: " + hillEnc);
        System.out.println("Decrypted: " + hillDecrypt(hillEnc, hillKey));
     } 
}
