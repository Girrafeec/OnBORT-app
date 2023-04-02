/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.girrafeecstud.core_ui.ui.BaseFlowFragment
import com.girrafeecstud.onbort.QuestFlowArgs
import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.databinding.FragmentQuestFlowBinding
import com.girrafeecstud.onbort.feature_quests.navigation.QuestFlowDestination
import com.girrafeecstud.onbort.feature_quests.navigation.QuestFlowNavigator
import com.girrafeecstud.onbort.feature_quests.navigation.ToQuestScreenNavigable
import com.girrafeecstud.onbort.navigation.DefaultQuestFlowScreen

class QuestFlowFragment : BaseFlowFragment(
    R.id.nav_host_fragment_quest_container
), ToQuestScreenNavigable {

    private val args: QuestFlowArgs by navArgs()

    private val navigator = QuestFlowNavigator()

    private var _binding: FragmentQuestFlowBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestFlowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUpNavigation() {
        super.setUpNavigation()
        navigator.setNavController(navController)
        args.defaultScreen.let { screen ->
            when(screen) {
                DefaultQuestFlowScreen.QUEST_DETAILS -> {
                    navigator.setStartDestination(
                        destination = QuestFlowDestination.QuestDetails(
                            questId = args.questId
                        ),
                        stringArgs = hashMapOf("questId" to args.questId.toString())
                    )
                }
                DefaultQuestFlowScreen.QUEST_STAGE -> {
                    navigator.setStartDestination(
                        destination = QuestFlowDestination.Stage()
                    )
                }
            }
        }
    }

    override fun setListeners() {
        super.setListeners()
    }

    override fun registerObservers() {
        super.registerObservers()
    }

    override fun navigateToScreen(destination: QuestFlowDestination) {
        TODO("Not yet implemented")
    }
}