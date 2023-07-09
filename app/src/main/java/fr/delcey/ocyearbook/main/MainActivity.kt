package fr.delcey.ocyearbook.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import fr.delcey.ocyearbook.databinding.MainActivityBinding
import fr.delcey.ocyearbook.peoples.PeoplesFragment
import fr.delcey.ocyearbook.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding { MainActivityBinding.inflate(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setSupportActionBar(binding.mainToolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(binding.mainFrameLayoutFragmentContainer.id, PeoplesFragment.newInstance())
            }
        }
    }
}