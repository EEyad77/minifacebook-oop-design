import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private final List<User> users;
    private final List<FriendRequest> requests;

    public SocialNetwork(){
        users = new ArrayList<>();
        requests = new ArrayList<>();
    }

    public User registerUser(String name, String bio, String profilePicture){

        User newUser = new User(name, bio, profilePicture);
        users.add(newUser);
        return newUser;


    }

    public FriendRequest sendFriendRequest(User sender, User receiver) {
        if (sender == receiver) {
            throw new IllegalArgumentException("You cannot send a request to yourself");
        }

        if(sender.isFriendWith(receiver)){
            throw new IllegalArgumentException("he is already your friend");
        }

        if(hasPendingRequestBetween(sender, receiver)){
            throw new IllegalArgumentException("a pending requests already exists between these users");
        }

        FriendRequest request = new FriendRequest(sender, receiver);
        requests.add(request);
        return request;
    }

    public void denyRequest(FriendRequest request, User actingUser){

        requireReceiver(request, actingUser);

        request.deny();
    }



    public void acceptRequest(FriendRequest request, User actingUser){

        requireReceiver(request, actingUser);

        request.accept();
        User a = request.getSender();
        User b = request.getReceiver();

        a.addFriend(b);
        b.addFriend(a);

    }


    public void unfriend(User actingUser, User other){
        if(!actingUser.isFriendWith(other)){
            throw new IllegalArgumentException("you are not friends");
        }

        actingUser.removeFriend(other);
        other.removeFriend(actingUser);
    }



    private boolean hasPendingRequestBetween(User a, User b){

        for(FriendRequest req : requests){

            boolean isPending = req.getStatus() == RequestStatus.PENDING;
            boolean aToB = req.getSender() == a && req.getReceiver() == b;
            boolean bToA = req.getSender() == b && req.getReceiver() == a;

            if(isPending && (aToB || bToA)){
                return true;
            }

        }

        return false;

    }

    private void requireReceiver(FriendRequest request, User actingUser){
        if(request.getReceiver() != actingUser){
            throw new IllegalArgumentException("only receiver can respond to this request");
        }
    }



}
