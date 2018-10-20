/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.contenderapps.apc.utils;

import android.content.Context;
import android.content.res.Resources;

import com.contenderapps.apc.R;

public final class ViewUtils {

    private ViewUtils() {
        // This utility class is not publicly instantiable
    }

    public static float pxToDp(float px) {
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    public static int dpToPx(float dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

//    public static void changeIconDrawableToGray(Context context, Drawable drawable) {
//        if (drawable != null) {
//            drawable.mutate();
//            drawable.setColorFilter(ContextCompat
//                    .getColor(context, R.color.dark_gray), PorterDuff.Mode.SRC_ATOP);
//        }
//    }


    /**
     * Detects whether the device is in portrait mode or in landscape mode by checking
     * the boolean constant in values and values-land.
     * It's up to the Android framework to load the correct values.
     *
     * @param context context
     * @return true if the device is in landscape, false if in portrait
     */
    public static boolean isInLandscapeOrientation(Context context) {
        return context.getResources().getBoolean(R.bool.isLandscape);
    }

    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(R.bool.isTablet);
    }
}
