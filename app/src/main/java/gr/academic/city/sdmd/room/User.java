package gr.academic.city.sdmd.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by trumpets on 3/20/18.
 */
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String fullName;

    public User() {
    }

    public User(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
