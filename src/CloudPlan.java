public class CloudPlan extends Subscription implements Billable{
    protected int storageTb;
    protected int baseTbPrice;
    protected int extraTnPrice;


    public CloudPlan(String id, String title, float monthlyPrice, int startDate, boolean active, int price, int storageTb, int baseTbPrice, int extraTnPrice) {
        super(id, title, monthlyPrice, startDate, active, price);
        this.storageTb = storageTb;
        this.baseTbPrice = baseTbPrice;
        this.extraTnPrice = extraTnPrice;
    }

    public int getStorageTb() {
        return storageTb;
    }

    public void setStorageTb(int storageTb) {
        this.storageTb = storageTb;
    }

    public int getBaseTbPrice() {
        return baseTbPrice;
    }

    public void setBaseTbPrice(int baseTbPrice) {
        this.baseTbPrice = baseTbPrice;
    }

    public int getExtraTnPrice() {
        return extraTnPrice;
    }

    public void setExtraTnPrice(int extraTnPrice) {
        this.extraTnPrice = extraTnPrice;
    }



    @Override
    public float montlyCharge(float forMonth) {
        if (storageTb > baseTbPrice){
            float plusTb = storageTb - baseTbPrice;
            float payOfPlusTb = plusTb * extraTnPrice;
            monthlyPrice += payOfPlusTb;
          }
        return monthlyPrice;
     }

    @Override
    public String toString() {
        return "CloudPlan{" +
                "storageTb=" + storageTb +
                ", baseTbPrice=" + baseTbPrice +
                ", extraTnPrice=" + extraTnPrice +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", monthlyPrice=" + monthlyPrice +
                ", startDate=" + startDate +
                ", active=" + active +
                ", price=" + price +
                '}';
    }
}
