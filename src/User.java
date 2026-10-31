import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class User {

    private final String id = UUID.randomUUID().toString();
    private String name;
    private String bio;
    private String profilePicture;
    private final List<Post> posts;
    private final List<User> friends;

    public User(String name, String bio, String profilePicture){
        this.name = name;
        this.bio = bio;
        this.profilePicture = profilePicture;
        posts = new ArrayList<>();
        friends = new ArrayList<>();
        validateName();
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getBio(){
        return this.bio;
    }

    public String getProfilePicture(){
        return this.profilePicture;
    }

    public void publishPost(String text, Visibility visibility){
        Post post = new Post(this, text, visibility);
        posts.add(post);
    }

    public void deletePost(Post post){
        posts.remove(post);
    }


    void addFriend(User other){
        if(other == null){
            throw new IllegalArgumentException("friend cannot be null");
        }
        if(other == this){
            throw new IllegalArgumentException("you cannot add yourself");
        }
        if(friends.contains(other)){
            throw new IllegalArgumentException("already friends");
        }

        friends.add(other);
    }

    void removeFriend(User other){
        friends.remove(other);
    }

    public boolean isFriendWith(User other){

        return friends.contains(other);
    }

    public List<Post> getPosts(){
        return Collections.unmodifiableList(this.posts);
    }


    public List<User> getFriends(){
        return Collections.unmodifiableList(this.friends);
    }

    private void validateName(){
        if(this.name == null || this.name.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }




}
