package com.example.LeVanTai_18093421_Roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button btnSave,btnCancel;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<User> listUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        recyclerView = findViewById(R.id.recyclerView);
        DatabaseUser data = DatabaseUser.getInstance(this);
        listUser = new ArrayList<>();
        listUser = DatabaseUser.getInstance(this).daoUser().getList();
        myAdapter = new MyAdapter(new MyAdapter.DeleteAndUpdate() {
            @Override
            public void DeleteUser(User user) {
               new AlertDialog.Builder(MainActivity.this)
                       .setTitle("Confirm Delete User!")
                       .setMessage("Are you delete?")
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               delete(user);
                               myAdapter.setData(data.daoUser().getList());
                           }
                       }).setNegativeButton("No", null).show();
            }

            @Override
            public void UpdateUser(User user) {
                update(user);
                myAdapter.setData(data.daoUser().getList());
            }
        });
        myAdapter.setData(listUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void addUser()
    {
        String userName = editName.getText().toString().trim();
        if (TextUtils.isEmpty(userName)){return;}
        User user = new User(userName,R.drawable.edit,R.drawable.delete);
        DatabaseUser.getInstance(this).daoUser().InsertUser(user);
        Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
        listUser = DatabaseUser.getInstance(this).daoUser().getList();
        myAdapter.setData(listUser);
        editName.setText("");
    }
    public  void delete(User user)
    {
        DatabaseUser.getInstance(this).daoUser().DeleteUser(user);
    }
    public  void update(User user)
    {
        if (TextUtils.isEmpty(editName.getText())){
            //Toast.makeText(MainActivity.this,"Bạn cần điền địa điểm mới để sửa", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Thông Báo!")
                    .setMessage("Bạn cần điền thông tin vào trường để sửa.")
                    .setNegativeButton("End",null).show();
        } else
        {
            user.setName(editName.getText().toString());
            DatabaseUser.getInstance(this).daoUser().UpdateUser(user);
            editName.setText("");
        }
    }
}