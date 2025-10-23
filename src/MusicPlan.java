public class MusicPlan extends Subscription implements Billable, TrialSupport{
    protected int trialDays = 14;

    public MusicPlan (String id, String title, float monthlyPrice, int startDate, boolean active, int trialDays){
        super(id, title, monthlyPrice, startDate, active, trialDays);
        this.trialDays = trialDays;
    }

    @Override
    public float montlyCharge(float forMonth) {
        if (startDate > 17){
            return 0;
        } else {
            return (31-14)*monthlyPrice;
        }

    }

    @Override
    public int trialDays() {
        return trialDays;
    }

    @Override
    public boolean isInTrial(int date){
        int finishTrialDays = startDate + 14;
        if (date > finishTrialDays) {
            return false;
        } else return true;
    }

    @Override
    public String toString() {
        return "MusicPlan{" +
                "trialDays=" + trialDays +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", monthlyPrice=" + monthlyPrice +
                ", startDate=" + startDate +
                ", active=" + active +
                ", price=" + price +
                '}';
    }
}
