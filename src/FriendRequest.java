
public class FriendRequest {

    private final User sender;
    private final User receiver;
    private RequestStatus status;

    public FriendRequest(User sender, User receiver){
        this.sender = sender;
        this.receiver = receiver;
        status = RequestStatus.PENDING;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public RequestStatus getStatus() {
        return status;
    }

    void accept(){
        if(status != RequestStatus.PENDING){
            throw new IllegalStateException("there's no pending request to get accepted");
        }

        status = RequestStatus.ACCEPTED;
    }

    void deny(){
        if(status != RequestStatus.PENDING){
            throw new IllegalStateException("there's no request pending to be denied");
        }

        status = RequestStatus.DENIED;
    }




}
