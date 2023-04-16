import java.util.Scanner;

public class za2Perestanovka3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        int key = scanner.nextInt();
        scanner.nextLine(); // читаем символ новой строки после ключа
        System.out.print("Введите сообщение: ");
        String message = scanner.nextLine();
        String encrypted = encryptTransposition(message, key);
        System.out.println("Зашифрованное сообщение: " + encrypted);
    }

    public static String encryptTransposition(String message, int key) {
        int rows = message.length() / key + 1;
        char[][] matrix = new char[rows][key];
        int index = 0;
        for (int j = 0; j < key; j++) {
            for (int i = 0; i < rows && index < message.length(); i++) {
                matrix[i][j] = message.charAt(index);
                index++;
            }
        }
        String encrypted = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key; j++) {
                encrypted += matrix[i][j];
            }
        }
        return encrypted;
    }
}