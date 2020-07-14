package duggu.scroll.tabchange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_sub_cat.view.*

class SubCategoryAdapter( var dataList: ArrayList<SubCategoryModel?>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(position: Int) {
        for ((index ,model) in dataList.withIndex()) {
            model?.isSelected = position == index
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SubCategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sub_cat, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SubCategoryViewHolder) {
            holder.bind()
        }
    }

    inner class SubCategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            dataList[layoutPosition]?.let { model ->
                itemView.tvSubCatTextISF.text = model.name
                if (model.isSelected) {
                    itemView.tvSubCatTextISF.setTextColor(ContextCompat.getColor(view.context, R.color.white))
                    itemView.tvSubCatTextISF.background = ContextCompat.getDrawable(view.context, R.drawable.unslected_button)
                } else {
                    itemView.tvSubCatTextISF.setTextColor(ContextCompat.getColor(view.context, R.color.black))
                    itemView.tvSubCatTextISF.background = ContextCompat.getDrawable(view.context, R.drawable.selected_button)
                }
            }
        }
    }

}