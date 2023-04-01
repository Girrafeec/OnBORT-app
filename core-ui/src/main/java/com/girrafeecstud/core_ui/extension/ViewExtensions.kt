/* Created by Girrafeec */

package com.girrafeecstud.core_ui.extension

import android.widget.ImageView
import com.girrafeecstud.onbort.R
import com.squareup.picasso.Picasso

fun ImageView.loadAndSetImage(url: String) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.white_regular_rectangle)
        .into(this)
}