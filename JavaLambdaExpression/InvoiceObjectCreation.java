import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Invoice class representing a transaction invoice
class Invoice {
    private String invoiceId;
    private String transactionId;
    private String customerName;
    private double amount;
    private Date invoiceDate;
    private String description;
    
    // Constructor for basic invoice creation
    public Invoice(String transactionId) {
        this.invoiceId = "INV-" + System.currentTimeMillis();
        this.transactionId = transactionId;
        this.customerName = "Customer-" + transactionId.substring(transactionId.length() - 4);
        this.amount = Math.random() * 1000 + 50; // Random amount between 50-1050
        this.invoiceDate = new Date();
        this.description = "Transaction " + transactionId;
    }
    
    // Constructor with parameters
    public Invoice(String transactionId, String customerName, double amount, String description) {
        this.invoiceId = "INV-" + System.currentTimeMillis();
        this.transactionId = transactionId;
        this.customerName = customerName;
        this.amount = amount;
        this.invoiceDate = new Date();
        this.description = description;
    }
    
    // Getters
    public String getInvoiceId() { return invoiceId; }
    public String getTransactionId() { return transactionId; }
    public String getCustomerName() { return customerName; }
    public double getAmount() { return amount; }
    public Date getInvoiceDate() { return invoiceDate; }
    public String getDescription() { return description; }
    
    @Override
    public String toString() {
        return String.format("Invoice: %-12s | Transaction: %-8s | Customer: %-15s | Amount: $%-8.2f | %s",
                invoiceId, transactionId, customerName, amount, description);
    }
}

// Transaction class representing a transaction
class Transaction {
    private String transactionId;
    private String customerName;
    private double amount;
    private String description;
    
    public Transaction(String transactionId, String customerName, double amount, String description) {
        this.transactionId = transactionId;
        this.customerName = customerName;
        this.amount = amount;
        this.description = description;
    }
    
    // Getters
    public String getTransactionId() { return transactionId; }
    public String getCustomerName() { return customerName; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
}

// Invoice generator using constructor references
class InvoiceGenerator {
    private List<Transaction> transactions;
    
    public InvoiceGenerator() {
        transactions = new ArrayList<>();
        initializeTransactions();
    }
    
    private void initializeTransactions() {
        transactions.add(new Transaction("TXN001", "John Doe", 299.99, "Electronics Purchase"));
        transactions.add(new Transaction("TXN002", "Jane Smith", 149.50, "Book Purchase"));
        transactions.add(new Transaction("TXN003", "Bob Johnson", 599.00, "Furniture Purchase"));
        transactions.add(new Transaction("TXN004", "Alice Brown", 89.99, "Clothing Purchase"));
        transactions.add(new Transaction("TXN005", "Charlie Davis", 249.75, "Home Decor"));
    }
    
    // Method 1: Using constructor reference to create invoices from transaction IDs
    public List<Invoice> generateInvoicesFromIds(List<String> transactionIds) {
        return transactionIds.stream()
                           .map(Invoice::new) // Constructor reference
                           .collect(Collectors.toList());
    }
    
    // Method 2: Using constructor reference to create invoices from transactions
    public List<Invoice> generateInvoicesFromTransactions(List<Transaction> transactions) {
        return transactions.stream()
                           .map(t -> new Invoice(t.getTransactionId(), 
                                              t.getCustomerName(), 
                                              t.getAmount(), 
                                              t.getDescription()))
                           .collect(Collectors.toList());
    }
    
    // Method 3: Using Function with constructor reference
    public List<Invoice> generateInvoicesWithFunction(Function<String, Invoice> invoiceCreator, 
                                                     List<String> transactionIds) {
        return transactionIds.stream()
                           .map(invoiceCreator)
                           .collect(Collectors.toList());
    }
    
    // Method 4: Batch invoice generation
    public Map<String, Invoice> generateInvoiceMap(List<String> transactionIds) {
        return transactionIds.stream()
                           .collect(Collectors.toMap(
                                   id -> id,
                                   Invoice::new // Constructor reference
                           ));
    }
    
    // Method 5: Generate invoices with custom constructor
    public List<Invoice> generateCustomInvoices(List<String> transactionIds, 
                                               String customerName, 
                                               double baseAmount) {
        return transactionIds.stream()
                           .map(id -> new Invoice(id, customerName, baseAmount, "Bulk Order"))
                           .collect(Collectors.toList());
    }
    
    // Method 6: Using Supplier for invoice generation
    public List<Invoice> generateRandomInvoices(int count) {
        return java.util.stream.Stream.generate(() -> new Invoice("RAND" + System.nanoTime()))
                                     .limit(count)
                                     .collect(Collectors.toList());
    }
    
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}

public class InvoiceObjectCreation {
    public static void main(String[] args) {
        InvoiceGenerator generator = new InvoiceGenerator();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Invoice Object Creation System ===\n");
        
        // Demonstrate different ways to create invoices using constructor references
        
        // 1. Basic constructor reference from transaction IDs
        System.out.println("--- Constructor Reference from Transaction IDs ---");
        List<String> transactionIds = Arrays.asList("TXN100", "TXN101", "TXN102");
        List<Invoice> invoices = generator.generateInvoicesFromIds(transactionIds);
        invoices.forEach(System.out::println);
        
        // 2. Constructor reference from existing transactions
        System.out.println("\n--- Constructor Reference from Transactions ---");
        List<Transaction> transactions = generator.getTransactions();
        List<Invoice> transactionInvoices = generator.generateInvoicesFromTransactions(transactions);
        transactionInvoices.forEach(System.out::println);
        
        // 3. Using Function interface with constructor reference
        System.out.println("\n--- Function Interface with Constructor Reference ---");
        Function<String, Invoice> invoiceCreator = Invoice::new;
        List<String> newTransactionIds = Arrays.asList("TXN200", "TXN201", "TXN202");
        List<Invoice> functionInvoices = generator.generateInvoicesWithFunction(invoiceCreator, newTransactionIds);
        functionInvoices.forEach(System.out::println);
        
        // 4. Generate invoice map
        System.out.println("\n--- Invoice Map Generation ---");
        Map<String, Invoice> invoiceMap = generator.generateInvoiceMap(Arrays.asList("TXN300", "TXN301"));
        invoiceMap.forEach((id, invoice) -> 
            System.out.println("Map: " + id + " -> " + invoice));
        
        // 5. Generate random invoices
        System.out.println("\n--- Random Invoice Generation ---");
        List<Invoice> randomInvoices = generator.generateRandomInvoices(3);
        randomInvoices.forEach(System.out::println);
        
        // Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Generate invoices from transaction IDs");
            System.out.println("2. Generate invoices from transactions");
            System.out.println("3. Generate custom invoices");
            System.out.println("4. Generate random invoices");
            System.out.println("5. Show all transactions");
            System.out.println("6. Quit");
            
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.print("Enter transaction IDs (comma-separated): ");
                    String idsInput = scanner.nextLine();
                    List<String> ids = Arrays.asList(idsInput.split(","));
                    ids.replaceAll(String::trim);
                    
                    List<Invoice> newInvoices = generator.generateInvoicesFromIds(ids);
                    System.out.println("Generated Invoices:");
                    newInvoices.forEach(System.out::println);
                    break;
                    
                case "2":
                    System.out.println("Generating invoices from existing transactions:");
                    generator.getTransactions().forEach(System.out::println);
                    
                    List<Invoice> fromTrans = generator.generateInvoicesFromTransactions(generator.getTransactions());
                    System.out.println("\nGenerated Invoices:");
                    fromTrans.forEach(System.out::println);
                    break;
                    
                case "3":
                    System.out.print("Enter transaction IDs (comma-separated): ");
                    String customIds = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter base amount: ");
                    double baseAmount = Double.parseDouble(scanner.nextLine());
                    
                    List<String> customIdList = Arrays.asList(customIds.split(","));
                    customIdList.replaceAll(String::trim);
                    
                    List<Invoice> customInvoices = generator.generateCustomInvoices(customIdList, customerName, baseAmount);
                    System.out.println("Custom Invoices:");
                    customInvoices.forEach(System.out::println);
                    break;
                    
                case "4":
                    System.out.print("Enter number of random invoices: ");
                    int count = Integer.parseInt(scanner.nextLine());
                    List<Invoice> random = generator.generateRandomInvoices(count);
                    System.out.println("Random Invoices:");
                    random.forEach(System.out::println);
                    break;
                    
                case "5":
                    System.out.println("--- All Transactions ---");
                    generator.getTransactions().forEach(System.out::println);
                    break;
                    
                case "6":
                    scanner.close();
                    System.out.println("Invoice system shutting down...");
                    return;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}