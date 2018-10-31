package com.example.latte_core.ui.camera;

import com.yalantis.ucrop.UCrop;

/**
 * 状态返回码
 */
public class RequestCodes {

    public static final int TAKE_PHOTO = 4;
    public static final int PICK_PHOTO = 5;
    public static final int CROP_PHOTO = UCrop.REQUEST_CROP;
    public static final int CROP_ERRPR = UCrop.RESULT_ERROR;
    public static final int SCAN = 7;
}
