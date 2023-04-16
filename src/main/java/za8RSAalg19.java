import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class za8RSAalg19 {

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int bitlength = 1024;
    private int blocksize = 256;
    private SecureRandom random;

    public za8RSAalg19() {
        random = new SecureRandom();
        p = BigInteger.probablePrime(bitlength, random);
        q = BigInteger.probablePrime(bitlength, random);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, random);

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }

        d = e.modInverse(phi);
    }

    public List<BigInteger> encrypt(String message) {
        byte[] bytes = message.getBytes();
        List<BigInteger> blocks = new ArrayList<>();

        for (int i = 0; i < bytes.length; i += blocksize) {
            byte[] block = new byte[Math.min(blocksize, bytes.length - i)];
            for (int j = 0; j < block.length; j++) {
                block[j] = bytes[i + j];
            }
            blocks.add(new BigInteger(block).modPow(e, n));
        }

        return blocks;
    }

    public String decrypt(List<BigInteger> ciphertext) {
        byte[] bytes = new byte[ciphertext.size() * blocksize];
        int i = 0;

        for (BigInteger c : ciphertext) {
            byte[] block = c.modPow(d, n).toByteArray();
            System.arraycopy(block, 0, bytes, i, block.length);
            i += block.length;
        }

        return new String(bytes);
    }

    public static void main(String[] args) {
        za8RSAalg19 rsa = new za8RSAalg19();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сообщение: ");
        String message = scanner.nextLine();
        List<BigInteger> ciphertext = rsa.encrypt(message);
        System.out.println("Зашифрованый текст: " + ciphertext);
        String plaintext = rsa.decrypt(ciphertext);
        System.out.println("Открытый текст: " + plaintext);
    }
}