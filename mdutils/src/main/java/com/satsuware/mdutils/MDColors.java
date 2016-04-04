/*
 * Copyright 2016 Farbod Salamat-Zadeh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.satsuware.mdutils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MDColors {

    /*
     * Color groups
     */
    @StringDef({COLOR_RED, COLOR_PINK, COLOR_PURPLE, COLOR_DEEP_PURPLE,
            COLOR_INDIGO, COLOR_BLUE, COLOR_LIGHT_BLUE, COLOR_CYAN,
            COLOR_TEAL, COLOR_GREEN, COLOR_LIGHT_GREEN, COLOR_LIME,
            COLOR_YELLOW, COLOR_AMBER, COLOR_ORANGE, COLOR_DEEP_ORANGE,
            COLOR_BROWN, COLOR_GREY, COLOR_BLUE_GREY, COLOR_BLACK,
            COLOR_WHITE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorGroup {}

    public static final String COLOR_RED = "red", COLOR_PINK = "pink",
            COLOR_PURPLE = "purple", COLOR_DEEP_PURPLE = "deep_purple",
            COLOR_INDIGO = "indigo", COLOR_BLUE = "blue",
            COLOR_LIGHT_BLUE = "light_blue", COLOR_CYAN = "cyan",
            COLOR_TEAL = "teal", COLOR_GREEN = "green",
            COLOR_LIGHT_GREEN = "light_green", COLOR_LIME = "lime",
            COLOR_YELLOW = "yellow", COLOR_AMBER = "amber",
            COLOR_ORANGE = "orange", COLOR_DEEP_ORANGE = "deep_orange",
            COLOR_BROWN = "brown", COLOR_GREY = "grey",
            COLOR_BLUE_GREY = "blue_grey", COLOR_BLACK = "black",
            COLOR_WHITE = "white";

    /*
     * Color variants
     */
    @StringDef({_50, _100, _200, _300, _400, _500, _600, _700, _800, _900,
            A100, A200, A400, A700})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorVariant {}

    public static final String _50 = "50", _100 = "100", _200 = "200",
            _300 = "300", _400 = "400", _500 = "500", _600 = "600",
            _700 = "700", _800 = "800", _900 = "900", A100 = "a100",
            A200 = "a200", A400 = "a400", A700 = "a700";


    /*
     * Text/divider colors
     */
    @StringDef({COLOR_BLACK, COLOR_WHITE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextColor {}

    /*
     * Text styles
     */
    @IntDef({TEXT_PRIMARY, TEXT_SECONDARY, TEXT_HINT, TEXT_DISABLED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextStyle {}

    public static final int TEXT_PRIMARY = 0, TEXT_SECONDARY = 1,
            TEXT_HINT = 2, TEXT_DISABLED = 3;


    /*
     * Methods
     */

    @ColorRes
    public static int findColor(Context context, @ColorGroup String colorGroup, @ColorVariant String colorVariant) {
        try {
            String name = "mdu_" + colorGroup + "_" + colorVariant;
            return context.getResources().getIdentifier(name, "color", context.getPackageName());
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @ColorRes
    public static int findTextColor(Context context, @TextColor String textColor, @TextStyle int textStyle) {
        StringBuilder builder = new StringBuilder();
        builder.append("mdu_text_").append(textColor);
        switch (textStyle) {
            case TEXT_PRIMARY:
                break;
            case TEXT_SECONDARY:
                builder.append("_secondary");
                break;
            case TEXT_HINT:
            case TEXT_DISABLED:
                builder.append("_hint");
                break;
        }

        try {
            return context.getResources().getIdentifier(builder.toString(), "color", context.getPackageName());
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @ColorRes
    public static int findDividerColor(Context context, @TextColor String dividerColor) {
        try {
            String resName = "mdu_divider_" + dividerColor;
            return context.getResources().getIdentifier(resName, "color", context.getPackageName());
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
