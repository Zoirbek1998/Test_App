package dev.future.testapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.future.testapp.databinding.FragmentTermsBinding

class TermsFragment : Fragment() {
    lateinit var binding : FragmentTermsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTermsBinding.inflate(layoutInflater)
        return binding.root
    }
}