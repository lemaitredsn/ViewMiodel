package ru.lemaitre.mythirdrecycleview

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import kotlinx.android.synthetic.main.fragment_celebrities_list.*
import ru.lemaitre.mythirdrecycleview.adapters.CelebrityAdapter

class CelebritiesListFragmnet : Fragment(R.layout.fragment_celebrities_list){
    private var celebrityAdapter: CelebrityAdapter? = null

    private val celebrityListViewModel: CelebrityListViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initList()
        addFAB.setOnClickListener { addCelebrity() }
        observeViewModelState()
    }

    private fun initList() {
        celebrityAdapter = CelebrityAdapter ({id, link, name  ->
            val action = CelebritiesListFragmnetDirections.actionCelebritiesListFragmnetToDetailsFragment(id, link, name)
            findNavController().navigate(action)
        },{
            position -> deleteCelebritiy(position)
        })
        with(celeritiesList) {
            adapter = celebrityAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(false)
            itemAnimator = SlideInLeftAnimator()
        }
    }

    private fun observeViewModelState() {
        celebrityListViewModel.celebrities
            .observe(viewLifecycleOwner)
                {newListCelebrities ->
                    celebrityAdapter?.items = newListCelebrities}

        celebrityListViewModel.showToast
            .observe(viewLifecycleOwner){
                Toast.makeText(requireContext(), "Элемент добавлен", Toast.LENGTH_SHORT).show()
            }
        celebrityListViewModel.showDeleteToast
            .observe(viewLifecycleOwner){
                Toast.makeText(requireContext(), "Элемент удален", Toast.LENGTH_SHORT).show()
            }
    }

    private fun deleteCelebritiy(position: Int) {
        celebrityListViewModel.deleteCelebrity(position)

    }

    private fun addCelebrity() {
        celebrityListViewModel.addCelebrity()
        celeritiesList.scrollToPosition(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        celebrityAdapter = null
    }

    companion object {
        const val KEY_CELEBRITY = "key_celebrity"
    }
}
