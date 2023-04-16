import java.util.Scanner;
public class za5RC410 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите ключ:");
        String key = input.nextLine();

        System.out.println("Введите данные для шифрования:");
        String data = input.nextLine();

        int[] S = new int[256];
        for (int i = 0; i < 256; i++) {
            S[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + key.charAt(i % key.length())) % 256;
            int temp = S[i];
            S[i] = S[j];
            S[j] = temp;
        }
        int i = 0;
        j = 0;
        String encrypted = "";
        for (int k = 0; k < data.length(); k++) {
            i = (i + 1) % 256;
            j = (j + S[i]) % 256;
            int temp = S[i];
            S[i] = S[j];
            S[j] = temp;
            int index = (S[i] + S[j]) % 256;
            int ascii = (int) data.charAt(k) ^ S[index];
            encrypted += (char) ascii;
        }
        System.out.println("Зашифрованные данные: " + encrypted);
        input.close();
    }
}