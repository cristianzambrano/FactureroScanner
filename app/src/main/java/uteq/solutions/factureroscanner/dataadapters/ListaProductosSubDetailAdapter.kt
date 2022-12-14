package uteq.solutions.factureroscanner.dataadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import uteq.solutions.factureroscanner.R
import uteq.solutions.factureroscanner.models.Producto


class ListaProductosSubDetailAdapter (val productList: ArrayList<Producto>) : RecyclerView.Adapter<ListaProductosSubDetailAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.lyitemproductscard, viewGroup, false)
        return ViewHolder(v)
    }

    public fun addItem(producto: Producto) {
        productList.add(producto)
        notifyItemInserted(productList.size-1)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtCant.text = productList[position].cantidad
        holder.txtDesc.text = productList[position].descripcion
        holder.txtPVP.text = productList[position].pvp
        holder.txtSUbT.text = productList[position].subtotal
    }

    override fun getItemCount(): Int {
        return productList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtCant: TextView
        var txtDesc: TextView
        var txtPVP: TextView
        var txtSUbT: TextView

        init {
            txtCant = itemView.findViewById(R.id.txtCantidad)
            txtDesc = itemView.findViewById(R.id.txtDesc)
            txtPVP = itemView.findViewById(R.id.txtPVP)
            txtSUbT = itemView.findViewById(R.id.txtSubTotalP)

            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()

                Snackbar.make(v, "Item Selecccionado $position",
                    Snackbar.LENGTH_LONG).setAction("Actción", null).show()
            }
        }
    }
}