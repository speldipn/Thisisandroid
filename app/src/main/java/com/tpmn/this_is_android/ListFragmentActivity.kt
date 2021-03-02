package com.tpmn.this_is_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class ListFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_fragment)
        setFragments()
    }

    private fun setFragments() {
        val sampleParcel = SampleParcel()
        sampleParcel.name = "Neo"
        sampleParcel.age = 34

        val bundle = Bundle()
        bundle.putParcelable("data", sampleParcel)

        val oneFragment = OneFragment()
        oneFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.container, oneFragment)
            .commit()
    }

    class SampleParcel() : Parcelable {

        var name: String? = null
        var age: Int? = null

        constructor(parcel: Parcel) : this() {
            name = parcel.readString()
            age = parcel.readInt()
        }

        override fun writeToParcel(dest: Parcel?, flags: Int) {
            dest?.writeString(name)
            dest?.writeInt(age!!)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<SampleParcel> {
            override fun createFromParcel(parcel: Parcel): SampleParcel {
                return SampleParcel(parcel)
            }

            override fun newArray(size: Int): Array<SampleParcel?> {
                return arrayOfNulls(size)
            }
        }

    }

}