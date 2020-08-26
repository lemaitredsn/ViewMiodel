package ru.lemaitre.mythirdrecycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startCelebrityBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerMainFragment, CelebritiesListFragmnet())
                .addToBackStack(null)
                .commit()
        }
        startHorizontalLinearLayout.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerMainFragment, HorizontalFragment())
                .addToBackStack(null)
                .commit()
        }
        startGridLayoutManagerBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerMainFragment, GridImageFragment())
                .addToBackStack(null)
                .commit()
        }
        startStaggeredGridLayoutManagerBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerMainFragment, StaggeredImageFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}