package dev.future.testapp.fragment



import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kevalpatel.passcodeview.PinView
import com.kevalpatel.passcodeview.authenticator.PasscodeViewPinAuthenticator
import com.kevalpatel.passcodeview.indicators.CircleIndicator
import com.kevalpatel.passcodeview.interfaces.AuthenticationListener
import com.kevalpatel.passcodeview.keys.KeyNamesBuilder
import com.kevalpatel.passcodeview.keys.RoundKey
import dev.future.testapp.R
import dev.future.testapp.RecyclerActivity
import dev.future.testapp.databinding.FragmentTermsBinding


class TermsFragment : Fragment() {
    lateinit var binding : FragmentTermsBinding
    private val ARG_CURRENT_PIN = "current_pin"
    var al: ArrayList<Int> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTermsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        intToArray("1234".toInt())
        val correctPattern = intArrayOf(1, 2, 3, 4)
        Toast.makeText(requireActivity(), al.toString(), Toast.LENGTH_SHORT).show()

        val correctPin = arrayListOf(getIntValueFromString(al))
//        binding.pinView.setPinAuthenticator(PasscodeViewPinAuthenticator(correctPin))

        binding.pinView.setPinLength(PinView.DYNAMIC_PIN_LENGTH);

        binding.pinView.setKey(
            RoundKey.Builder( binding.pinView)
                .setKeyPadding(R.dimen.key_padding)
//                .setKeyStrokeColorResource(R.color.colorAccent)
                .setKeyStrokeWidth(R.dimen.key_stroke_width)
                .setKeyTextColorResource(R.color.colorAccent)
                .setKeyTextSize(R.dimen.key_text_size)
        )

        binding.pinView.setIndicator(
            CircleIndicator.Builder(binding.pinView)
                .setIndicatorRadius(R.dimen.indicator_radius)
                .setIndicatorFilledColorResource(R.color.colorAccent)
                .setIndicatorStrokeColorResource(R.color.colorAccent)
                .setIndicatorStrokeWidth(R.dimen.indicator_stroke_width)
        )

        binding.pinView.setKeyNames(
            KeyNamesBuilder()
                .setKeyOne(requireActivity(), R.string.key_1)
                .setKeyTwo(requireActivity(), R.string.key_2)
                .setKeyThree(requireActivity(), R.string.key_3)
                .setKeyFour(requireActivity(), R.string.key_4)
                .setKeyFive(requireActivity(), R.string.key_5)
                .setKeySix(requireActivity(), R.string.key_6)
                .setKeySeven(requireActivity(), R.string.key_7)
                .setKeyEight(requireActivity(), R.string.key_8)
                .setKeyNine(requireActivity(), R.string.key_9)
                .setKeyZero(requireActivity(), R.string.key_0)
        )

        binding.pinView.setTitle("Enter the PIN");

        binding.pinView.setAuthenticationListener(object : AuthenticationListener {
            override fun onAuthenticationSuccessful() {
                //User authenticated successfully.
                //Navigate to secure screens.
                startActivity(Intent(requireActivity(), RecyclerActivity::class.java))

            }

            override fun onAuthenticationFailed() {
                //Calls whenever authentication is failed or user is unauthorized.
                //Do something
            }
        })
    }

    fun getIntValueFromString(value: ArrayList<Int>): Int {
        var returnValue = ""
        value.forEach {
            val item = it.toString().toIntOrNull()
            if(item is Int){
                returnValue += item.toString()
            }

        }
        return returnValue.toInt()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntArray(ARG_CURRENT_PIN, binding.pinView.getCurrentTypedPin())
        super.onSaveInstanceState(outState)
    }

    fun intToArray(num: Int){
        var num = num
        if (num != 0) {
            val temp = num % 10
            num /= 10
            intToArray(num)
            al.add(temp)

        }
    }
}