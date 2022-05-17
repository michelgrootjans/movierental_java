package movierental;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static movierental.CustomerBuilder.customer;

import org.junit.Test;

public class CustomerTest {

    @Test
    public void statementForRegularMovie() {
        Movie wind = new Movie("Gone with the Wind", Movie.REGULAR);
        Rental rental = new Rental(wind, 3);
        Customer customer = customer("Sallie", rental);
        String expected = "" +
                "Rental Record for Sallie\n" +
                "\tGone with the Wind\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        String statement = customer.statement();
        assertEquals(expected, statement);
    }

    @Test
    public void statementForNewReleaseMovie() {
        Movie starWars = new Movie("Star Wars", Movie.NEW_RELEASE);
        Rental rental = new Rental(starWars, 3);
        Customer customer = customer("Sallie", rental);
        String expected = "" +
                "Rental Record for Sallie\n" +
                "\tStar Wars\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementForChildrensMovie() {
        Movie madagascar = new Movie("Madagascar", Movie.CHILDRENS);
        Rental rental = new Rental(madagascar, 3);
        Customer customer = customer("Sallie", rental);
        String expected = "" +
                "Rental Record for Sallie\n" +
                "\tMadagascar\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementForManyMovies() {
        Rental rental1 = new Rental(new Movie("Madagascar", Movie.CHILDRENS), 6);
        Rental rental2 = new Rental(new Movie("Star Wars", Movie.NEW_RELEASE), 2);
        Rental rental3 = new Rental(new Movie("Gone with the Wind", Movie.REGULAR), 8);
        Customer customer = customer("David", rental1, rental2, rental3);
        String expected = "" +
                "Rental Record for David\n" +
                "\tMadagascar\t6.0\n" +
                "\tStar Wars\t6.0\n" +
                "\tGone with the Wind\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points";
        assertEquals(expected, customer.statement());
    }

}
