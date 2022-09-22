public class Main {
    public static void main(String[] args) {


        MarketPrice price1 = new MarketPrice();
        MarketPrice price2 = new MarketPrice();
        MarketPrice price3 = new MarketPrice();

        Subscriber s1 = new Subscriber();

        price1.subscribe(s1);

        s1.subscribeMarket(price1);

        price2.subscribe(s1);

        s1.subscribeMarket(price2);

        price3.subscribe(s1);

        s1.subscribeMarket(price3);


        price1.onMessage("106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001");

        price2.onMessage("107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002");

        price3.onMessage("108, EUR/USD, 1.2000,1.3000,01-06-2020 12:01:01:003");

        s1.checkDuplicate();
}}

/*
Example REST endpoint using Spring-boot. marketPriceRepository class would be set up to capture and store data.

@PostMapping
public String add(@RequestBody Marketprice price) {
marketPriceRepository.addMarketPrice(price)
return ResponseEntity.status(HttpStatus.OK).body(price);
}

 */
