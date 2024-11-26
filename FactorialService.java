import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactorialService {

    private static final Logger LOGGER = Logger.getLogger(FactorialService.class.getName());

    public static List<BigInteger> generateFactorials(int n) {
        if (n <= 0) {
            LOGGER.log(Level.SEVERE, "Входное значение должно быть положительным числом, получено: {0}", n);
            throw new IllegalArgumentException("Входное значение должно быть положительным числом.");
        }

        List<BigInteger> factorials = new ArrayList<>();
        BigInteger currentFactorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                factorials.add(BigInteger.ONE);
            } else {
                currentFactorial = currentFactorial.multiply(BigInteger.valueOf(i));
                factorials.add(currentFactorial);
            }
        }

        return factorials;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите n: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Введите целое число.");
                return;
            }

            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Введите положительное натуральное число.");
                return;
            }

            List<BigInteger> factorials = generateFactorials(n);
            System.out.println("Первые " + n + " факториалов:");
            for (int i = 0; i < factorials.size(); i++) {
                System.out.println((i + 1) + "! = " + factorials.get(i));
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
