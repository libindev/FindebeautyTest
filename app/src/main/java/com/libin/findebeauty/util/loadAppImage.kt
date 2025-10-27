package com.libin.findebeauty.util

import android.widget.ImageView
import coil.load
import com.libin.findebeauty.R


fun ImageView.loadAppImage(imageUrl: String) {
    this.load(imageUrl) {
        crossfade(true)
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_placeholder)
    }
}