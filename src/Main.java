public class Main {
    public static void main(String[] args){

        SocialNetwork network = new SocialNetwork();

        User ali = network.registerUser("Ali", "a boy", "dddy777");
        User sara = network.registerUser("Sara", "a girl", "iiir666");

        FriendRequest request = network.sendFriendRequest(ali, sara);

//        try{
//            network.sendFriendRequest(ali, sara);
//        }catch (IllegalArgumentException e){
//            System.out.println("Rejected: " + e.getMessage());
//        }

        network.denyRequest(request, sara);
        network.sendFriendRequest(ali, sara);
        network.acceptRequest(request,sara);

        System.out.println(ali.isFriendWith(sara));
        System.out.println(sara.isFriendWith(ali));


    }
}
