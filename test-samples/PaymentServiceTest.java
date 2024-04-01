import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {
    @Test
    public void testProcessPayment() {
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        when(paymentGateway.charge(100.0)).thenReturn(true);

        PaymentService paymentService = new PaymentService(paymentGateway);
        assertTrue(paymentService.processPayment(100.0));
        
        verify(paymentGateway).charge(100.0);
    }
}
