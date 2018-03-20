package gr.academic.city.sdmd.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

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
