package edu.cn.bookadminister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComplaintActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt_user_dial;
    private Button bt_user_message;
    private Button bt_user_online;
    private String phoneNumber="13946835513";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        //电话投诉
        bt_user_dial=findViewById(R.id.bt_user_dial);
        bt_user_dial.setOnClickListener(this);
        //短信投诉
        bt_user_message=findViewById(R.id.bt_user_message);
        bt_user_message.setOnClickListener(this);
        //在线投诉
        bt_user_online=findViewById(R.id.bt_user_online);
        bt_user_online.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_user_dial){
           // ComplaintActivity.this.finish();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            Uri uri = Uri.parse("tel:" + phoneNumber);
            intent.setData(uri);
            startActivity(intent);
        }else if (v.getId() == R.id.bt_user_message){
           // ComplaintActivity.this.finish();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SENDTO);
            Uri uri = Uri.parse("smsto:" + phoneNumber);
            intent.setData(uri);
            startActivity(intent);
        }
        else if(v.getId()==R.id.bt_user_online){
            ComplaintActivity.this.finish();
            Intent intent = new Intent(ComplaintActivity.this, OnlineComplaintActivity.class);
            startActivityForResult(intent, 3);
        }
    }

}