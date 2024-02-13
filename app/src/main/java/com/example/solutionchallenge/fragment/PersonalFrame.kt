package com.example.solutionchallenge.fragment


import com.example.solutionchallenge.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.solutionchallenge.databinding.MainframePersonalBinding


class PersonalFrame : Fragment() {

    private var binding: MainframePersonalBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainframePersonalBinding.inflate(inflater, container, false)
        val view = binding!!.root


        binding!!.ToPERlistButton.setOnClickListener {

        }

        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
