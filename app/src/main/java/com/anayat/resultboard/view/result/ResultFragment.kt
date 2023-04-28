package com.anayat.resultboard.view.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anayat.resultboard.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var resultView: FragmentResultBinding
    private lateinit var viewModel: ResultVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        resultView = FragmentResultBinding.inflate(inflater)
        val examRoll = arguments?.getString("examRoll")
        val semester = arguments?.getString("semester")

        viewModel = ResultVM(examRoll!!, semester!!)

        viewModel.result.observe(viewLifecycleOwner) {
            resultView.textResult.text = "Result is $it"
        }

        return resultView.root
    }
}
