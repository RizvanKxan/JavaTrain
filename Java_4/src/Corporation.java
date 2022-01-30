import java.util.ArrayList;
import java.util.List;

public class Corporation {
    private ArrayList<Worker> workers = new ArrayList<Worker>(30);


    public Corporation() {
        workers.add(new Worker("Леонид", "Громыко", 30));
        workers.add(new Worker("Сергей", "Васильев", 24));
        workers.add(new Worker("Маргарита", "Скавыш", 41));
    };

    public void addWorker(Worker worker) {
        workers.add(worker);
    }
    public void addWorker(String firstName, String secondName, int age ) {
        Worker temp = new Worker(firstName, secondName, age);
        workers.add(temp);
    }

    public void printCountWorkers() {
        System.out.println("Количество людей в корпорации: " + workers.size() + ".");
    }

    public List<Worker> getAllWorkers() {
        return workers;
    }

    public List<Worker> getWorkerBySecondName(String secondName) {
        return workers.stream().filter(s -> s.secondName == secondName).toList();
    }

    public List<Worker> getWorkerByAge(int age) {
        return workers.stream().filter(s -> s.getAge() == age).toList();
    }

    public List<Worker> getWorkerByLetter(char letter) {
        return workers.stream().filter(s -> s.secondName.charAt(0) == letter).toList();
    }
}
