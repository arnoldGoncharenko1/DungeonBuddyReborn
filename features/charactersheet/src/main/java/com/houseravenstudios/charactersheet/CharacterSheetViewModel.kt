package com.houseravenstudios.charactersheet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.houseravenstudios.common.result.ApiResult
import com.houseravenstudios.data.classes.model.ClassList
import com.houseravenstudios.domain.usecase.GetClassListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterSheetViewModel @Inject constructor(
    private val getClassListUseCase: GetClassListUseCase
) : ViewModel() {
    var uiState by mutableStateOf<UiState>(UiState.Loading)
        private set

    init {
        fetchClasses()
    }

    private fun fetchClasses() {
        viewModelScope.launch {
            uiState = UiState.Loading
            getClassListUseCase.fetchClasses().collectLatest(::handleCategoriesResult)
        }
    }

    private fun handleCategoriesResult(result: ApiResult<ClassList>) {
        uiState = when (result) {
            is ApiResult.Success -> UiState.Success(data = result.data, tabIndex = 0)
            is ApiResult.Error -> UiState.Failed(message = result.throwable?.message.orEmpty())
        }
    }

    sealed interface UiState {
        data object Loading : UiState
        data class Success(val data: ClassList, val tabIndex: Int) : UiState
        data class Failed(val message: String) : UiState
    }
}