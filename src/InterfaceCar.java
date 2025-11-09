interface Engine {
    void startEngine();
}

interface GPS {
    void enableGPS();
}

class SmartCar implements Engine, GPS {
    public void startEngine() {
        System.out.println("Engine started");
    }

    public void enableGPS() {
        System.out.println("GPS enabled");
    }
}

public class InterfaceCar {
    public static void main(String[] args) {
        SmartCar car = new SmartCar();
        car.startEngine();
        car.enableGPS();
    }
}
