package utils;

import android.util.Log;

/**
 * Created by Jason on 2017/2/4.
 */

public class LogUtil {
    public static final String LOGTAG="LoopViewPager";
    public static boolean debugEnabled;

    public LogUtil(){

    }

    private static String getDebugInfo(){
        Throwable stack=new Throwable().fillInStackTrace();
        StackTraceElement[] traceElements=stack.getStackTrace();
        int n=2;
        return traceElements[n].getClassName()+" "+
                traceElements[n].getMethodName()+ "()" + ":" +
                traceElements[n].getLineNumber() + " ";
    }

    private static String getLogInfoByArray(String[] infos){
        StringBuilder builder=new StringBuilder();
        for(String info:infos){
            builder.append(info);
            builder.append(" ");
        }
        return builder.toString();
    }

    public static void e(String str){
        Log.e(LOGTAG,str);
    }

    public static void d(String str){
        Log.d(LOGTAG,str);
    }

    public static void i(String str){
        Log.i(LOGTAG,str);
    }

    public static void v(String str){
        Log.v(LOGTAG,str);
    }

    public static void w(String str){
        Log.w(LOGTAG,str);
    }

    public static void i(String...str){
        if (debugEnabled) {
            Log.i(LOGTAG,getDebugInfo()+getLogInfoByArray(str));
        }
    }

    public static void e(String...str){
        if(debugEnabled){
            Log.e(LOGTAG,getDebugInfo()+getLogInfoByArray(str));
        }
    }

    public static void d(String...str){
        if(debugEnabled){
            Log.d(LOGTAG,getDebugInfo()+getLogInfoByArray(str));
        }
    }

    public static void v(String...str){
        if(debugEnabled){
            Log.v(LOGTAG,getDebugInfo()+getLogInfoByArray(str));
        }
    }

    public static void w(String...str){
        if (debugEnabled) {
            Log.v(LOGTAG,getDebugInfo()+getLogInfoByArray(str));
        }
    }

    public static void logException(Throwable throwable){
        if(debugEnabled){
            Log.e(LOGTAG,getDebugInfo(),throwable);
        }
    }
}
