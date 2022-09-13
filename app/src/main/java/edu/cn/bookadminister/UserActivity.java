package edu.cn.bookadminister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_user_search;
    private Button bt_user_deletee;
    private Button bt_user_sendpack;
    private Button bt_backlogin;

    private IntentFilter intentFilter;
    private NetworkChangeRexeiver networkChangeRexeiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        intentFilter=new IntentFilter();
        //"android.net.conn.CONNECTIVITY_CHANGE":当网络变化时，系统发出的值为“android.net.conn.CONNECTIVITY_CHANGE”的广播
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeRexeiver=new NetworkChangeRexeiver();
        registerReceiver(networkChangeRexeiver,intentFilter);
        
        //查快递
        bt_user_search=findViewById(R.id.bt_user_serach);
        bt_user_search.setOnClickListener(this);
        //取快递
        bt_user_deletee=findViewById(R.id.bt_user_deletee);
        bt_user_deletee.setOnClickListener(this);
        //寄快递
        bt_user_sendpack=findViewById(R.id.bt_user_sendpack);
        bt_user_sendpack.setOnClickListener(this);
        //返回登录界面
        bt_backlogin=findViewById(R.id.bt_user_backlogin);
        bt_backlogin.setOnClickListener(this);
        //投诉热线
        bt_backlogin=findViewById(R.id.bt_user_complaint);
        bt_backlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_user_serach){
            // 准备跳到下一个活动页面
            Intent intent = new Intent(UserActivity.this, SearchPacksActivity.class);
            startActivityForResult(intent, 0);
        }else if (v.getId() == R.id.bt_user_deletee){
            // 准备跳到下一个活动页面
            Intent intent = new Intent(UserActivity.this, UserdeleteActivity.class);
            startActivityForResult(intent, 1);
        }else if (v.getId() == R.id.bt_user_sendpack){
            // 准备跳到下一个活动页面
            Intent intent = new Intent(UserActivity.this, UseraddActivity.class);
            startActivityForResult(intent, 2);
        }else if(v.getId()==R.id.bt_user_backlogin){
            // 准备跳到下一个活动页面
            UserActivity.this.finish();
            Intent intent = new Intent(UserActivity.this, LoginActivity.class);
            startActivityForResult(intent, 3);
        }
        else if(v.getId()==R.id.bt_user_complaint){
            // 准备跳到下一个活动页面
            Intent intent = new Intent(UserActivity.this, ComplaintActivity.class);
            startActivityForResult(intent, 4);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
    }


    class NetworkChangeRexeiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //Connect
            ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null&&networkInfo.isAvailable()){
                Toast.makeText(context,"网络可用 网络类型："+networkInfo.getTypeName(),Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context,"网络不可用",Toast.LENGTH_LONG).show();
            }
        }
    }
}

