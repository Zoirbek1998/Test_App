package dev.future.testapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.future.testapp.R
import dev.future.testapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonConfirm.setOnClickListener {

            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()

//            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username,password)
//            findNavController().navigate(action)

            findNavController().navigate(LoginFragmentDirections.actionLoginFragment2ToWelcomeFragment2(username,password))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}