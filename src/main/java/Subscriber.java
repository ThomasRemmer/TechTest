import java.util.ArrayList;
import java.util.List;

public class Subscriber {

    private List<MarketPrice> prices = new ArrayList<>();


    public void checkDuplicate() {
        for (int i = prices.size(); i-- > 0;) {
            for (MarketPrice price : prices) {
                if (prices.get(i).getName().equals(price.getName())  && prices.get(i).getId() != price.getId()){
                    prices.remove(price);
                    break;
                }

            }
        }
        update();
    }
    public void update() {


        for (MarketPrice price : prices) {

            System.out.println("updated price: " + price.getId() + " " + price.getName() + " " + price.getBidCommission() + " " + price.getAskCommission() + " " + price.getDate());
        }

    }
    public void subscribeMarket (MarketPrice pr) {
        prices.add(pr);
    }

}
