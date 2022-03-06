import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Corporation corporation = new Corporation();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        while (true) {
            System.out.println("****************************************************************************");
            System.out.println("Выберите действие: ");
            System.out.println("1. Зайти в управление Организацией. ");
            System.out.println("2. Посчитать среднюю зарплату организации. ");
            System.out.println("3. Сформировать структуру организации. ");
            System.out.println("4. Выйти из приложения. ");
            System.out.println("****************************************************************************");
            System.out.print("Выбор: ");
            choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1 -> {
                    while (true) {
                        choice = 0;
                        System.out.println("----------------------------------------------------------------------------");
                        System.out.println("Выберите действие: ");
                        System.out.println("1. Найти сотрудника. ");
                        System.out.println("2. Добавить нового сотрудника. ");
                        System.out.println("3. Уволить сотрудника. ");
                        System.out.println("4. Изменить данные сотрудника. ");
                        System.out.println("5. Показать всех сотрудников. ");
                        System.out.println("6. Выйти из управления. ");
                        System.out.println("----------------------------------------------------------------------------");
                        System.out.print("Выбор: ");
                        choice = Integer.parseInt(reader.readLine());
                        switch (choice) {
                            case 1:
                                System.out.println("****************************************************************************");
                                System.out.println("Выберите действие: ");
                                System.out.println("1. Найти сотрудника по ID.");
                                System.out.println("2. Найти сотрудника по Фамилии и Имени.");
                                System.out.println("3. Найти сотрудника по должности.");
                                System.out.println("****************************************************************************");

                                System.out.print("Выбор: ");
                                choice = Integer.parseInt(reader.readLine());
                                switch (choice) {
                                    case 1 -> {
                                        System.out.print("Введите ID работника: ");
                                        int ID = Integer.parseInt(reader.readLine());
                                        printCollection(corporation.getWorkerByID(ID));
                                    }
                                    case 2 -> {
                                        System.out.println("!!! Введите необходимые данные !!!");
                                        System.out.print("Имя: ");
                                        String firstName = reader.readLine();
                                        System.out.print("Фамилия: ");
                                        String secondName = reader.readLine();
                                        printCollection(corporation.getWorkerByName(firstName, secondName));
                                    }
                                    case 3 -> {
                                        System.out.println("Укажите код должности.");
                                        System.out.println("0 - Директор.");
                                        System.out.println("1 - Главный инженер.");
                                        System.out.println("2 - Главный экономист.");
                                        System.out.println("3 - Коммерческий директор.");
                                        System.out.println("4 - Работник производства.");
                                        System.out.print("Введите цифру: ");
                                        choice = Integer.parseInt(reader.readLine());
                                        Position position = switch (choice) {
                                            case 0 -> Position.DIRECTOR;
                                            case 1 -> Position.CHIEF_ENGINEER;
                                            case 2 -> Position.HEAD_ECONOMIST;
                                            case 3 -> Position.COMMERCIAL_DIRECTOR;
                                            default -> Position.WORKER;
                                        };
                                        printCollection(corporation.getWorkerByPosition(position));
                                        choice = 0;
                                    }
                                }
                                break;
                            case 2:
                                try {
                                    corporation.addWorker(tryAddWorker());
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("\t\t\t\t\tРаботник успешно принят на работу!");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                } catch (Exception ex) {
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("\t\t\t\t\tРаботник не принят! Данные не корректны!");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                }
                                break;
                            case 3: {
                                System.out.print("Введите ID сотрудника которого необходимо уволить: ");
                                int ID = Integer.parseInt(reader.readLine());
                                if(corporation.getWorkerByID(ID).size() == 0) {
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("\t\t\t\t\tСотрудника с таким ID не существует!");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    break;
                                }
                                if(corporation.isRemoveWorker(ID)) {
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("\t\t\t\t\t\t Сотрудник уволен.");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                }
                                else {
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("\t\t\t\t\t\t Ошибка удаления.");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                }
                            }
                            break;
                            case 4: {
                                System.out.print("Введите ID сотрудника данные которого необходимо изменить: ");
                                int ID = Integer.parseInt(reader.readLine());
                                if(corporation.getWorkerByID(ID).size() == 0) {
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("\t\t\t\t\tСотрудника с таким ID не существует!");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    break;
                                }
                                if(corporation.isEditWorker(ID)) {
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("\t\t\t\t\t\t Данные сотрудника изменены.");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                }
                                else {
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    System.out.println("\t\t\t\t\t\t Ошибка изменения.");
                                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                }
                            }
                            break;
                            case 5:
                                printCollection(corporation.getAllWorkers());
                                break;
                            case 6:
                                break;
                        }
                        if (choice == 6) break;
                    }
                    choice = 0;
                }
                case 2 -> System.out.println("Средняя зарплата организации: " + corporation.getAverageSalary());
                case 3 -> {
                    getStructure(corporation.getAllWorkers());
                }
            }
            if (choice == 4) return;
        }

    }

    public static void printCollection(List<Worker> workers) {
        workers.forEach(s -> System.out.println(s.toString()));
        if (workers.size() == 0) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("\t\t\t\t\t\t Таких работников не найдено!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public static Worker tryAddWorker() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\t\t\t\t\t!!! Введите необходимые данные !!!");
        System.out.print("Имя: ");
        String firstName = reader.readLine();
        System.out.print("Фамилия: ");
        String secondName = reader.readLine();
        System.out.println("Если женщина введите цифру - 1, если мужчина - 2.");
        System.out.print("Введите цифру: ");
        byte num = Byte.parseByte(reader.readLine());
        boolean isFemale;
        if (num == 1) {
            isFemale = true;
        } else if (num == 2){
            isFemale = false;
        } else {
            throw new IOException();
        }
        System.out.print("Введите год рождения: ");
        int year = Integer.parseInt(reader.readLine());
        System.out.print("Введите месяц рождения: ");
        int month = Integer.parseInt(reader.readLine());
        System.out.print("Введите день рождения: ");
        int day = Integer.parseInt(reader.readLine());
        LocalDate age = LocalDate.of(year, month, day);
        System.out.print("Введите номер телефона: ");
        String phone = reader.readLine();
        System.out.println("Укажите код должности.");
        System.out.println("1 - Главный инженер.");
        System.out.println("2 - Главный экономист.");
        System.out.println("3 - Коммерческий директор.");
        System.out.println("4 - Работник производства.");
        System.out.print("Введите цифру: ");
        num = Byte.parseByte(reader.readLine());
        Position position = switch (num) {
            case 1 -> Position.CHIEF_ENGINEER;
            case 2 -> Position.HEAD_ECONOMIST;
            case 3 -> Position.COMMERCIAL_DIRECTOR;
            default -> Position.WORKER;
        };
        LocalDate dateOfReceipt = LocalDate.now();
        System.out.print("Введите зарплату работника: ");
        int salary = Integer.parseInt(reader.readLine());
        return new Worker(firstName, secondName, isFemale, age, phone, position, dateOfReceipt, salary);
    }

    public static void getStructure(List<Worker> workers) {
        System.out.println("[Руководство]:");
        System.out.println("----------------------------------------------------------------------------");
        workers.stream().filter(s -> s.getPosition() == Position.DIRECTOR).toList().forEach(s -> System.out.println("\t" + s.firstName + " " + s.secondName + " - " + s.getPosition()));
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("[Администрация]:");
        System.out.println("----------------------------------------------------------------------------");
        workers.stream().filter(s -> s.getPosition() != Position.DIRECTOR && s.getPosition() != Position.WORKER).toList().forEach(s -> System.out.println("\t" + s.firstName + " " + s.secondName + " - " + s.getPosition()));
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("[Рабочие]:");
        System.out.println("----------------------------------------------------------------------------");
        workers.stream().filter(s -> s.getPosition() == Position.WORKER).toList().forEach(s -> System.out.println("\t" + s.firstName + " " + s.secondName + " - " + s.getPosition()));
    }
}

