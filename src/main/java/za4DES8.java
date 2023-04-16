import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.*;

public class za4DES8 {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные для шифрования:");
            String data = scanner.nextLine();

            byte[] keyBytes = {
                    (byte)0x01, (byte)0x02, (byte)0x03, (byte)0x04,
                    (byte)0x05, (byte)0x06, (byte)0x07, (byte)0x08
            };
            SecretKey key = new SecretKeySpec(keyBytes, "DES");

            byte[] ivBytes = {
                    (byte)0x08, (byte)0x07, (byte)0x06, (byte)0x05,
                    (byte)0x04, (byte)0x03, (byte)0x02, (byte)0x01
            };
            IvParameterSpec iv = new IvParameterSpec(ivBytes);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);

            byte[] encryptedData = cipher.doFinal(data.getBytes());

            for (byte b : encryptedData) {
                System.out.print(String.format("%02X ", b));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}