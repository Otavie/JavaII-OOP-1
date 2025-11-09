abstract class Vehicle {
    abstract void start();
    abstract void stop();
    public void fuel() { System.out.println("Refueling vehicle..."); }
}

abstract class LandVehicle extends Vehicle {
    abstract void steer();
}

class Car extends LandVehicle {
    void start() { System.out.println("Car engine started"); }
    void stop() { System.out.println("Car stopped"); }
    void steer() { System.out.println("Steering car"); }
}

class Bike extends LandVehicle {
    void start() { System.out.println("Bike engine started"); }
    void stop() { System.out.println("Bike stopped"); }
    void steer() { System.out.println("Steering bike"); }
}

public class AbstractClassVehicle {
    public static void main(String[] args) {
        LandVehicle car = new Car();
        car.start();
        car.steer();
        car.fuel();
        car.stop();

        System.out.println("------");

        LandVehicle bike = new Bike();
        bike.start();
        bike.steer();
        bike.fuel();
        bike.stop();
    }
}
