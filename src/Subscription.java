public class Subscription {

    protected String id;
    protected String title;
    protected float monthlyPrice;
    protected int startDate;
    protected boolean active;
    protected int price;


    public Subscription(String id, String title, float monthlyPrice, int startDate, boolean active, int price) {
        this.id = id;
        this.title = title;
        this.monthlyPrice = monthlyPrice;
        this.startDate = startDate;
        this.active = active;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(float monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private boolean activate(){
        return active = true;
    }

    private boolean cancel(){
        return active = false;
    }

    public void isActive() {
        System.out.println(" Subscription " + id + " activity is " + active + " !");
    }

    public void price(){
        System.out.println(" Monthly price is " + monthlyPrice);

    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", monthlyPrice=" + monthlyPrice +
                ", startDate=" + startDate +
                ", active=" + active +
                ", price=" + price +
                '}';
    }
}
