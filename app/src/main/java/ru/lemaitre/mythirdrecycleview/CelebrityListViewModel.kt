package ru.lemaitre.mythirdrecycleview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CelebrityListViewModel : ViewModel() {
    private val repository = CelebrityRepository()

    private val celebrityLiveData = MutableLiveData<List<Celebrity>>(
        repository.generateCelebrities(10)
    )
    val celebrities: LiveData<List<Celebrity>>
        get() = celebrityLiveData

    private val showToastLiveData = SingleLiveEvent<Unit>()

    val showToast: LiveData<Unit>
        get() = showToastLiveData

    private val showDeleteToastLiveData = SingleLiveEvent<Unit>()

    val showDeleteToast: LiveData<Unit>
        get() = showDeleteToastLiveData

    fun addCelebrity() {
        val updatedList = repository.createCelebrity(celebrityLiveData.value.orEmpty())
        celebrityLiveData.postValue(updatedList)
        showToastLiveData.postValue(Unit)
    }

    fun deleteCelebrity(position: Int) {
        celebrityLiveData.postValue(
            repository.deleteCelebrity(
                celebrityLiveData.value.orEmpty(), position
            )
        )
        showDeleteToastLiveData.postValue(Unit)
    }

}