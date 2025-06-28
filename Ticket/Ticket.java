package Ticket;
import User.User;

public class Ticket {
    
    private int id;
    private String CompId;
    private String title;
    private String description;
    private User userId;
    private String status;

    public Ticket(int id, String title, String description, User userId, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.status = status;
        setCompId(userId, id);
    }

    public int getId() {
        return id;
    }

    public String getCompId() {
        return CompId;
    }

    public void setCompId(User userId, int ticketId) {
        this.CompId = userId.getDepartmentId().getCode() + " - " + ticketId;
        }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }
}
