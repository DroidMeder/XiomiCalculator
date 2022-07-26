package kg.internlabs.xiomicalculator.viewer.ui.simpleCalculatorViewer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.internlabs.xiomicalculator.databinding.HistoryItemBinding
import kg.internlabs.xiomicalculator.model.data.models.History

class HistoryAdapter(
    private var list: List<History>,
) : RecyclerView.Adapter<HistoryAdapter.PlaylistHolder>() {


    class PlaylistHolder(private val binding: HistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) = with(binding) {
            tvRawInput.text = history.input
            tvResultHistory.text = history.result
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistHolder {
        return PlaylistHolder(HistoryItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: PlaylistHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}