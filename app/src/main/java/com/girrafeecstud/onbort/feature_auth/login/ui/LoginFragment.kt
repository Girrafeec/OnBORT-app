/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_auth.login.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.girrafeecstud.core_ui.ui.BaseFragment
import com.girrafeecstud.onbort.app.ui.MainFlowFragment
import com.girrafeecstud.onbort.databinding.FragmentLoginBinding
import com.girrafeecstud.onbort.feature_auth.AuthFlowFragment
import com.girrafeecstud.onbort.feature_auth.login.domain.UserLoginEntity
import com.girrafeecstud.onbort.feature_auth.login.presentation.LoginUiState
import com.girrafeecstud.onbort.feature_auth.login.presentation.LoginViewModel
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.presentation.QuestsUiState
import com.girrafeecstud.onbort.feature_quests.presentation.QuestsViewModel
import com.girrafeecstud.onbort.feature_quests.ui.QuestsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener { login() }
    }

    override fun setListeners() {

    }

    override fun registerObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.state
                    .onEach {state ->
                        setState(state = state)
                    }
                    .launchIn(viewLifecycleOwner.lifecycleScope)
            }
        }
    }

    fun login() {
        val user = UserLoginEntity(
            userEmail = binding.emailInput.text.toString(),
            userPassword = binding.passwordInput.text.toString()
        )
        loginViewModel.login(user = user)

    }

    private fun setState(state: LoginUiState) {

        when (state.isLoading) {
            true -> {

            }
            false -> {

            }
        }

        if (state.loginPassed != null && state.loginPassed) {
            Log.i("tag", "quests list")
            (parentFragment?.parentFragment as AuthFlowFragment).navigateToMainFlow()
        }

    }

}