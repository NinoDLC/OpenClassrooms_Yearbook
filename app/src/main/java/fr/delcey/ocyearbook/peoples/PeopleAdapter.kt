package fr.delcey.ocyearbook.peoples

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import fr.delcey.ocyearbook.data.People
import fr.delcey.ocyearbook.databinding.PeopleItemBinding

class PeopleAdapter(private val context: Context): ListAdapter<People, PeopleAdapter.PeopleViewHolder>(PeopleDiffCallback) {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder {
        val binding = PeopleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(getItem(position))

        val people = getItem(position)

        Glide.with(holder.itemView)
            .load(people.photo)
            .override(300, 400)
            .into(holder.binding.peoplesPhoto)
    }

    class PeopleViewHolder(val binding: PeopleItemBinding, context: Context): ViewHolder(binding.root){
        private  var haveContext: Context = context

        fun bind(people: People){

            binding.name.text = people.name
            binding.peoplesTextViewFunction.text = people.function
            binding.peoplesTextViewNinoFirstLanguage.text = people.firstLanguage
            binding.peoplesTextViewNinoSecondLanguage.text = people.secondLanguage
            binding.peoplesCardView.setOnClickListener {
                Toast.makeText(haveContext, people.sentence, Toast.LENGTH_LONG).show()
            }
        }

    }

}
    object PeopleDiffCallback : DiffUtil.ItemCallback<People>() {
        override fun areItemsTheSame(oldItem: People, newItem: People): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: People, newItem: People): Boolean = oldItem == newItem
    }
