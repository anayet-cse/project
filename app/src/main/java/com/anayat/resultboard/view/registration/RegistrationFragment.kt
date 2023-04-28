package com.anayat.resultboard.view.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anayat.resultboard.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private lateinit var registrationView: FragmentRegistrationBinding
    private lateinit var viewModel: RegistrationVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        registrationView = FragmentRegistrationBinding.inflate(inflater)
        viewModel = RegistrationVM()
        registrationView.viewModel = viewModel

        registrationView.buttonSignUp.setOnClickListener {
            viewModel.doStudentRegistration()
        }

        viewModel.enableToNext.observe(viewLifecycleOwner) { flag ->
            if (flag) {
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Fail to update data", Toast.LENGTH_SHORT).show()
            }
        }

        return registrationView.root
    }
}
