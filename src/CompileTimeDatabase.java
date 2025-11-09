class DatabaseConnection {
    private String host;
    private int port;
    private boolean ssl;

    DatabaseConnection(String host) {
//        this.host = host;
//        this.port = 3306;
//        this.ssl = false;
        this(host, 3306, false);
    }

    DatabaseConnection(String host, int port) {
        this(host, port, false);
    }

    DatabaseConnection(String host, int port, boolean ssl) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
    }

    void showInfo() {
        System.out.println("Connecting to " + host + ":" + port + " SSL=" + ssl);
    }
}

public class CompileTimeDatabase {
    public static void main(String[] args) {
        DatabaseConnection db1 = new DatabaseConnection("localhost");
        DatabaseConnection db2 = new DatabaseConnection("db.example.com", 5432);
        DatabaseConnection db3 = new DatabaseConnection("secure.example.com", 3306, true);

        db1.showInfo();
        db2.showInfo();
        db3.showInfo();
    }
}
