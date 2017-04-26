package com.mad.jpushtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.mad.jpush.JPushManager;
import com.mad.jpush.JPushUtils;

public class MainActivity extends AppCompatActivity {

//    private String EXTRA_PATH = "com.jpush.examples.Path";
//    private String SAMPLE_CATEGORY = "com.jpush.examples.SAMPLE_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerMessageReceiver();

        TextView text = (TextView) findViewById(R.id.text);
        if (JPushManager.getRegisterID(this) == null)
            text.setText("Hello Morse\n잠시 기다려주세요");
        else
            text.setText(String.format("Hello Morse\n ID : %s", JPushManager.getRegisterID(this)));
//        text
    }

    // =============================================================================
    // JPush
    // =============================================================================
    @Override
    protected void onDestroy() {
        unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }

    //for receive customer msg from jpush server
    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.mad.jpushtest.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("", "######## onReceive");
            if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                String message = intent.getStringExtra(KEY_MESSAGE);
                String extras = intent.getStringExtra(KEY_EXTRAS);
                StringBuilder showMsg = new StringBuilder();
                showMsg.append(KEY_MESSAGE + " : ").append(message).append("\n");
                if (!JPushUtils.isEmpty(extras)) {
                    showMsg.append(KEY_EXTRAS + " : ").append(extras).append("\n");
                }
            }
        }
    }
}
