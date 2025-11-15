class MusicPlan extends Subscription implements Billable, TrialSupport {
    private int trialDays = 14;

    public MusicPlan(String id, String title, float monthlyPrice, int startDate) {
        super(id, title, monthlyPrice, startDate);
    }

    @Override
    public float monthlyCharge(int month) {
        if (!active) return 0f;
        int startOfMonth = (month - 1) * 30 + 1;
        int endOfMonth = month * 30;

        if (isInTrial(startOfMonth) || isInTrial(endOfMonth)) {
            return 0f;
        }
        return monthlyPrice;
    }

    @Override
    public int trialDays() {
        return trialDays;
    }

    @Override
    public boolean isInTrial(int date) {
        return date < startDate + trialDays;
    }
}
