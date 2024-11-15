package com.pro.movie.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pro.movie.R;

public class GlideUtils {

    public static void loadUrlBanner(String url, ImageView imageView) {
        if (StringUtil.isEmpty(url)) {
            imageView.setImageResource(R.drawable.ic_no_image);
            return;
        }
        Glide.with(imageView.getContext())
                .load(url)
                .error(R.drawable.ic_no_image)
                .dontAnimate()
                .into(imageView);
    }

    public static void loadUrl(String url, ImageView imageView) {
        if (StringUtil.isEmpty(url)) {
            imageView.setImageResource(R.drawable.image_no_available);
            return;
        }
        Glide.with(imageView.getContext())
                .load(url)
                .error(R.drawable.image_no_available)
                .dontAnimate()
                .into(imageView);
    }
}