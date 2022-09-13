package edu.cn.bookadminister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_createe;
    private Button bt_updatee;
    private Button bt_deletee;
    private Button bt_read;
    private Button bt_backlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        bt_createe = findViewById(R.id.bt_manager_createe);
        bt_createe.setOnClickListener(this);

        bt_updatee = findViewById(R.id.bt_manager_updatee);
        bt_updatee.setOnClickListener(this);

        bt_deletee = findViewById(R.id.bt_manager_deletee);
        bt_deletee.setOnClickListener(this);

        bt_read = findViewById(R.id.bt_manager_read);
        bt_read.setOnClickListener(this);

        bt_backlogin=findViewById(R.id.bt_manager_backlogin);
        bt_backlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_manager_createe){
            // 准备跳到下一个活动页面，studentList
            Intent intent = new Intent(ManagerActivity.this, AddPacksActivity.class);
            startActivityForResult(intent, 0);
        }else if (v.getId() == R.id.bt_manager_updatee){
            // 准备跳到下一个活动页面，studentList
            Intent intent = new Intent(ManagerActivity.this, SearchPacksActivity.class);
            startActivityForResult(intent, 1);
        }else if (v.getId() == R.id.bt_manager_deletee){
            // 准备跳到下一个活动页面，studentList
            Intent intent = new Intent(ManagerActivity.this, DeletePacksActivity.class);
            startActivityForResult(intent, 2);
        }else if (v.getId() == R.id.bt_manager_read){
            // 准备跳到下一个活动页面，studentList
            Intent intent = new Intent(ManagerActivity.this, QueryPacksActivity.class);
            startActivityForResult(intent, 3);
        }else if(v.getId()==R.id.bt_manager_backlogin){
            // 准备跳到下一个活动页面，studentList
            ManagerActivity.this.finish();
            Intent intent = new Intent(ManagerActivity.this, LoginActivity.class);
            startActivityForResult(intent, 3);
        }
    }
}

