package com.fichardu.todo;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

/**
 * Created by xf on 2017/5/13
 */

public class ImageAdapter implements IWXImgLoaderAdapter {
    @Override
    public void setImage(String url, ImageView view, WXImageQuality quality, WXImageStrategy
            strategy) {
        Picasso.with(view.getContext()).load(url).into(view);
    }
}
