public class MusicPlan extends Subscription implements Billable, TrialSupport{
    private int trialDays = 14;

    @Override
    public float montlyCharge(float forMonth) {
        return 0;
    }

    @Override
    public int trialDays() {
        return 0;
    }

    @Override
    public boolean isInTrial(int date){
        return true;
    }
}
