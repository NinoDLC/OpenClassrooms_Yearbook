package fr.delcey.ocyearbook.peoples

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import fr.delcey.ocyearbook.R
import fr.delcey.ocyearbook.databinding.PeopleFragmentBinding
import fr.delcey.ocyearbook.domain.PeopleEntity
import fr.delcey.ocyearbook.utils.viewBinding

class PeoplesFragment : Fragment(R.layout.people_fragment) {

    companion object {
        fun newInstance() = PeoplesFragment()
    }

    private val binding by viewBinding { PeopleFragmentBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PeoplesAdapter()
        binding.peopleRecyclerView.adapter = adapter

        val peopleEntityLists: List<PeopleEntity> = listOf(
            PeopleEntity(0, R.drawable.nino, R.string.a11y_nino_photo, R.string.nino_name, R.string.mentor, R.string.kotlin, R.string.java, R.string.nino_toast),
            PeopleEntity(1, R.drawable.david, R.string.a11y_david_photo, R.string.david_name, R.string.student, R.string.kotlin, R.string.java, R.string.david_toast)
        )

        adapter.submitList(peopleEntityLists)
    }
}