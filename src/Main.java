import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while (true) {
            printMenu();
            int choice = sc.nextInt();

            if (choice == 1) {
                stepTracker.inputDataAndSteps();
            } else if (choice == 2) {
                stepTracker.outputStatistics();
            } else if (choice == 3) {
                stepTracker.printNewGoal();
            } else if (choice == 0) {
                System.out.println("Выход из приложения.");
                break;
            } else {
                System.out.println("Извините, данная команда пока что отсутствует.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Узнать статистику за месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}

