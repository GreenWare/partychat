package us.evelus.partychat;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Property of Evelus
 * Created 4/6/14 by Sini
 */
public final class User {

    private static final SecureRandom random = new SecureRandom();
    private static Map<Long, User> users = new HashMap<>();

    private String email;
    private String name;
    private List<User> friends;
    private List<UserEvent> events;
    private long uid;

    private User() {}

    public GroupEvent startEvent(String name, long length, TimeUnit unit) {
        return GroupEvent.create(name, length, unit, this);
    }

    public GroupEvent startChildEvent(String main, String name) {
        return null; // TODO
    }

    public String getName() {
        return name;
    }

    public Queue<Invite> invites() {
        return null; // TODO
    }

    public boolean friendsWith(User user) {
        return friends.contains(user);
    }

    public static User create(String email, String name) {
        User user = new User();
        user.email = email;
        user.name = name;
        user.uid = random.nextLong();
        users.put(user.uid, user);
        return user;
    }
}