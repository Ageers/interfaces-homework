public class CloudPlan extends Subscription implements Billable{
    int storageTb;
    int baseTbPrice;
    int extraTnPrice;

    @Override
    public float montlyCharge(float forMonth) {
        return 0;
    }
}
