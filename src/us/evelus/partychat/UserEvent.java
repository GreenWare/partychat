package us.evelus.partychat;

/**
 * Property of Evelus
 * Created 4/6/14 by Sini
 */
public final class UserEvent {

    public static final int VISIBILITY_PUBLIC  = 0x1;
    public static final int VISIBILITY_FRIENDS = 0x2;
    public static final int VISIBILITY_PRIVATE = 0x4;

    private User owner;
    private GroupEvent event;
    private int visibility;

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public boolean isVisible(User user) {
        if(visibility == VISIBILITY_PUBLIC) {
            return true;
        }

        if(visibility == VISIBILITY_FRIENDS) {
            if(owner.friendsWith(user)) {
                return true;
            }
        }

        if(visibility == VISIBILITY_PRIVATE) {
            if(owner.equals(user)) {
                return true;
            }
        }

        return false;
    }
}
