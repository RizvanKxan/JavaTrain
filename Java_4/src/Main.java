import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        while (true) {
            System.out.println("Выберите задание: ");
            System.out.println("1. Результаты лямбда выражений. ");
            System.out.println("2. Сохранение массива в файл по условию. ");
            System.out.println("3. Информационная система Корпорация. ");
            System.out.println("4. Выход. ");
            System.out.print("Выбор: ");
            choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1: {
                    Predicate<Integer> predicate1 = (s) -> s > 0;
                    Predicate<Integer> predicate2 = (s) -> s < 0;
                    Predicate<Integer> predicate3 = (s) -> s == 1;
                    Predicate<Integer> predicate4 = (s) -> (s < 5) || (s > 10);
                    Integer[] mass1 = {1,6,-1,1,1,11};
                    System.out.println("****************************************************************************");
                    System.out.println("Массив чисел: [1,6,-1,1,1,11]");
                    System.out.println("Сумма положительных чисел = " + summ(predicate1,mass1));
                    System.out.println("Сумма отрицательных чисел =  = " + summ(predicate2,mass1));
                    System.out.println("Сумма чисел равных единице = " + summ(predicate3,mass1));
                    System.out.println("Сумма чисел не входящих в диапазон от 5 до 10 = " + summ(predicate4,mass1));
                    System.out.println("****************************************************************************");
                    break;
                }
                case 2: {
                   // String examplePath = "D:\\test.txt";
                    System.out.print("Введите полный путь к файлу: ");
                    String path = reader.readLine();
                    System.out.println("Через пробел введите целые числа: ");
                    String str = reader.readLine();
                    int[] numArr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
                    int[] numChet = Arrays.stream(numArr).filter((x) -> x % 2 == 0).toArray();
                    int[] notNumChet = Arrays.stream(numArr).filter((x) -> x % 2 != 0).toArray();

                    int[] numArrRevers = new int[numArr.length];
                    for (int i = 0; i < numArr.length; i++) {
                        numArrRevers[i] = numArr[(numArr.length - 1) - i];
                    }

                    String numArrReversStr = Arrays.toString(numArrRevers)
                            .replaceAll("\\[|\\]|,|\\s", " ")
                            .replaceAll(" +", " ");
                    String numChetStr = Arrays.toString(numChet)
                            .replaceAll("\\[|\\]|,|\\s", " ")
                            .replaceAll(" +", " ");
                    String notNumChetStr = Arrays.toString(notNumChet)
                            .replaceAll("\\[|\\]|,|\\s", " ")
                            .replaceAll(" +", " ");

                    File file = new File(path);
                    if ( ! file.exists()){
                        try {
                            if( file.createNewFile() ) {
                                System.out.println("****************************************************************************");
                                System.out.println("Файл создан!");
                                System.out.println("****************************************************************************");
                            }
                            else {
                                System.out.println("****************************************************************************");
                                System.out.println("Ошибка создания файла!");
                                System.out.println("****************************************************************************");
                            }
                        } catch (IOException ex) {  }
                    }


                    try(FileWriter writer = new FileWriter(file, true))
                    {
                        writer.write("****************************************************************************");
                        writer.write("\n" + "Массив чисел: " + str + "\n");
                        writer.write("Чётные числа: " + numChetStr + "\n");
                        writer.write("Не чётные числа: " + notNumChetStr + "\n");
                        writer.write("Перевёрнутый массив: " + numArrReversStr);
                        System.out.println("****************************************************************************");
                        System.out.println("Запись в файл прошла успешно.");
                        System.out.println("****************************************************************************");

                        writer.flush();
                    }
                    catch(IOException ex){

                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 3:{
                    Corporation corporation = new Corporation();
                    Worker worker = new Worker("Человек", "Человекович", 66);
                    System.out.println("****************************************************************************");
                    corporation.addWorker(worker);
                    corporation.addWorker("Василий", "Яскевич", 34);
                    corporation.addWorker("Степан", "Яскевич", 24);
                    corporation.printCountWorkers();
                    System.out.println("****************************************************************************");
                    System.out.println("Вывод всех сотрудников корпорации.");
                    printCollection(corporation.getAllWorkers());
                    System.out.println("****************************************************************************");
                    System.out.println("Поиск сотрудников с фамилией 'Яскевич':");
                    printCollection(corporation.getWorkerBySecondName("Яскевич"));
                    System.out.println("****************************************************************************");
                    System.out.println("Поиск сотрудников по возрасту '24':");
                    printCollection(corporation.getWorkerByAge(24));
                    System.out.println("****************************************************************************");
                    System.out.println("Поиск сотрудников фамилия которых начинается на букву 'C':");
                    printCollection(corporation.getWorkerByLetter('С'));
                    System.out.println("****************************************************************************");

                    break;
                }
            }
            if(choice == 4) return;
        }

    }

    public static int summ(Predicate<Integer> predicate, Integer[] mass) {
        Integer result = 0;
        List<Integer> list = Arrays.stream(mass)
                .filter(predicate)
                .collect(Collectors.toList());

        for(Integer s: list) {
            result += s;
        }
        return result;
    }

    public static void printCollection(List<Worker> workers) {
        workers.stream().forEach(s -> System.out.println(s.toString()));
    }
}

