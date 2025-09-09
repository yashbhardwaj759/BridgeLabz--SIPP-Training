import java.io.*;
import java.util.*;

// Employee class must implement Serializable
class Employee implements Serializable 
{
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) 
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() 
    {
        return "ID: " + id + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary;
    }
}

class Employee_Serialization 
{
    public static void main(String[] args) 
    {
        String fileName = "output.txt"; // As per your file naming preference

        // Create a few sample employees
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 60000));
        employees.add(new Employee(103, "Charlie", "Finance", 55000));

        // Serialize the list
        serializeEmployees(employees, fileName);

        // Deserialize and display
        List<Employee> loadedEmployees = deserializeEmployees(fileName);
        System.out.println("\n✅ Retrieved Employees:");
        for (Employee emp : loadedEmployees) 
        {
            System.out.println(emp);
        }
    }

    public static void serializeEmployees(List<Employee> employees, String fileName) 
    {
        ObjectOutputStream oos = null;

        try 
        {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(employees);
            System.out.println("✅ Employees serialized to " + fileName);
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ Serialization error: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (oos != null) oos.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing stream: " + e.getMessage());
            }
        }
    }

    public static List<Employee> deserializeEmployees(String fileName) 
    {
        ObjectInputStream ois = null;
        List<Employee> employees = new ArrayList<Employee>();

        try 
        {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            employees = (List<Employee>) ois.readObject();
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ Deserialization I/O error: " + e.getMessage());
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("⚠️ Class not found during deserialization: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (ois != null) ois.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing stream: " + e.getMessage());
            }
        }

        return employees;
    }
}