public class TestDependencyInjection {
    public static void main(String[] args) {
        System.out.println("--- Dependency Injection Pattern Test ---");
        
        // 1. Create the dependency
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        // 2. Inject the dependency into the service
        CustomerService service = new CustomerService(repository);
        
        // 3. Use the service
        service.printCustomerDetails("C1001");
        
        System.out.println("-----------------------------------------");
    }
}
