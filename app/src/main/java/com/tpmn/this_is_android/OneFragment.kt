package com.tpmn.this_is_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tpmn.this_is_android.ListFragmentActivity.SampleParcel
import kotlinx.android.synthetic.main.fragment_one.*

class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.getParcelable<SampleParcel>("data")
        textView.append("${data?.name}")
        textView.append(" ")
        textView.append("${data?.age}")
    }
}