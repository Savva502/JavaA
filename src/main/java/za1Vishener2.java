import java.util.Scanner;
public class za1Vishener2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        String key = scanner.nextLine();
        System.out.print("Введите сообщение: ");
        String message = scanner.nextLine();
        String encrypted = encryptVigenere(message, key);
        System.out.println("Зашифрованное сообщение: " + encrypted);
    }
    public static String encryptVigenere(String message, String key) {
        String encrypted = "";
        int keyIndex = 0;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            char keyChar = key.charAt(keyIndex);
            int shift = (int) keyChar - 'a';
            char newChar = (char) (((int) c - 'a' + shift) % 26 + 'a');
            encrypted += newChar;
            keyIndex++;
            if (keyIndex == key.length()) {
                keyIndex = 0;
            }
        }
        return encrypted;
    }
}