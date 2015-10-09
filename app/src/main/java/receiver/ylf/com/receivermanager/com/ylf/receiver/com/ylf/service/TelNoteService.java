package receiver.ylf.com.receivermanager.com.ylf.receiver.com.ylf.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import java.io.InputStream;
import java.net.URI;

import receiver.ylf.com.receivermanager.R;

/**
 * Created by Administrator on 2015/10/9.
 *
 *   获取手机通讯录
 */
public class TelNoteService extends Service {
    private static final String[] PHONES_PROJECTION = new String[] {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.Contacts.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("111", "获取手机通讯录信息");
        getPhoneContacts();
        getSIMContacts();
    }

    /**
     *  获取手机通讯录
     */
    private  void getPhoneContacts(){
        ContentResolver resolver=getContentResolver();
       Cursor cursor= resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                //获取手机号
                String phoneNumber=cursor.getString(0);
                if(TextUtils.isEmpty(phoneNumber))
                    continue;
                //获取联系人姓名
                 String contactName=cursor.getString(1);
                //获取联系人id
                long contactid=cursor.getLong(2);
                //得到联系人头像Bitamp
                Bitmap contactPhoto=null;
                //photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
                if (contactid>0){
                    Uri uri= ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactid);
                    InputStream is=ContactsContract.Contacts.openContactPhotoInputStream(resolver, uri);
                    contactPhoto= BitmapFactory.decodeStream(is);
                }else {
                    contactPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
                }
              //数据放入集合
                Log.i("111",phoneNumber+"   "+contactName);
            }
            cursor.close();
        }
    }

    /**得到手机SIM卡联系人人信息**/
    private void getSIMContacts() {
        ContentResolver resolver = getContentResolver();
        // 获取Sims卡联系人
        Uri uri = Uri.parse("content://icc/adn");
        Cursor phoneCursor = resolver.query(uri, PHONES_PROJECTION, null, null,
                null);

        if (phoneCursor != null) {
            while (phoneCursor.moveToNext()) {

                // 得到手机号码
                String phoneNumber = phoneCursor.getString(0);
                // 当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;
                // 得到联系人名称
                String contactName = phoneCursor
                        .getString(1);

                //Sim卡中没有联系人头像
                 //数据放入集合
                Log.i("111",phoneNumber+"   "+contactName);
            }

            phoneCursor.close();
        }
    }
}
