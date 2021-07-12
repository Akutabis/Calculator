import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    static String[] romain = {"0","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] arabic = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static boolean isArabic;
    static boolean isRomain;
    static int firstNumber;
    static int secondNumber;
    static StringBuilder sb = new StringBuilder();


    public static String readConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите арифметическую операцию в одну строку.\n" +
                "Так же калькулятор поддерживает римские числа\n" +
                "(только целые числа от 1 до 10, например 10 * 10 или IX + VIII):\n");
        return in.nextLine();
    }

    public static int checkNumber(String s) throws Exception {

        int number = 0;
        boolean numberIsNull = true;

        for (int i = 1; i < 11; i++) {
            if (s.equals(arabic[i])) {
                isArabic = true;
                return i;
            } else if (s.equals(romain[i])) {
                isRomain = true;
                return i;
            }
        }
        if (numberIsNull) {
            throw new Exception("Введены некорекктные данные, введите числа от 1 до 10");
        }
        return number;
    }
    public static void checkCompatibility(boolean a, boolean b) throws Exception {
        if (a == b) {
            throw new Exception("Числа не совместимы.");
        }
    }


    public static void operationsArabic(String s) throws Exception {
        int result = switch (s) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            default -> throw new Exception("Вы ввели неверный арифметический символ");
        };
        System.out.println("Ответ : " + result);
    }

    public static void operationsRomain(String s) throws Exception {

        int result;
        int i = 0;
        List<RomainNumbers> romainNumbers = Arrays.asList(RomainNumbers.values());

        result = switch (s) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            default -> throw new Exception("Вы ввели неверный арифметический символ");
        };
        if (result == 0) {
            throw new Exception("В римских цыфрах нет значения которое соответствует арабскому 0");
        } else {
            while ((result > 0) && (i < romainNumbers.size())) {
                RomainNumbers currentSymbol = romainNumbers.get(i);
                if (currentSymbol.value <= result) {
                    sb.append(currentSymbol.name());
                    result = result - currentSymbol.value;
                } else {
                    i++;
                }
            }

            System.out.println("Ответ : " + sb);
        }
    }

}
