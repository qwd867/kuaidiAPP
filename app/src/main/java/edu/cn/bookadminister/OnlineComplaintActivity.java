package edu.cn.bookadminister;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import edu.cn.bookadminister.databinding.ActivityOnlineComplaintBinding;

public class OnlineComplaintActivity extends AppCompatActivity {
    private Button bt_complaint_submit;
    private EditText et_kuaidinumber,et_complaintreason;
    private String kuaidinumber,complaintreason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_complaint);
        init();
    }

    private void init() {
        bt_complaint_submit = (Button)findViewById(R.id.bt_complaint_submit);
        et_kuaidinumber = (EditText) findViewById(R.id.et_kuaidinumber);
        et_complaintreason = (EditText) findViewById(R.id.et_complaintreason);
        
        //设置按钮监听
        bt_complaint_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditString();//以string类型获取Edit框里的内容
                if (v.getId() == R.id.bt_complaint_submit) {
                    // 准备跳到下一个活动页面，studentList

                    if (TextUtils.isEmpty(kuaidinumber)) {
                        Toast.makeText(OnlineComplaintActivity.this, "请输入快递单号", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (TextUtils.isEmpty(complaintreason)) {
                        Toast.makeText(OnlineComplaintActivity.this, "请输入投诉原因", Toast.LENGTH_SHORT).show();
                        return;
                    }
                        OnlineComplaintActivity.this.finish();
                        Intent intent = new Intent(OnlineComplaintActivity.this, ComplaintActivity.class);
                        startActivityForResult(intent, 0);
                        Toast.makeText(OnlineComplaintActivity.this, "投诉成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getEditString(){
        kuaidinumber = et_kuaidinumber.getText().toString().trim();
        complaintreason = et_complaintreason.getText().toString().trim();
    }
}