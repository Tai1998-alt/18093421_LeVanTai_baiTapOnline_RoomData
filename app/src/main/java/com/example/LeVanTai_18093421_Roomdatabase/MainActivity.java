package com.example.LeVanTai_18093421_Roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editUserName,editAddress;
    Button btnSave;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<User> listUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUserName = findViewById(R.id.editUserName);
        editAddress = findViewById(R.id.editAddress);
        btnSave = findViewById(R.id.btnSave);
        recyclerView = findViewById(R.id.recyclerView);
        listUser = new ArrayList<>();
        myAdapter = new MyAdapter();
        myAdapter.setData(listUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }
    public void addUser()
    {
        String userName = editUserName.getText().toString().trim();
        String address = editAddress.getText().toString().trim();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(address)){return;}
        User user = new User(userName,address);
        DatabaseUser.getInstance(this).daoUser().InsertUser(user);
        Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();

        listUser = DatabaseUser.getInstance(this).daoUser().getList();
        myAdapter.setData(listUser);
        editUserName.setText("");
        editAddress.setText("");
    }
}