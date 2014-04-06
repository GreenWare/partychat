package us.evelus.partychat;

import us.evelus.partychat.submission.TextualSubmission;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Property of Evelus
 * Created 4/6/14 by Sini
 */
public final class GroupEvent {

    private static final Map<String, GroupEvent> events = new HashMap<>();

    private GroupEvent() {}

    private String name;
    private List<Submission> submissions = new ArrayList<>();
    private List<GroupEvent> children = new ArrayList<>();
    private Set<User> participant = new HashSet<>();
    private GroupEvent parent;
    private User creator;

    public void submit(String text) {
        submit(new TextualSubmission(text));
    }

    public void submit(Submission submission) {
        submissions.add(submission);
    }

    public void visit(User user) {
        participant.add(user);
    }

    public GroupEvent createChildEvent(String child, User creator) {

        // Create the new group event
        GroupEvent event = create(name + ":" + child, 0L, null, creator); // FIX TIME LENGTH HERE TO INHERIT PROPERTIES
        event.parent = this;

        return event;
    }

    public void submitInvites() {}

    public static GroupEvent create(String name, long length, TimeUnit unit, User creator) {

        if(events.containsKey(name)) {
            throw new EventAlreadyExistsException();
        }

        // Create the new group event
        GroupEvent event = new GroupEvent();
        event.name = name;
        event.creator = creator;

        // Append the creator as a participant of the event
        event.visit(creator);

        return event;
    }

    public static GroupEvent find(String name) {
        return events.get(name);
    }
}
