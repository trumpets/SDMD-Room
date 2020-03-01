package gr.academic.city.sdmd.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by trumpets on 3/20/18.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
