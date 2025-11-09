class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // Method to be overridden
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }

    public void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    // Additional specific behavior
    public void fetch() {
        System.out.println("Fetching the ball!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public void climbTree() {
        System.out.println("Climbing the tree!");
    }
}

// Demonstration
public class RuntimePolymorphism {
    public static void main(String[] args) {
        // Polymorphism in action
        Animal myDog = new Dog("Buddy");
        Animal myCat = new Cat("Whiskers");

        myDog.makeSound();  // Output: Woof! Woof! (Dog's implementation)
        myCat.makeSound();  // Output: Meow! (Cat's implementation)

        // Common interface, different behaviors
        Animal[] animals = {new Dog("Rex"), new Cat("Mittens"), new Dog("Max")};
        for (Animal animal : animals) {
            animal.makeSound();  // Runtime polymorphism
        }
    }
}