import java.util.*;

class Insurance {
    String name;
    int policyNumber;

    Insurance(String name, int policyNumber) {
        this.name = name;
        this.policyNumber = policyNumber;
    }

    void display() {
        System.out.println("Policy Holder: " + name + ", Policy Number: " + policyNumber);
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        List<Insurance> list = new ArrayList<>();
        list.add(new Insurance("Ashu", 101));
        list.add(new Insurance("Simran", 102));
        for (Insurance i : list) {
            i.display();
        }
    }
}