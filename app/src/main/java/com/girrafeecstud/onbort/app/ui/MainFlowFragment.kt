/* Created by Girrafeec */

package com.girrafeecstud.onbort.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.girrafeecstud.core_ui.ui.BaseFlowFragment
import com.girrafeecstud.onbort.R
import com.girrafeecstud.onbort.app.navigation.MainFlowDestination
import com.girrafeecstud.onbort.app.navigation.MainFlowNavigator
import com.girrafeecstud.onbort.app.navigation.ToMainScreenNavigable
import com.girrafeecstud.onbort.databinding.FragmentMainFlowBinding
import com.girrafeecstud.onbort.navigation.DefaultQuestFlowScreen
import com.girrafeecstud.onbort.navigation.ToFlowNavigable
import com.girrafeecstud.onbort.navigation.destination.FlowDestination

class MainFlowFragment : BaseFlowFragment(
    com.girrafeecstud.onbort.R.id.nav_host_fragment_main_container
), ToMainScreenNavigable {

//    private val mapFlowArgs: MainFlowArgs by navArgs()

    private val navigator = MainFlowNavigator()

    private var _binding: FragmentMainFlowBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainFlowBinding.inflate(inflater, container, false)
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
        binding.mainFlowBottomNav.setupWithNavController(navController)
    }

    fun openQuestDetailsScreen(questId: Long) {
        (requireActivity() as ToFlowNavigable)
            .navigateToScreen(
                destination = FlowDestination.QuestFlow(
                    _defaultScreen = DefaultQuestFlowScreen.QUEST_DETAILS
                )
            )
    }

    override fun navigateToScreen(destination: MainFlowDestination) {
        TODO("Not yet implemented")
    }


}