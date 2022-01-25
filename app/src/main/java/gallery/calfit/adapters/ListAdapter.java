package gallery.calfit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.calfit.galeriaimagenes.R;

import java.util.List;

import gallery.calfit.models.ListElement;

//LIST ELEMENT --> LIST ADAPTER --> RECYCLERV1

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;
    final ListAdapter.OnitemClickListener listener;

    public interface OnitemClickListener {
        void onItemClick(ListElement item);
    }

    public ListAdapter(List<ListElement> itemList, Context context, ListAdapter.OnitemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount() { return mData.size(); }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement> items) { mData = items; }

    //name = name nombre de la receta
    //city = tipocomida "tipo de receta, preentreno o post por ej
    //status = dificultad

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage,iconImageView2;
        TextView name, tipocomida, dificultad, ingredientes, preparacion;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            tipocomida = itemView.findViewById(R.id.cityTextView);
            dificultad = itemView.findViewById(R.id.statusTextView);
            iconImageView2 = itemView.findViewById(R.id.iconImageView2);
            ingredientes = itemView.findViewById(R.id.ingredientesDescriptionTextView);
            preparacion = itemView.findViewById(R.id.preparacionDescriptionTextView);
        }

        void bindData(final ListElement item) {
            iconImage.setImageResource(item.getIcono());
            name.setText(item.getName());
            tipocomida.setText(item.getTipocomida());
            dificultad.setText(item.getDificultad());
            iconImageView2.setImageResource(item.getIconoI());
            ingredientes.setText(item.getIngredientes());
            preparacion.setText(item.getPreparacion());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    }
