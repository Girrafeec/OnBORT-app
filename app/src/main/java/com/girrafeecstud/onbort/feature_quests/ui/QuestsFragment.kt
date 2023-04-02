/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.ui

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
import com.girrafeecstud.onbort.databinding.FragmentQuestsBinding
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.presentation.QuestsUiState
import com.girrafeecstud.onbort.feature_quests.presentation.QuestsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuestsFragment : BaseFragment(), QuestViewHolder.OnQuestItemClickListener {

    private var _binding: FragmentQuestsBinding? = null

    private val binding get() = _binding!!

    private val questsViewModel: QuestsViewModel by viewModels()

    private val questsAdapter = QuestsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecView()
    }

    override fun setListeners() {

    }

    override fun registerObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                questsViewModel.state
                    .onEach {state ->
                        setState(state = state)
                    }
                    .launchIn(viewLifecycleOwner.lifecycleScope)
            }
        }
    }

    override fun onQuestItemClickListener(quest: Quest) {
        (parentFragment?.parentFragment as MainFlowFragment).openQuestDetailsScreen(quest.questId)
    }

    private fun setState(state: QuestsUiState) {

        when (state.isLoading) {
            true -> {
                binding.progres.visibility = View.VISIBLE
                binding.quests.visibility = View.GONE
            }
            false -> {
                binding.progres.visibility = View.GONE
                binding.quests.visibility = View.VISIBLE
            }
        }

        if (state.questsList != null) {
            Log.i("tag", "quests list")
            questsAdapter.refreshQuests(quests = state.questsList)
        }

    }

    private fun initRecView() {
        binding.quests.let { quests ->
            quests.adapter =questsAdapter
            quests.layoutManager = LinearLayoutManager(
                requireActivity().applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }

}