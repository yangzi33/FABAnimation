package com.example.databaseplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editUsername, editPassword;
    Button addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editUsername = (EditText) findViewById(R.id.editText);
        editPassword = (EditText) findViewById(R.id.editText2);
        addUser = (Button) findViewById(R.id.button);
        addData();
    }

    public void addData() {
        addUser.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editUsername.getText().toString(),
                                editPassword.getText().toString(), "100");
                        if (isInserted) {
                            Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Not inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
