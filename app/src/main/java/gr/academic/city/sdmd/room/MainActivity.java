package gr.academic.city.sdmd.room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "users.db")
                .allowMainThreadQueries()
                .build();

        final EditText txtFullName = findViewById(R.id.txt_full_name);
        final TextView tvResult = findViewById(R.id.tv_results);

        Button btnAdd = findViewById(R.id.btn_add_new_user);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.userDao().insert(new User(txtFullName.getText().toString()));
            }
        });

        Button btnGetAll = findViewById(R.id.btn_get_all);
        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> allUsers = db.userDao().getAll();
                StringBuilder sbAllUsers = new StringBuilder();
                for (User user : allUsers) {
                    sbAllUsers.append(user.getFullName())
                            .append("\n");
                }

                tvResult.setText(sbAllUsers.toString());
            }
        });

        db.userDao().getAllLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                StringBuilder sbAllUsers = new StringBuilder();
                for (User user : users) {
                    sbAllUsers.append(user.getFullName())
                            .append("; ");
                }

                Log.d("RoomResults", sbAllUsers.toString());
            }
        });
    }
}
