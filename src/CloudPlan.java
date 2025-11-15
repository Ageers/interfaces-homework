class CloudPlan extends Subscription implements Billable {
    private int storageTb;
    private int baseTbPrice;
    private int extraTbPrice;

    public CloudPlan(String id, String title, float monthlyPrice, int startDate,
                     int storageTb, int baseTbPrice, int extraTbPrice) {
        super(id, title, monthlyPrice, startDate);
        this.storageTb = storageTb;
        this.baseTbPrice = baseTbPrice;
        this.extraTbPrice = extraTbPrice;
    }

    @Override
    public float monthlyCharge(int month) {
        if (!active) return 0f;

        int extraTb = Math.max(0, storageTb - 1); // Первый ТБ — базовый
        return baseTbPrice + extraTb * extraTbPrice;
    }

    public void setStorageTb(int storageTb) {
        if (storageTb < 1) {
            throw new IllegalArgumentException("Минимальный объём — 1 ТБ");
        }
        this.storageTb = storageTb;
    }
}
