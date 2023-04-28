package com.anayat.resultboard.view.semesterlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.anayat.resultboard.R
import com.anayat.resultboard.databinding.FragmentSemesterListBinding
import com.google.firebase.database.FirebaseDatabase

class SemesterListFragment : Fragment() {
    private lateinit var semesterListScreen: FragmentSemesterListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        semesterListScreen = FragmentSemesterListBinding.inflate(inflater)

        val examRoll = arguments?.getString("examRoll")

        semesterListScreen.buttonFistSemester.setOnClickListener{
            val bundle = bundleOf("examRoll" to examRoll, "semester" to "01")
            findNavController().navigate(R.id.action_semester_list_dest_to_resultFragment, bundle)
        }

        semesterListScreen.buttonSecondSemester.setOnClickListener{
            val bundle = bundleOf("examRoll" to examRoll, "semester" to "02")
            findNavController().navigate(R.id.action_semester_list_dest_to_resultFragment, bundle)
        }

        semesterListScreen.buttonThirdSemester.setOnClickListener{
            val bundle = bundleOf("examRoll" to examRoll, "semester" to "03")
            findNavController().navigate(R.id.action_semester_list_dest_to_resultFragment, bundle)
        }

        semesterListScreen.buttonFourthSemester.setOnClickListener{
            val bundle = bundleOf("examRoll" to examRoll, "semester" to "04")
            findNavController().navigate(R.id.action_semester_list_dest_to_resultFragment, bundle)
        }

        semesterListScreen.buttonFifthSemester.setOnClickListener{
            val bundle = bundleOf("examRoll" to examRoll, "semester" to "05")
            findNavController().navigate(R.id.action_semester_list_dest_to_resultFragment, bundle)
        }

        semesterListScreen.buttonSixthSemester.setOnClickListener{
            val bundle = bundleOf("examRoll" to examRoll, "semester" to "06")
            findNavController().navigate(R.id.action_semester_list_dest_to_resultFragment, bundle)
        }

        semesterListScreen.buttonSeventhSemester.setOnClickListener{
            val bundle = bundleOf("examRoll" to examRoll, "semester" to "07")
            findNavController().navigate(R.id.action_semester_list_dest_to_resultFragment, bundle)
        }

        semesterListScreen.buttonEightSemester.setOnClickListener{
            val bundle = bundleOf("examRoll" to examRoll, "semester" to "08")
            findNavController().navigate(R.id.action_semester_list_dest_to_resultFragment, bundle)
        }

        return semesterListScreen.root
    }
}
