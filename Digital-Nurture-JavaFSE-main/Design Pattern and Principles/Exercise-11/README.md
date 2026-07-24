# Exercise 11: Implementing Dependency Injection

## Scenario
You are developing a customer management application where the service class depends on a repository class. Use Dependency Injection to manage these dependencies.

## Implementation Details
1. **CustomerRepository**: Interface with `findCustomerById` method.
2. **CustomerRepositoryImpl**: Concrete class implementing the repository interface.
3. **CustomerService**: Service class that depends on `CustomerRepository`.
4. **Dependency Injection**: Used Constructor Injection to inject the repository into the service.
5. **TestDependencyInjection**: Main class to demonstrate the pattern.

## Output
When running `TestDependencyInjection.java`, it prints out the customer details fetched through the injected repository implementation.
