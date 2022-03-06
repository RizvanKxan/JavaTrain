import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Corporation {
    private final ArrayList<Worker> workers = new ArrayList<>(30);

    public Corporation() {
        workers.add(new Worker("Леонид", "Громыко", false, LocalDate.of(1992,12,31), "+37527683264", Position.DIRECTOR, LocalDate.of(2019,12,1), 1600));
        workers.add(new Worker("Сергей", "Васильев", false, LocalDate.of(1990,1,21), "+375298653215", Position.CHIEF_ENGINEER, LocalDate.of(2020,1,3), 1300));
        workers.add(new Worker("Маргарита", "Скавыш", true, LocalDate.of(1985,3,12), "+375296543264", Position.HEAD_ECONOMIST, LocalDate.of(2020,1,3), 1250));
        workers.add(new Worker("Евгения", "Бойцова", true, LocalDate.of(1999,2,14), "+375299433214", Position.WORKER, LocalDate.of(2020,1,15), 900));
        workers.add(new Worker("Александр", "Стрелков", false, LocalDate.of(2000,5,1), "+375293437211", Position.WORKER, LocalDate.of(2020,1,15), 900));
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public List<Worker> getAllWorkers() {
        return workers;
    }

    public List<Worker> getWorkerByID(int ID) {
        return workers.stream().filter(s -> s.getID() == ID).toList();
    }

    public List<Worker> getWorkerByName(String firstName, String secondName) {
        return workers.stream().filter(s -> s.firstName.equals(firstName) && s.secondName.equals(secondName)).toList();
    }

    public List<Worker> getWorkerByPosition(Position position) {
        return workers.stream().filter(s -> s.getPosition() == position).toList();
    }

    public double getAverageSalary() {
        return workers.stream().mapToDouble(Worker::getSalary).average().orElse(0);
    }

    public boolean isRemoveWorker(int ID) {
        try {
            workers.removeIf(s -> s.getID() == ID);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isEditWorker(int ID) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Worker worker = workers.stream().filter(s -> s.getID() == ID).toList().get(0);
            while (true) {
                System.out.println("Выберите что хотите изменить: ");
                System.out.println("1. Должность.");
                System.out.println("2. Зарплату.");
                System.out.println("3. Телефон.");
                System.out.println("4. Выход.");
                System.out.print("Ваш выбор: ");
                byte choice = Byte.parseByte(reader.readLine());
                switch (choice) {
                    case 1 -> {
                        System.out.println("Укажите код должности.");
                        System.out.println("1 - Главный инженер.");
                        System.out.println("2 - Главный экономист.");
                        System.out.println("3 - Коммерческий директор.");
                        System.out.println("4 - Работник производства.");
                        System.out.print("Введите цифру: ");
                        byte num = Byte.parseByte(reader.readLine());
                        Position position = switch (num) {
                            case 1 -> Position.CHIEF_ENGINEER;
                            case 2 -> Position.HEAD_ECONOMIST;
                            case 3 -> Position.COMMERCIAL_DIRECTOR;
                            default -> Position.WORKER;
                        };
                        worker.setPosition(position);
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("\t\t\t\t\t\t\tДолжность изменена!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                    case 2 -> {
                        System.out.print("Введите новую зарплату: ");
                        int salary = Integer.parseInt(reader.readLine());
                        worker.setSalary(salary);
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("\t\t\t\t\t\t\tЗарплата изменена!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                    case 3 -> {
                        System.out.print("Введите новый телефон: ");
                        String phone = reader.readLine();
                        worker.setPhone(phone);
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("\t\t\t\t\t\t\tТелефон изменён!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                }
                if(choice == 4) break;
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
