package ui.screens.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.remote.model.Character
import data.repository.CharacterRepositoryImpl
import domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


/**
 * Created by gurkankesgin on 28.07.2024.
 */
class CharacterListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<List<Character>?>(null)
    val uiState: StateFlow<List<Character>?> = _uiState.asStateFlow()

    private var useCase: GetCharacterUseCase? = null

    init {
        useCase = GetCharacterUseCase(CharacterRepositoryImpl())
        getResult()
    }

    private fun getResult() {
        viewModelScope.launch {
            useCase?.invoke()?.onEach {
                _uiState.value = it
            }?.launchIn(viewModelScope)
        }
    }
}