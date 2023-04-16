import java.util.Scanner;

public class za6XOR11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для шифрования: ");
        String originalText = scanner.nextLine();
        System.out.print("Введите ключ для шифрования: ");
        String key = scanner.nextLine();

        byte[] textBytes = originalText.getBytes();
        byte[] keyBytes = key.getBytes();

        byte[] encryptedBytes = new byte[textBytes.length];
        for (int i = 0; i < textBytes.length; i++) {
            encryptedBytes[i] = (byte) (textBytes[i] ^ keyBytes[i % keyBytes.length]);
        }

        String encryptedText = new String(encryptedBytes);
        System.out.println("Зашифрованный текст: " + encryptedText);
    }
}