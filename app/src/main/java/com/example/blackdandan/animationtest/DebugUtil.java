package com.example.blackdandan.animationtest;

import android.util.Log;

/**
 * description :
 * Created by blackdandan on 2017/11/14.
 */

public class DebugUtil {
    private DebugUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    public static boolean isDebug = true;//是否需要打印Log,可以再application中的oncreate里面初始化
    private static final String TAG = "way";

    //下面四个是默认的tag函数
    public static void i(String msg){
        if (isDebug){
            Log.i(TAG,"do===="+msg);
        }
    }
    public static void print(String msg){
        if (isDebug){
            Log.d(TAG,"do===="+msg);
        }
    }
    public static void e(String msg){
        if (isDebug){
            Log.e(TAG,"do===="+msg);
        }
    }
    public static void v(String msg){
        if (isDebug){
            Log.v(TAG,"do===="+msg);
        }
    }
}
