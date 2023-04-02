/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.girrafeecstud.onbort.databinding.QuestItemBinding
import com.girrafeecstud.onbort.feature_quests.domain.Quest

class QuestsAdapter(
    private val listener: QuestViewHolder.OnQuestItemClickListener
) : RecyclerView.Adapter<QuestViewHolder>() {

    private var quests = ArrayList<Quest>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestViewHolder {
        val binding = QuestItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestViewHolder(binding)
    }

    override fun getItemCount() = quests.size

    override fun onBindViewHolder(holder: QuestViewHolder, position: Int) {
        holder.bind(quest = quests.get(position), listener = listener)
    }

    fun refreshQuests(quests: List<Quest>) {
        this.quests = ArrayList(quests)
        notifyDataSetChanged()
    }

}