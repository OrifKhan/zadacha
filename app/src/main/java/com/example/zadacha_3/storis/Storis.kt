package com.example.zadacha_3.storis

import android.os.Parcel
import android.os.Parcelable

data class Storis (val imegStoris: Int, val textStoris: String):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
     dest?.writeInt(imegStoris)
        dest?.writeString(textStoris)
      /*  dest?.writeInt(imegStoris)
        dest?.writeString(textStoris)*/
    }

    companion object CREATOR : Parcelable.Creator<Storis> {
        override fun createFromParcel(parcel: Parcel): Storis {
            return Storis(parcel)
        }

        override fun newArray(size: Int): Array<Storis?> {
            return arrayOfNulls(size)
        }
    }
}