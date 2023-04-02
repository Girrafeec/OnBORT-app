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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.girrafeecstud.core_ui.extension.loadAndSetImage
import com.girrafeecstud.core_ui.ui.BaseFragment
import com.girrafeecstud.onbort.app.ui.MainFlowFragment
import com.girrafeecstud.onbort.databinding.FragmentQuestDetailsBinding
import com.girrafeecstud.onbort.databinding.FragmentQuestsBinding
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.domain.Stage
import com.girrafeecstud.onbort.feature_quests.presentation.QuestDetailsUiState
import com.girrafeecstud.onbort.feature_quests.presentation.QuestDetailsViewModel
import com.girrafeecstud.onbort.feature_quests.presentation.QuestsUiState
import com.girrafeecstud.onbort.feature_quests.presentation.QuestsViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class QuestDetailsFragment : BaseFragment(), StageViewHolder.OnStageItemClickListener {

    private val args: QuestDetailsFragmentArgs by navArgs()

    private var _binding: FragmentQuestDetailsBinding? = null

    private val binding get() = _binding!!

    private val questDetailsViewModel: QuestDetailsViewModel by viewModels()

    private val stagesAdapter = StagesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecView()

        args.let { args.questId
            if (args.questId != null)
                questDetailsViewModel.getQuestDetails(args.questId!!.toLong())
        }
    }

    override fun setListeners() {

    }

    override fun onStageItemClickListener(stage: Stage) {
        Log.i("ree", "ff")
    }

    override fun registerObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                questDetailsViewModel.state
                    .onEach {state ->
                        setState(state = state)
                    }
                    .launchIn(viewLifecycleOwner.lifecycleScope)
            }
        }
    }

    private fun setState(state: QuestDetailsUiState) {

        when (state.isLoading) {
            true -> {
                binding.progres.visibility = View.VISIBLE
                binding.details.visibility = View.GONE
            }
            false -> {
                binding.progres.visibility = View.GONE
                binding.details.visibility = View.VISIBLE
            }
        }

        if (state.quest != null) {
            setQuestData(quest = state.quest)
        }


    }

    private fun setQuestData(quest: Quest) {
        binding.questName.text = quest.name
//        binding.questImage.loadAndSetImage(url = quest.)
        stagesAdapter.refreshStages(stages = quest.stages)
    }

    private fun initRecView() {
        binding.stages.let { stage ->
            stage.adapter = stagesAdapter
            stage.layoutManager = LinearLayoutManager(
                requireActivity().applicationContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

}