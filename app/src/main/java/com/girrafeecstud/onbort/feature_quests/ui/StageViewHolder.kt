/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.ui

import androidx.recyclerview.widget.RecyclerView
import com.girrafeecstud.onbort.databinding.StageItemBinding
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.domain.Stage

class StageViewHolder(
    private val binding: StageItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    private fun bindStageItem(stage: Stage, listener: OnStageItemClickListener) {
        binding.stageName.text = stage.name
        if (!stage.passed)
            binding.stagePassedText.text = "Этап не завершён"
    }

    fun bind(stage: Stage, listener: OnStageItemClickListener) {
        bindStageItem(stage = stage, listener = listener)
    }

    interface OnStageItemClickListener {
        fun onStageItemClickListener(stage: Stage)
    }

}