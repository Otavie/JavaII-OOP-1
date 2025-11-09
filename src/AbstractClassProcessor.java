abstract class DataProcessor {
    // Template method - final to prevent overriding
    public final void process() {
        readData();
        processData();
        writeData();
    }

    abstract void readData();       // Subclass-specific
    abstract void processData();    // Subclass-specific
    abstract void writeData();      // Subclass-specific
}

// Subclass 1
class CSVProcessor extends DataProcessor {
    void readData() { System.out.println("Reading CSV file..."); }
    void processData() { System.out.println("Processing CSV data..."); }
    void writeData() { System.out.println("Writing CSV file..."); }
}

// Subclass 2
class JSONProcessor extends DataProcessor {
    void readData() { System.out.println("Reading JSON file..."); }
    void processData() { System.out.println("Processing JSON data..."); }
    void writeData() { System.out.println("Writing JSON file..."); }
}

public class AbstractClassProcessor {
    public static void main(String[] args) {
        DataProcessor processor;

        processor = new CSVProcessor();
        processor.process();  // CSV-specific steps called polymorphically

        processor = new JSONProcessor();
        processor.process();  // JSON-specific steps called polymorphically
    }
}
