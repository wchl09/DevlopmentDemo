package ray.com.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Looper;

/**
 * Created by wangchunlei on 15/12/21.
 */
public class DBUtils {
    MyDBHelper dbHelper;

    public void inseret(Context context) {
        SQLiteDatabase db = new MyDBHelper(context).getWritableDatabase();
        db.beginTransaction();
        SQLiteStatement statement = db.compileStatement("");
        statement.bindString(1,"");
        statement.executeInsert();
        db.setTransactionSuccessful();
        db.endTransaction();
        new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.loop();
            }
        }.start();
    }
}