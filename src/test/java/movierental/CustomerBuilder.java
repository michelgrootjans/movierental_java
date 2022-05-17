package movierental;

public class CustomerBuilder {

    static Customer customer(String name, Rental... rentals) {
        Customer result = new Customer(name);
        for (Rental rental : rentals) {
            result.addRental(rental);
        }
        return result;
    }
}
