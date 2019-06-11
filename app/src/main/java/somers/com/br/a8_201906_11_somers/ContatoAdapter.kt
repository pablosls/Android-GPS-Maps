package somers.com.br.a8_201906_11_somers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContatoAdapter : RecyclerView.Adapter<ContatoAdapter.ViewHolder>() {

    private lateinit var items: List<Contato>

    fun updateItems(newItems: List<Contato>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contatos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contato = items[position]
        holder.tvNomeContato.text = contato.nome
        holder.tvTelefoneContato.text = contato.telefone
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNomeContato = itemView.findViewById<TextView>(R.id.tvNomeContato)
        val tvTelefoneContato = itemView.findViewById<TextView>(R.id.tvTelefoneContato)
    }

}

