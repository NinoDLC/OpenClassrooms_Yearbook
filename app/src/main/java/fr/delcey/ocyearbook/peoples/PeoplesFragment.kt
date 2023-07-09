package fr.delcey.ocyearbook.peoples

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import fr.delcey.ocyearbook.R
import fr.delcey.ocyearbook.databinding.PeoplesFragmentBinding
import fr.delcey.ocyearbook.utils.viewBinding

class PeoplesFragment : Fragment(R.layout.peoples_fragment) {
    companion object {
        fun newInstance() = PeoplesFragment().apply {
            arguments = Bundle()
        }
    }

    private val binding by viewBinding { PeoplesFragmentBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.peoplesCardViewNino.setOnClickListener {
            Toast.makeText(requireContext(), getNinoToast(), Toast.LENGTH_LONG).show()
        }
    }

    private fun getNinoToast(): CharSequence = getText(R.string.nino_toast)
}