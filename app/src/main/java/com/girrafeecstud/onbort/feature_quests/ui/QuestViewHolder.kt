/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.ui

import androidx.recyclerview.widget.RecyclerView
import com.girrafeecstud.onbort.databinding.QuestItemBinding
import com.girrafeecstud.onbort.feature_quests.domain.Quest

class QuestViewHolder(
    private val binding: QuestItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    private fun bindQuestItem(quest: Quest, listener: OnQuestItemClickListener) {
    }

    fun bind(quest: Quest, listener: OnQuestItemClickListener) {
        bindQuestItem(quest = quest, listener = listener)
    }

    interface OnQuestItemClickListener {
        fun onQuestItemClickListener(quest: Quest)
    }

}