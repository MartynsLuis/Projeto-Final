import java.util.ArrayList;

public class Aviso {
    private String texto;
    private String username;
    private long timestamp;
    private ArrayList<String> comments;

    /**
     * Constructor for objects of class Post.
     * 
     * @param author    The username of the author of this post.
     */
    public Aviso(String author, String texto)
    {
        timestamp = System.currentTimeMillis();
        username = author;
        this.texto = texto;
        comments = new ArrayList<>();
    }

    /**
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    public void addComment(String text)
    {
        comments.add(text);
    }

    /**
     * Return the time of creation of this post.
     * 
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }

    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public String toString(){
    
        String text = username + "\n" + timeString(timestamp);
        
        if(comments.isEmpty()) {
        return text + texto + "\n No comments.\n";
        }
        
        else {
        return text +  texto + "\n " + comments.size() +
        " comment(s). Click here to view.\n";
        }
    }
    
    public void display(){
        
        System.out.println(toString());
    }
    
    /**
     * Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     * 
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */
    
    private String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
