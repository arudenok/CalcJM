import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите числа от 1(I) до 10(X) и знак оперции +-*/ " + "\n" + "Вводим значения через пробел "
                + "\n" + "Пример: 1 + 1 " + "\n" + "        I + I" + "\n" + "Введите:"); // просим что-то ввести
        Scanner num = new Scanner(System.in);
        String strokaSznacheniyami = num.nextLine();
        String[] args1 = strokaSznacheniyami.split(" "); // разделили строку на слова/значения
//        Проверил сколько символов введено, бросил исключение

        if (args1.length > 3) throw new Exception("Ошибка, введено больше 3-х значений");
//      Выполняется если работа идет с Арабскими
        if (Arabic(args1)) {
            int first = Integer.parseInt(args1[0]); // переводим стринг с инт(первое значение)
            String znachSimvola = args1[1]; // вытаскиваем значение символа
            char simvol = znachSimvola.charAt(0); // преводим стринг в чар
            int second = Integer.parseInt(args1[2]); // переводим стринг в инт (второе значение)
//         Добавил два исключения на мин и макс значение
            if (first > 10 || second > 10) {
                throw new ArithmeticException("\n" + "Значение числа больше 10 " + "\n" + "Число должно быть от 1(I) до 10(X)"); // Исключение на макс число
            } else if (first <= 0 || second <= 0) {
                throw new ArithmeticException("\n" + "Значение числа должно быть больше 0, но не больше 10(X)"); // Исключение на мин число

            }

//          Определил знаки +-*/ и выполнил операции, в случае неподходящего знака кинул исключение

            if (simvol == '+') {                      // определяем знаки
                System.out.println("Ответ: " + (first + second));
            } else if (simvol == '-') {
                System.out.println("Ответ: " + (first - second));
            } else if (simvol == '*') {
                System.out.println("Ответ: " + (first * second));
            } else if (simvol == '/') {
                System.out.println("Ответ: " + (first / second));
            } else {
                throw new IllegalArgumentException("Неверный символ"); // Исключение на символ
            }

//            System.out.println(second + "\n" + first + "\n" + znachSimvola + "\n");


//      Выполняется если работа идет с римскими
        } else {
            int first = ConvertInRoma(args1[0]);// переводим в римские
            String znachSimvola = args1[1]; // вытаскиваем значение символа
            char simvol = znachSimvola.charAt(0);// преводим в римские
            int second = ConvertInRoma(args1[2]);

//      System.out.println("эЭто первое: " + first + "ЭТО второе: " + second + "Это знак; " + znachSimvola);

//      Добавил  исключения на мин - макс значения и исключение на отрицательное число
            if (first > 10 || second > 10) {
                throw new ArithmeticException();
            } else if (first <= 0 || second <= 0) {
                throw new ArithmeticException();
            } else if ((first < second) && simvol == '-') {
                throw new Exception("\n" + "Результатом работы калькулятора с римскими " + "числами могут быть только положительные числа!");
            } else {
                int result = 0;
                String result1 = "";

                if (simvol == '+') {
                    result = first + second;
                } else if (simvol == '-') {
                    result = first - second;
                } else if (simvol == '*') {
                    result = first * second;
                } else if (simvol == '/') {
                    result = first / second;
                } else {
                    throw new IllegalArgumentException("Неверный символ"); // Исключение на символ
                }

                while (result >= 100) {
                    result1 = result1 + "C";    // СТРОКА
                    result -= 100;
                }
                while (result >= 90) {
                    result1 = result1 + "XC";
                    result = result - 90;
                }
                while (result >= 50) {
                    result1 = result1 + "L";
                    result -= 50;
                }
                while (result >= 40) {
                    result1 = result1 + "XL";
                    result -= 40;
                }
                while (result >= 10) {
                    result1 = result1 + "X";
                    result -= 10;
                }
                while (result >= 9) {
                    result1 = result1 + "IX";
                    result -= 9;
                }
                while (result >= 5) {
                    result1 = result1 + "V";
                    result -= 5;
                }
                while (result >= 4) {
                    result1 = result1 + "IV";
                    result -= 4;
                }
                while (result >= 1) {
                    result1 = result1 + "I";
                    result -= 1;
                }

                System.out.println("Ответ: " + result1);

            }
        }
    }

    private static boolean Arabic(String[] args1) {
        try {
            Integer.parseInt(args1[0]);
            Integer.parseInt(args1[2]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int ConvertInRoma(String roman) {
        switch (roman) {
            case "0":
                return 0;
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return 0;

        }

    }
}

