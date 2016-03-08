package ray.com.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by wangchunlei on 16/3/2.
 */
public class BitmapUtils {
    public static Bitmap deco(String file) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        try {
            BitmapFactory.Options.class.getField("inNativeAlloc").setBoolean(options, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        if (file != null) {
            bitmap = BitmapFactory.decodeFile(file);
        }
        return bitmap;
    }
}
