/*Start

Input plaintext

Input substitution table (mapping for each letter)

For each character

Replace using mapping table

Display ciphertext

For decryption, reverse the mapping

Stop*/
import java.util.*;

class subst{
    static String plain = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String cipher = "QWERTYUIOPASDFGHJKLZXCVBNM";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine().toUpperCase();

        String encrypted = encrypt(text);
        String decrypted = decrypt(encrypted);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }

    static String encrypt(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = plain.indexOf(c);
                res.append(cipher.charAt(index));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    static String decrypt(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = cipher.indexOf(c);
                res.append(plain.charAt(index));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

  
