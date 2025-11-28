/*Start

Enter plaintext

Enter key (shift value)

For each character in plaintext

Shift it by key (add key)

Convert back to character

Print ciphertext

For decryption

Shift characters in opposite direction

Stop*/

import java.util.Scanner;

public class Ceaser {
    




     public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(c); 
            }
        }
        return result.toString();
    }

    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);
    }
      public static void main(String[] args){

              Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine();

        
        System.out.println("\n--- CAESAR CIPHER ---");
        String caesEnc = caesarEncrypt(text, 3);
        System.out.println("Encrypted (shift=3): " + caesEnc);
        System.out.println("Decrypted: " + caesarDecrypt(caesEnc, 3));
      }

}

