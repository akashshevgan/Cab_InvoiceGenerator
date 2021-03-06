import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenDistanceOrTime_ShouldReturnMinFare(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(5,fare,0.0);
    }

    @Test
    void givenMltipleRidesShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        Assertions.assertEquals(30, invoiceGenerator.calculateFareForMultipleRides(rides));
    }
    @Test
    public void givenMltipleRidesShouldReturnTotalFarew() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary invoiceSummaryResult = invoiceGenerator.calculateFare(rides);
        InvoiceSummary invoiceSummary = new InvoiceSummary(2, 30);
        Assertions.assertEquals(invoiceSummary, invoiceSummaryResult);
    }

    @Test
    public void givenUserIdAndRidesShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String userId = "Id123";
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(1,2)
        };
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary invoiceSummaryResult = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary invoiceSummary = new InvoiceSummary(3,42.0);
        Assertions.assertEquals(invoiceSummary, invoiceSummaryResult);
    }
}
