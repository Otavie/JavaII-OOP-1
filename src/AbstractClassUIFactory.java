abstract class UIComponent {
    protected String id;

    UIComponent(String id) {
        this.id = id;
    }

    public void focus() {
        System.out.println(id + " is focused (default behavior)");
    }

    public abstract void render();  // Must be implemented
    public abstract void click();   // Must be implemented
}

class Button extends UIComponent {
    Button(String id) { super(id); }

    public void render() { System.out.println("Rendering Button: " + id); }
    public void click() { System.out.println("Button " + id + " clicked!"); }
}

class TextField extends UIComponent {
    TextField(String id) { super(id); }

    public void render() { System.out.println("Rendering TextField: " + id); }
    public void click() { System.out.println("TextField " + id + " selected!"); }
}

public class AbstractClassUIFactory {
    public static void main(String[] args) {
        UIComponent button = new Button("btnSubmit");
        UIComponent textField = new TextField("txtName");

        button.render();
        button.focus();
        button.click();

        textField.render();
        textField.focus();
        textField.click();
    }
}
