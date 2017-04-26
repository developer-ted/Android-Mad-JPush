# Android-Mad-JPush

### # 1 JPUSH init

```
public class JPushTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new JPushManager()
                .setDebugMode(true)
                .init(this);
    }
}
```

### # 1-2 AndroidManifest.xml

```
...
<application
    android:name=".JPushTestApplication"
    ..>
```


### # 2 AndroidManifest.xml setting

```
<!-- Required -->
<permission
        android:name="Your package.permission.JPUSH_MESSAGE"
        android:protectionLevel="signature" />
<uses-permission android:name=""Your package.permission.JPUSH_MESSAGE" />

<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
...
<application>
      <activity
          android:name="cn.jpush.android.ui.PopWinActivity"
          android:exported="false"
          android:theme="@style/JPushDialogStyle" />
      <service
          android:name="cn.jpush.android.service.DownloadService"
          android:enabled="true"
          android:exported="false" />
      <service
          android:name="cn.jpush.android.service.DaemonService"
          android:enabled="true"
          android:exported="true">
          <intent-filter>
              <action android:name="cn.jpush.android.intent.DaemonService" />
              <category android:name="${applicationId}" />
          </intent-filter>
      </service>
      <activity
          android:name="cn.jpush.android.ui.PushActivity"
          android:configChanges="orientation|keyboardHidden"
          android:exported="false"
          android:theme="@android:style/Theme.NoTitleBar">
          <intent-filter>
              <action android:name="cn.jpush.android.ui.PushActivity" />

              <category android:name="android.intent.category.DEFAULT" />
              <category android:name="${applicationId}" />
          </intent-filter>
      </activity>
      <receiver
          android:name="cn.jpush.android.service.PushReceiver"
          android:enabled="true"
          android:exported="false">
          <intent-filter android:priority="1000">
              <action android:name="cn.jpush.android.intent.NOTIFICATION_RECEIVED_PROXY" />  
              <category android:name="${applicationId}" />
          </intent-filter>
          <intent-filter>
              <action android:name="android.intent.action.USER_PRESENT" />
              <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
          </intent-filter>
          <!-- Optional -->
          <intent-filter>
              <action android:name="android.intent.action.PACKAGE_ADDED" />
              <action android:name="android.intent.action.PACKAGE_REMOVED" />

              <data android:scheme="package" />
          </intent-filter>

      </receiver>
      <service
          android:name="cn.jpush.android.service.PushService"
          android:enabled="true"
          android:exported="false">
          <intent-filter>
              <action android:name="cn.jpush.android.intent.REGISTER" />
              <action android:name="cn.jpush.android.intent.REPORT" />
              <action android:name="cn.jpush.android.intent.PushService" />
              <action android:name="cn.jpush.android.intent.PUSH_TIME" />
          </intent-filter>
      </service>

      <receiver
          android:name="cn.jpush.android.service.AlarmReceiver"
          android:exported="false" />
          
      <meta-data
        android:name="JPUSH_CHANNEL"
        android:value="developer-default" />

      <meta-data
        android:name="JPUSH_APPKEY"
        android:value="@string/jpush_key_value" /> 
</application>
```
### # 3 string.xml
```
<string name="jpush_key_value">APP_KEY</string>
```
