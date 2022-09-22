import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class MarketPrice{

    private List<Subscriber> subs = new ArrayList<>();



    private int Id;
    private String name;
    private Double bid;
    private Double ask;
    private String date;
    private Double askCommission;
    private Double BidCommission;


    //constructor


    public void onMessage (String message) throws IllegalArgumentException{
        String[] messageArr = message.split(",");
        this.Id = parseInt(messageArr[0]);
        this.name = messageArr[1];
        this.bid = parseDouble(messageArr[3]);
        this.ask = parseDouble(messageArr[2]);
        this.date = messageArr[4];
        this.BidCommission= (parseDouble(messageArr[2]) * 0.99);
        this.askCommission = (parseDouble(messageArr[3]) * 1.01);
        if (ask > bid ) {
            throw new IllegalArgumentException();
        }

    }

    public void subscribe(Subscriber sub) {
        subs.add(sub);
    }




    // getters/setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAskCommission() {
        return askCommission;
    }

    public void setAskCommission(Double askCommission) {
        this.askCommission = askCommission;
    }

    public Double getBidCommission() {
        return BidCommission;
    }

    public void setBidCommission(Double bidCommission) {
        BidCommission = bidCommission;
    }
}

