import java.util.Scanner;

public class StepTracker {
    Scanner sc = new Scanner(System.in);
    int goal = 10_000;
    int[][] step = new int[12][31];
    int sum = 0;

    void inputDataAndSteps() {
        while (true) {
            printMonth();
            int month = sc.nextInt();
            while (month < 0 || month > 11) {
                System.out.println("Вы неправильно указали номер. Повторите ввод (от 0 до 11)");
                month = sc.nextInt();
            }
            System.out.println("Укажите день, за который вы хотите ввести количество шагов (от 1 до 30)");
            int day = sc.nextInt();
            while (day < 1 || day > 30) {
                System.out.println("Такого дня не существует. Повторите ввод (от 1 до 30)");
                day = sc.nextInt();
            }
            System.out.println("Укажите количество шагов, пройденных в этот день");
            int steps = sc.nextInt();
            while (steps < 0) {
                System.out.println("Число шагов не может быть отрицательным значением. Укажите неотрицательное количество шагов.");
                steps = sc.nextInt();
            }
            step[month][day - 1] = steps;
            System.out.println("Введите 0, если хотите прекратить ввод шагов, и 1 - если хотите продолжить");
            int stop = sc.nextInt();
            if (stop == 0) {
                System.out.println("Ввод шагов закончен");
                return;
            }
        }
    }

    static void printMonth() {
        System.out.println("Укажите номер месяца");
        System.out.println("0-январь");
        System.out.println("1-февраль");
        System.out.println("2-март");
        System.out.println("3-апрель");
        System.out.println("4-май");
        System.out.println("5-июнь");
        System.out.println("6-июль");
        System.out.println("7-август");
        System.out.println("8-сентябрь");
        System.out.println("9-октябрь");
        System.out.println("10-ноябрь");
        System.out.println("11-декабрь");
    }

    void printNewGoal() {
        System.out.println("Какая ваша цель по количеству шагов в день?");
        goal = sc.nextInt();
        while (goal < 0) {
            System.out.println("Ошибка. Введите неотрицательное количество шагов.");
            goal = sc.nextInt();
        }
        System.out.println("Цель изменена.");
    }

    void outputStatistics() {
        printMonth();
        int month = sc.nextInt();
        int max = 0;
        while (month < 0 || month > 11) {
            System.out.println("Вы неправильно указали номер. Повторите ввод (от 0 до 11)");
            month = sc.nextInt();
        }
        for (int j = 0; j < 30; j++) {
            if (max < step[month][j]) {
                max = step[month][j];
            }
            sum = sum + step[month][j];
            System.out.println((j + 1) + " день: " + step[month][j]);
        }

        System.out.println("Общее количество шагов за месяц - " + sum);
        System.out.println("Максимальное пройденное количество шагов в месяце - " + max);
        System.out.println("Среднее количество шагов - " + (sum / 30.0));
        Converter converter = new Converter();
        System.out.println("Пройденная дистанция (в км) - " + converter.distance(sum));
        System.out.println("Количество сожжённых килокалорий - " + converter.getKkal(sum));
        getMaxGoalDays(month);
    }

    void getMaxGoalDays(int month) {
        int maxK = 0;
        int k = 0;
        for (int j = 0; j < 30; j++) {
            if (step[month][j] >= goal) {
                k = k + 1;
                if (maxK < k) {
                    maxK = k;
                }
            } else {
                k = 0;
            }
        }
        System.out.println("Максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого - " + maxK);
    }

}

