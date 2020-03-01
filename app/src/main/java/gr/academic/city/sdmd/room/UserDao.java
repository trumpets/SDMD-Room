package gr.academic.city.sdmd.room;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by trumpets on 3/20/18.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllLiveData();

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insert(User user);
}
