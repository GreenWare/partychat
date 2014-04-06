package us.evelus.partychat;

import java.util.concurrent.TimeUnit;

/**
 * Property of Evelus
 * Created by Hadyn
 */
public final class Application {

    public static void main(String[] args) {

        // Hello! Welcome to the Party Chat psuedocode application to highlight the direction we want to go in.

        // NOTE: This is an obvious dramatization, but the idea is the same

        // First, we need to create a new user to use our application.
        // Johnny heard about us from his friend and registered a new user.
        User johnny = User.create("john.doe@email.com", "Johnny");

        // Excellent! Now that we have a user, we can start moving into creating group events for Johnny to submit media to!

        // Johnny is hanging out at a party and wants to start taking photos of his crazy buddy, he starts a new group event.
        // He figures that the party will last about 5 hours, after those 5 hours are up the event will end and
        // everyone who was associated with the event will be able to access the event from their profile
        GroupEvent crazyParty = johnny.startEvent("Crazy party", 5L, TimeUnit.HOURS);

        // During the time Johnny is creating a new group event, a girl who is checking Johnny out overhears him
        // talking about Party Chat and creates a new user account.
        User jane = User.create("jane.bow@email.net", "Jane");

        // After the event is created, everyone close to Johnny is sent an invite to the group
        // If the user accepts the invite then they will be allowed to submit media to the group
        // which everyone involved will have access to
        crazyParty.submitInvites();

        // Jane checks her invites, and sees an invite to 'Crazy Party' from Johnny
        Invite crazyPartyInvite = jane.invites().poll();

        // She accepts the invite and is added to the group event as a participant
        crazyPartyInvite.accept();

        // Jane feels like expressing how awesome the party is going, she submits a text status reading 'This party is off the hook!'
        crazyParty.submit("This party is off the hook!!!");

        // Jane tells her friends about the application, and they all want to join in so they download it and register users
        User nancy = User.create("generic@email.org", "Nancy");
        User gwen = User.create("gwenny@email.edu", "Gwendolyn");

        // Jane wants to create a private group where she can see specifically only her friends photos, videos, text statuses
        // She creates a child group of the 'Crazy Party' called 'Girls Night Out'
        GroupEvent girlsNightOut = nancy.startChildEvent("Crazy party", "Girls Night Out");

        // All the girls start raving about a guy they just met, and of course take selfies
        girlsNightOut.submit("OMG, this guy was like totally checking me out!");
            girlsNightOut.submit("NO WAY GIRL, THATS CRAY CRAY!!!!!!!!!!!!!!!!!!!!!1");
                girlsNightOut.submit("<insert selfie photos here>");

        // Eventually they start getting tired
        girlsNightOut.submit("Cyaaaaa nerds, we outie");

        // The girls leave the party to head home, Johnny cleans up and heads to bed

        // Johnny wakes up and sees that 'Crazy party' was added to his profile, along with all the images, videos, statuses
        // from the night. He sees that the girls made a child event of the party and sees all their images, videos, statuses.

        // Now if Johnny wants to show his buddies all his awesome drunk poses he can do so, the event is forever
        // stored on his profile
    }

    private Application() {}
}
