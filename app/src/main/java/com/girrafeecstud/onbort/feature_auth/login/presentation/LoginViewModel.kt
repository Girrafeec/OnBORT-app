/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.presentation

import androidx.lifecycle.viewModelScope
import com.girrafeecstud.core_ui.presentation.BaseViewModel
import com.girrafeecstud.onbort.feature_auth.login.domain.LoginUseCase
import com.girrafeecstud.onbort.feature_auth.login.domain.UserLoginEntity
import com.girrafeecstud.core_base.domain.base.BusinessResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginUiState>() {

    override var _state: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    override val state: StateFlow<LoginUiState> = _state.asStateFlow()

    init {

    }

    fun login(user: UserLoginEntity) {
        viewModelScope.launch {
            loginUseCase(user = user)
                .onStart {
                // TODO make loading state
                }
                .onEach { result ->
                    when (result) {
                        is BusinessResult.Error -> {
                            //TODO make some error state
                        }
                        is BusinessResult.Exception -> {
                            //TODO make error state
                        }
                        is BusinessResult.Success -> {
                            //TODO make successful state
                        }
                    }
                }
                .launchIn(viewModelScope)
        }
    }

}