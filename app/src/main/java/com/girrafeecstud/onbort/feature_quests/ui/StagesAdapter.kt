/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_quests.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.girrafeecstud.onbort.databinding.QuestItemBinding
import com.girrafeecstud.onbort.databinding.StageItemBinding
import com.girrafeecstud.onbort.feature_quests.domain.Quest
import com.girrafeecstud.onbort.feature_quests.domain.Stage

class StagesAdapter(
    private val listener: StageViewHolder.OnStageItemClickListener
) : RecyclerView.Adapter<StageViewHolder>() {

    private var stages = ArrayList<Stage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StageViewHolder {
        val binding = StageItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return StageViewHolder(binding)
    }

    override fun getItemCount() = stages.size

    override fun onBindViewHolder(holder: StageViewHolder, position: Int) {
        holder.bind(stage = stages.get(position), listener = listener)
    }

    fun refreshStages(stages: List<Stage>) {
        this.stages = ArrayList(stages)
        notifyDataSetChanged()
    }

}