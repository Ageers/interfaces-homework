public class Subscription {

    protected String id;
    protected String title;
    protected float monthlyPrice;
    protected int startDate;
    protected boolean active;

    public Subscription(String id, String title, float monthlyPrice, int startDate) {
        this.id = id;
        this.title = title;
        this.monthlyPrice = monthlyPrice;
        this.startDate = startDate;
        this.active = true;
    }

    public void activate() {
        this.active = true;
    }

    public void cancel() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public float price() {
        return monthlyPrice;
    }
}
