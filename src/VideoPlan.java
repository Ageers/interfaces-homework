public class VideoPlan extends Subscription implements Billable, Pausable, Sharable {
    private int maxProfiles = 4;
    private String[] members = new String[4];
    private PauseWindow[] pauses = new PauseWindow[5];
    private int pauseCount = 0;
    private int memberCount = 0;

    public VideoPlan(String id, String title, float monthlyPrice, int startDate) {
        super(id, title, monthlyPrice, startDate);
    }

    @Override
    public float monthlyCharge(int month) {
        if (!active) return 0f;

        int startOfMonth = (month - 1) * 30 + 1;
        int endOfMonth = month * 30;

        int activeDays = 0;
        for (int day = startOfMonth; day <= endOfMonth; day++) {
            if (!isPausedOn(day)) {
                activeDays++;
            }
        }

        return (activeDays / 30.0f) * monthlyPrice;
    }
    @Override
    public void pause(int from, int to) {
        if (pauseCount >= pauses.length) {
            throw new IllegalStateException("Превышено максимальное количество пауз (5)");
        }
        if (from > to) {
            throw new IllegalArgumentException("Начальная дата паузы не может быть позже конечной");
        }
        pauses[pauseCount++] = new PauseWindow(from, to);
    }

    @Override
    public boolean isPausedOn(int date) {
        for (int i = 0; i < pauseCount; i++) {
            PauseWindow p = pauses[i];
            if (p != null && date >= p.from && date <= p.to) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int maxProfiles() {
        return maxProfiles;
    }

    @Override
    public void addMember(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID пользователя не может быть пустым");
        }
        if (memberCount >= maxProfiles) {
            throw new IllegalStateException("Достигнут лимит участников: " + maxProfiles);
        }
        if (containsMember(userId)) {
            throw new IllegalArgumentException("Пользователь уже добавлен");
        }
        members[memberCount++] = userId;
    }

    @Override
    public void removeMember(String userId) {
        for (int i = 0; i < memberCount; i++) {
            if (userId.equals(members[i])) {
                members[i] = members[--memberCount];
                members[memberCount] = null;
                return;
            }
        }
        throw new IllegalArgumentException("Пользователь не найден");
    }

    public int getMemberCount() {
        return memberCount;
    }

    private boolean containsMember(String userId) {
        for (int i = 0; i < memberCount; i++) {
            if (userId.equals(members[i])) return true;
        }
        return false;
    }
}