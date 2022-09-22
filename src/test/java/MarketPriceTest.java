import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MarketPriceTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

    }

    @Test
    @DisplayName("Test that market price is stored and commission is calculated")
    void onMessage() {
        MarketPrice price1 = new MarketPrice();
        price1.onMessage("107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002");
        assertEquals("107", String.valueOf(price1.getId()));
        assertEquals(" EUR/JPY", String.valueOf(price1.getName()));
        assertEquals("119.6", String.valueOf(price1.getAsk()));
        assertEquals("119.9", String.valueOf(price1.getBid()));
        assertEquals("01-06-2020 12:01:02:002", String.valueOf(price1.getDate()));
        assertEquals("121.099", String.valueOf(price1.getBidCommission()));
        assertEquals("118.404", String.valueOf(price1.getAskCommission()));

    }
    @Test
    @DisplayName("Test that market prices are posted to the console and outdated prices are removed")
    void duplicate() {
        MarketPrice price1 = new MarketPrice();
        MarketPrice price2 = new MarketPrice();
        Subscriber s1 = new Subscriber();
        price1.subscribe(s1);

        s1.subscribeMarket(price1);

        price2.subscribe(s1);

        s1.subscribeMarket(price2);
        price1.onMessage("107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002");
        price2.onMessage("108, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002");
        s1.checkDuplicate();

        assertEquals("updated price: 108  EUR/JPY 118.404 121.099 01-06-2020 12:01:02:002", outputStreamCaptor.toString().trim() );
    }

    @Test
    @DisplayName("Test exception is thrown if ask > bid")
    void error() {
        MarketPrice price1 = new MarketPrice();
        assertThrows(IllegalArgumentException.class, () -> price1.onMessage("107, EUR/JPY, 119.90,119.60,01-06-2020 12:01:02:002"));

    }
}