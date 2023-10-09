package fr.delcey.ocyearbook.peoples

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import fr.delcey.ocyearbook.R
import fr.delcey.ocyearbook.data.People
import fr.delcey.ocyearbook.databinding.PeopleFragmentBinding
import fr.delcey.ocyearbook.utils.viewBinding

class PeoplesFragment : Fragment(R.layout.people_fragment) {


    companion object {
        fun newInstance() = PeoplesFragment().apply {
            arguments = Bundle()
        }
    }

    private val binding by viewBinding { PeopleFragmentBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PeopleAdapter(requireContext())

        binding.peopleRecyclerView.adapter = adapter

        binding.peopleRecyclerView.setOnClickListener {
            Toast.makeText(requireContext(), getNinoToast(), Toast.LENGTH_LONG).show()
        }

        val peopleList: MutableList<People> =
            mutableListOf(
                People(0,(R.drawable.nino), "Nino", "Mentor", "Kotlin", "Java",
                    R.string.nino_toast
                ),
                People(1,(R.drawable.david), "David", "Student", "Kotlin", "Java", R.string.david_toast)
            )

        adapter.submitList(peopleList)
    }

    private fun getNinoToast(): CharSequence = getText(R.string.nino_toast)
}