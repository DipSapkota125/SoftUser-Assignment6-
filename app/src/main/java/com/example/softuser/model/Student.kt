package com.example.softuser.model

import android.os.Parcel
import android.os.Parcelable

data class Student (
        var id:Int?=0,
        var name : String? = null,
        var age : Int? = 0,
        var gender : String? = null,
        var Address : String? = null,
        var image : String? = null


): Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),

                ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeValue(id)
                parcel.writeValue(name)
                parcel.writeValue(age)
                parcel.writeString(gender)
                parcel.writeString(Address)
                parcel.writeString(image)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Student> {
                override fun createFromParcel(parcel: Parcel): Student {
                        return Student(parcel)
                }

                override fun newArray(size: Int): Array<Student?> {
                        return arrayOfNulls(size)
                }
        }

}
