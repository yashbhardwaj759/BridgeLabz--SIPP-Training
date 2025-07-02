p// Superclass: Person
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

// Interface: Worker
interface Worker {
    void performDuties();
}

// Subclass: Chef (inherits Person, implements Worker)
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Role: Chef");
        displayInfo();
        System.out.println("Duties: Prepares meals and manages kitchen.");
        System.out.println();
    }
}

// Subclass: Waiter (inherits Person, implements Worker)
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Role: Waiter");
        displayInfo();
        System.out.println("Duties: Serves food and attends to customers.");
        System.out.println();
    }
}

// Main class to test
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Ramesh", 101);
        Waiter waiter = new Waiter("Suresh", 102);

        chef.performDuties();
        waiter.performDuties();
    }
}
