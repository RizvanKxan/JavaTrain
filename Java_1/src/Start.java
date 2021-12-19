import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        int choice;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            choice = 0;
            System.out.println("-------------------------------------------");
            System.out.println("Выберите задание которое желаете проверить:");
            System.out.println("1. Разделение одной строки на несколько.");
            System.out.println("2. Вычисление процента от числа.");
            System.out.println("3. Склеить три цифры в одно число.");
            System.out.println("4. Заменить в шестизначном числе 1-ю и 6-ю, а также 2-ю и 5-ю цифру.");
            System.out.println("5. По номеру месяца вывести время года.");
            System.out.println("6. Перевести метры в другое измерение.");
            System.out.println("13. Выход.");
            System.out.println("-------------------------------------------");
            System.out.print("Введите значение: ");
            String input = reader.readLine();
            if (tryParseInt(input)) {
                choice = Integer.parseInt(input);
            }
            else {
                System.out.println("-------------------------------------------");
                System.out.println("Ввод не корректен!");
                System.out.println("-------------------------------------------");
            }

            switch (choice){
                case 1:
                    System.out.println("*******************************************");
                    task1();
                    System.out.println("*******************************************");

                    break;
                case 2:
                    System.out.println("*******************************************");
                    task2();
                    System.out.println("*******************************************");
                    break;
                case 3:
                    System.out.println("*******************************************");
                    task3();
                    System.out.println("*******************************************");
                    break;
                case 4:
                    System.out.println("*******************************************");
                    task4();
                    System.out.println("*******************************************");
                    break;
                case 5:
                    System.out.println("*******************************************");
                    task5();
                    System.out.println("*******************************************");
                case 6:
                    System.out.println("*******************************************");
                    task6();
                    System.out.println("*******************************************");
                case 13:
                    break;
                default:
                    System.out.println("Такого задания нет!");
            }
        }while (choice !=13);
    }

    /** Функция проверки сможем ли мы парсить значение*/
    static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /** Функция проверки сможем ли мы парсить значение*/
    static boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    static void task1(){
        System.out.println(" \" Your time is limited,");
        System.out.println(" \t so don’t waste it");
        System.out.println(" \t\t living someone else’s life\"");
        System.out.println(" \t\t\t Steve Jobs");
    }
    static void  task2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите целое число: ");
        String inputValue = reader.readLine();
        System.out.print("Введите процент который необходимо посчитать: ");
        String inputProc = reader.readLine();
        if(tryParseDouble(inputValue) && tryParseDouble(inputProc)){
            double value = Double.parseDouble(inputValue);
            double procent = Double.parseDouble(inputProc);
            double result = (double) ((value * procent)/100);
            System.out.println(result);
        }
    }

    static void  task3() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите первую цифру: ");
        String xString = reader.readLine();
        System.out.print("Введите вторую цифру: ");
        String yString = reader.readLine();
        System.out.print("Введите третью цифру: ");
        String zString = reader.readLine();
        if(tryParseInt(xString) && tryParseInt(yString) && tryParseInt(zString)){
            int x = Integer.parseInt(xString);
            int y = Integer.parseInt(yString);
            int z = Integer.parseInt(zString);
            if((x >= 0 && x <= 9) &&
                    (y >= 0 && y <= 9) &&
                    (z >= 0 && z <= 9)) {
                StringBuilder resultString = new StringBuilder();
                resultString.append(x).append(y).append(z);
                if(tryParseInt(resultString.toString())) {
                    int result = Integer.parseInt(resultString.toString());
                    System.out.println("Результат: " + result);
                }
            }
            else {
                System.out.println("Условия не соблюдены!");
            }
        }
    }

    static void task4() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите шестизначное число: ");
        String input = reader.readLine();
        if(!tryParseInt(input) || input.length() != 6){
            System.out.println("Ошибка ввода. Необходимо ввести шестизначное число!");
        }
        else {
            System.out.println("Введённое число: " + input);
            char charInput[] = new char[input.length()];
            input.getChars(0,6, charInput, 0);
            char tempChar = charInput[0];
            charInput[0] = charInput[5];
            charInput[5] = tempChar;
            tempChar = charInput[1];
            charInput[1] = charInput[4];
            charInput[4] = tempChar;
            input = new String(charInput);

            System.out.println("Результат замены: " + input);
        }
    }

    static void task5() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число от 1 до 12: ");
        String input = reader.readLine();
        if(tryParseInt(input)) {
            int inputInt = Integer.parseInt(input);
            if(inputInt >= 1 && inputInt <= 12) {
                switch (inputInt){
                    case 1, 2, 12:
                        System.out.println("Winter.");
                        break;
                    case 3, 4, 5:
                        System.out.println("Spring.");
                        break;
                    case 6, 7, 8:
                        System.out.println("Summer.");
                        break;
                    case 9, 10, 11:
                        System.out.println("Autumn.");
                        break;
                }
            }
            else {
                System.out.println("Некорректное число.");
            }
        }
        else {
            System.out.println("Неверные данные.");
        }
    }

    static  void task6() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество метров для перевода: ");
        String inputString = reader.readLine();
        if(tryParseDouble(inputString)) {
            double collMetr = Double.parseDouble(inputString);
            System.out.println("Введите цифру во что нужно перевести:");
            System.out.println("1. Мили.");
            System.out.println("2. Дюймы.");
            System.out.println("3. Ярды.");
            inputString = reader.readLine();
            double result;
            switch (inputString){
                case "1":
                    result = collMetr / 1609.34;
                    System.out.println("Количество миль: " + result);
                    break;
                case "2":
                    result = collMetr * 39.37;
                    System.out.println("Количество дюймов: " + result);
                    break;
                case "3":
                    result = collMetr * 1.09;
                    System.out.println("Количество ярдов: " + result);
                    break;
            }
        }

    }
}
