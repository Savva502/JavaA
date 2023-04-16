import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class za3AES5 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст для шифрования: ");
        String plainText = scanner.nextLine();

        System.out.print("Введите ключ шифрования (длина должна составлять 16, 24 или 32 символа): ");
        String encryptionKey = scanner.nextLine();

        byte[] key = encryptionKey.getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Зашифрованный текст: " + encryptedText);
    }
}