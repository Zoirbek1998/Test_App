package dev.future.testapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import dev.future.testapp.databinding.ActivityRecyclerBinding
import dev.future.testapp.databinding.FragmentSettingsBinding

class SettingsFragment:Fragment() {
    lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.webView.webViewClient = WebViewClient()

        binding.webView.apply {
            loadUrl("https://www.pinterest.com/")
            settings.javaScriptEnabled = true
        }


    }

}