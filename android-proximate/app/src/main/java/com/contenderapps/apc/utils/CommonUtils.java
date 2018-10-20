package com.contenderapps.apc.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.provider.Settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class CommonUtils {

    private static final String TAG = CommonUtils.class.getSimpleName();

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

//    public static ProgressDialog showLoadingDialog(Context context) {
//        ProgressDialog progressDialog = new ProgressDialog(context);
//        progressDialog.show();
//        if (progressDialog.getWindow() != null) {
//            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        progressDialog.setContentView(R.layout.progress_dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setCancelable(true);
//        progressDialog.setCanceledOnTouchOutside(false);
//        return progressDialog;
//    }

    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String loadJSONFromAsset(Context context, String jsonFileName)
            throws IOException {

        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, "UTF-8");
    }

    /**
     * Checks whether a specific application is installed by checking in package manager for the
     * package name.
     * @param context   context object
     * @param packageName package name of the application
     * @return true if the app is installed, false otherwise
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        boolean result = true;
        try {
            packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            result = false;
        }
        return result;
    }


    /**
     * Returns the icon of an external application, given that that application is installed
     * on the system.
     * @param context context
     * @param packageName full package name of the app
     * @return the icon drawable
     */
    public static Drawable getExternalApplicationIcon(Context context, String packageName) {
        Drawable icon = null;
        try {
            icon = context.getPackageManager().getApplicationIcon(packageName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return icon;
    }

    public static String getExternalApplicationName(Context context, String packageName) {
        String text = null;
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            text = context.getPackageManager().getApplicationLabel(appInfo).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }




//    public static String getTimeStamp() {
//        return new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(new Date());
//    }
}
