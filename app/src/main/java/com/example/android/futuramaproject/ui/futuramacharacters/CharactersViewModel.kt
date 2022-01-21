package com.example.android.futuramaproject.ui.futuramacharacters

import android.app.Application
import androidx.lifecycle.*
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import com.example.android.futuramaproject.network.networkmodel.ServiceResult
import com.example.android.futuramaproject.network.repo.FuturamaRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    application: Application,
    private val futuramaRepo: FuturamaRepo,
    private val dispatchers: CoroutineDispatcher
) : AndroidViewModel(application) {

    private val _characterFeed = MutableLiveData<List<FuturamaCharacter>?>()

    val characterFeed: LiveData<List<FuturamaCharacter>?>
        get() = _characterFeed

    fun getFuturamaCharacters() {
        viewModelScope.launch(dispatchers) {
            when (val response = futuramaRepo.fetchFuturamaCharacters())
            {
                is ServiceResult.Success -> {
                    _characterFeed.postValue(response.data)
                    Timber.d("Got the characters baby. " + response.data)
                }

                is ServiceResult.Error -> {
                    Timber.d("Error was found when calling Futurama quotes : " + response.exception)
                }

                else -> {
                    Timber.d("First day on the job and you get this? Bro.")
                }
            }
        }
    }

}
