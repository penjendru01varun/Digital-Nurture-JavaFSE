public class CustomerService {
    private final CustomerRepository customerRepository;

    // Dependency Injection via constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomerDetails(String id) {
        String customerDetails = customerRepository.findCustomerById(id);
        System.out.println("CustomerService retrieving details...");
        System.out.println(customerDetails);
    }
}
