import java.time.LocalDateTime;

public class Post {

    private final User author;
    private String text;
    private final LocalDateTime createdAt;
    private Visibility visibility;

    public Post(User author, String text, Visibility visibility){
        this.author = author;
        this.text = text;
        this.createdAt = LocalDateTime.now();
        this.visibility = visibility;
        validateText(this.text);
        validateVisibility(this.visibility);
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void edit(String newText){
        validateText(newText);
        this.text = newText;
    }

    public void changeVisibility(Visibility newVisibility){

        this.visibility = newVisibility;
    }

    private void validateText(String value){
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException("Post text cannot be empty");
        }
    }

    private void validateVisibility(Visibility visibility){
        if(visibility == null){
            throw new IllegalStateException("the visibility of the post cannot be null");
        }
    }


}
