package tech.tibor.cities

import android.os.Parcel
import android.os.Parcelable


data class City(val _id: String, val country: String, val name: String, val coord: Coordinates) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Coordinates::class.java.classLoader)) {
    }

    override fun toString(): String = name + ", " + country

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(country)
        parcel.writeString(name)
        parcel.writeParcelable(coord, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<City> {
        override fun createFromParcel(parcel: Parcel): City {
            return City(parcel)
        }

        override fun newArray(size: Int): Array<City?> {
            return arrayOfNulls(size)
        }
    }

    data class Coordinates(val lon: Double, val lat: Double) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readDouble(),
                parcel.readDouble()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeDouble(lon)
            parcel.writeDouble(lat)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Coordinates> {
            override fun createFromParcel(parcel: Parcel): Coordinates {
                return Coordinates(parcel)
            }

            override fun newArray(size: Int): Array<Coordinates?> {
                return arrayOfNulls(size)
            }
        }
    }
}
