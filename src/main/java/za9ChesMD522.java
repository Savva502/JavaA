import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class za9ChesMD522 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку для хэширования: ");
        String inputString = scanner.nextLine();

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(inputString.getBytes());
        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        String hashedString = sb.toString();
        System.out.println("Хэш-значение: " + hashedString);
    }
}