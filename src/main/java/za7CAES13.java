import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class za7CAES13 {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину ключа (128, 192 или 256): ");
        int keyLength = scanner.nextInt();
        scanner.close();

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(keyLength);
        SecretKey secretKey = keyGenerator.generateKey();

        System.out.println("Сгенерированный ключ: " + byteArrayToHexString(secretKey.getEncoded()));
    }

    private static String byteArrayToHexString(byte[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : array) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }
}