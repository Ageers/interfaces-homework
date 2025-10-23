import java.util.ArrayList;

public class VideoPlan extends Subscription implements Billable, Pausable, Sharable {
    protected int maxProfiles = 4;
    protected ArrayList<String> members = new ArrayList<>();
    protected int from;
    protected int to;
    protected int daysPause;

    public VideoPlan(String id, String title, float monthlyPrice, int startDate, boolean active, int price){
        super(id, title, monthlyPrice, startDate, active, price);
    }
    @Override
    public int pause(int from, int to) {
        this.from = from;
        return daysPause = to - from;
    }

    @Override
    public float montlyCharge(float forMonth) {
       return (float)((31 - daysPause)*((float)(monthlyPrice/31)));
    }

    @Override
    public boolean isPauseOn(int date) {
        if ((date > from) && (date < to)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int maxProfiles() {
        return maxProfiles;
    }

    @Override
    public void addMember(String userId) {
        if (members.size() > maxProfiles){
            System.out.println("Oooh is so many users, don't up");
        } else {
            members.add(userId);
        }
    }

    @Override
    public void removeMember(String userId) {
        members.remove(userId);
    }
}
