package com.example.android.futuramaproject.ui.futuramaquotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.futuramaproject.network.data.CharQuote
import com.example.android.futuramaproject.network.networkmodel.ServiceResult
import com.example.android.futuramaproject.network.repo.FuturamaRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    application: Application,
    private val futuramaRepo: FuturamaRepo,
    private val dispatchers: Dispatchers
) : AndroidViewModel(application) {

    private val _quoteFeed = MutableLiveData<List<CharQuote>?>()

    val quoteFeed: LiveData<List<CharQuote>?>
        get() = _quoteFeed

    fun getQuotes() {
        viewModelScope.launch(dispatchers.IO) {
            when (val response = futuramaRepo.fetchFuturamaQuotes())
            {
                is ServiceResult.Success -> {
                    _quoteFeed.postValue(response.data)
                    Timber.d("Got the quotes baby. " + response.data)
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
