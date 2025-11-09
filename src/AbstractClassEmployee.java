abstract class Employee {
    String name;
    Employee(String name) { this.name = name; }
    abstract double calculateBonus();
}

class Developer extends Employee {
    double baseSalary;
    Developer(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    double calculateBonus() { return baseSalary * 0.10; }
    void code() { System.out.println(name + " is coding"); }
}

class Manager extends Employee {
    double baseSalary;
    Manager(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    double calculateBonus() { return baseSalary * 0.20; }
    void manage() { System.out.println(name + " is managing"); }
}

public class AbstractClassEmployee {
    public static void main(String[] args) {
        Employee[] employees = {
                new Developer("Alice", 80000),
                new Manager("Bob", 100000)
        };

        for (Employee e : employees) {
            System.out.println(e.name + " bonus: $" + e.calculateBonus());

            if (e instanceof Developer) {
                ((Developer) e).code();
            } else if (e instanceof Manager) {
                ((Manager) e).manage();
            }
        }
    }
}
