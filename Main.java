import java.util.Scanner;

import tax.minus.TaxEarningsMinus;
import tax.TaxEarnings;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;
        //Цикл будет работать, пока пользователь не введет `end`
        while (true) {
            // Выводим информацию о возможных операциях пользователю
            System.out.println("Введите 'end' для завершения програмы");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Ввод: ");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    // действия при выборе второй операции
                    System.out.println("Введите сумму расхода:");
                    String expenditureStr = scanner.nextLine();
                    int expenditure = Integer.parseInt(expenditureStr);
                    spendings += expenditure;
                    break;
                case 3:
                    int taxMinus = TaxEarningsMinus.taxMinus(earnings, spendings);
                    int tax = TaxEarnings.taxEarning(earnings);
                    if (taxMinus > tax) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + tax);
                        System.out.println("Налог на другой системе: " + taxMinus);
                        System.out.println("Экономия: " + (taxMinus - tax));
                    } else if (tax > taxMinus) {
                        System.out.println("Мы советуем вам УСН доходы минус расход");
                        System.out.println("Ваш налог составит: " + taxMinus);
                        System.out.println("Налог на другой системе: " + tax);
                        System.out.println("Экономия: " + (tax - taxMinus));
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                        System.out.println("Ваш налог доход минус расход составит: " + taxMinus);
                        System.out.println("Ваш налог на доход составит: " + tax);
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");

    }
}
