package fr.delcey.ocyearbook.peoples

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import fr.delcey.ocyearbook.databinding.PeopleItemBinding
import fr.delcey.ocyearbook.domain.PeopleEntity

class PeoplesAdapter : ListAdapter<PeopleEntity, PeoplesAdapter.PeopleViewHolder>(PeopleDiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = PeopleViewHolder(
        PeopleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PeopleViewHolder(private val binding: PeopleItemBinding) : ViewHolder(binding.root) {
        fun bind(people: PeopleEntity) {
            Glide.with(binding.peopleItemImageViewPhoto)
                .load(people.photoDrawableRes)
                .fitCenter()
                .into(binding.peopleItemImageViewPhoto)
            binding.peopleItemImageViewPhoto.contentDescription =
                binding.peopleItemImageViewPhoto.resources.getString(people.photoContentDescription)
            binding.peopleItemTextViewName.setText(people.name)
            binding.peopleItemTextViewRole.setText(people.roleStringRes)
            binding.peopleItemTextViewFirstLanguage.setText(people.firstLanguageStringRes)
            binding.peopleItemTextViewSecondLanguage.setText(people.secondLanguageStringRes ?: 0)
            binding.peopleItemCardView.setOnClickListener {
                Toast.makeText(binding.peopleItemCardView.context, people.greetStringRes, Toast.LENGTH_LONG).show()
            }
        }
    }

    object PeopleDiffCallback : DiffUtil.ItemCallback<PeopleEntity>() {
        override fun areItemsTheSame(oldItem: PeopleEntity, newItem: PeopleEntity): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PeopleEntity, newItem: PeopleEntity): Boolean = oldItem == newItem
    }
}