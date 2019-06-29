package com.example.udemy_notepad

import android.os.Parcel
import android.os.Parcelable

/**
 * File created by Jonathan CHU on 29/06/19
 */

/*Parcelable -> allows to create an instance of a class by reading what a user is typing*/
data class Note(var title: String = "",
                var text: String = "",
                var filename: String = ""): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(text)
        parcel.writeString(filename)
    }

    override fun describeContents(): Int {
        println(this)
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

}