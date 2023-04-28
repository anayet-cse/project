package com.anayat.resultboard.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.anayat.resultboard.R
import com.anayat.resultboard.databinding.FragmentLoginBinding

class
 LoginFragment : Fragment() {
    private lateinit var loginScreen: FragmentLoginBinding
    private lateinit var viewModel: LoginVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginScreen = FragmentLoginBinding.inflate(inflater)
        viewModel = LoginVM()
        loginScreen.viewModel = viewModel

        loginScreen.buttonLogin.setOnClickListener {
            viewModel.checkCredential()
        }

        loginScreen.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_dest_to_registration_dest)
        }

        viewModel.enableToNext.observe(viewLifecycleOwner) { flag ->
            if(flag) {
                val bundle = bundleOf("examRoll" to viewModel.examRoll.value)
                findNavController().navigate(R.id.action_login_dest_to_semester_list_dest, bundle)
            } else {
                Toast.makeText(requireContext(), "Check your credential", Toast.LENGTH_SHORT).show()
            }
        }

        return loginScreen.root
    }

    override fun onPause() {
        super.onPause()
        viewModel.enableToNext
    }
}
