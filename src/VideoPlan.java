public class VideoPlan extends Subscription implements Billable, Pausable, Sharable {
    private int maxProfiles = 4;
    private String[] members = new String[maxProfiles];
   // private PauseWindow[] pauses = new Pauses[5];

    @Override
    public float montlyCharge(float forMonth) {
        return 0;
    }

    @Override
    public void pause(int from, int to) {

    }

    @Override
    public boolean isPauseOn(int date) {
        return false;
    }

    @Override
    public int maxProfiles() {
        return maxProfiles;
    }

    @Override
    public void addMember(String userId) {

    }

    @Override
    public void removeMember(String userId) {

    }
}
