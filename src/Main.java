
public class Main extends Calculator {

    public static void main(String[] args) throws Exception {
        String firstNum;
        String secondNum;
        String operation;
        String[] symbol = readConsole().split(" ");
        try {
            firstNum = symbol[0];
            secondNum = symbol[2];
            operation = symbol[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Вы забыли ввести пробелы после введенного числа и " +
                    "арефметического символа");
        }
        firstNumber = checkNumber(firstNum);
        secondNumber = checkNumber(secondNum);
        checkCompatibility(isArabic, isRomain);

        if (isRomain) {
            operationsRomain(operation);
        } else {
            operationsArabic(operation);
        }
    }
}
