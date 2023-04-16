import java.util.Random;
import java.util.Scanner;

public class za10GenerCisel24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество случайных чисел: ");
        int count = scanner.nextInt();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int number = random.nextInt();
            System.out.println(number);
        }
    }
}