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

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MDMotion {

    @IntDef({MOBILE, TABLET, WEARABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceType {}

    public static final int MOBILE = 0, TABLET = 1, WEARABLE = 2;


    @IntDef({FULL_SCREEN, ENTER, LEAVE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionType {}

    public static final int FULL_SCREEN = 375, ENTER = 225, LEAVE = 195;


    public static int getTransitionDuration(@TransitionType int transitionType,
                                            @DeviceType int deviceType) {
        int duration = transitionType;
        switch (deviceType) {
            case MOBILE:
                duration = transitionType;
                break;
            case TABLET:
                duration = (int) (transitionType * 1.3);
                break;
            case WEARABLE:
                duration = (int) (transitionType * 0.7);
                break;
        }
        return duration;
    }

}
