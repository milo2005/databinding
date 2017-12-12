package kcumen.trazagro.peliculas.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@SuppressLint("ParcelCreator")
@Parcelize
class Movie(val img:String,
            val name:String?,
            val duration:Int,
            val releaseDate: Date,
            val sinopsis:String):Parcelable