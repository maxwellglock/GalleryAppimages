package gallery.calfit.galeriaimagenes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calfit.galeriaimagenes.R;

import java.util.ArrayList;
import java.util.List;

import gallery.calfit.adapters.ListAdapter;
import gallery.calfit.models.ListElement;

public class Recyclerv1 extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerv1);

        init();
    }

    //luego agregar también la linea de la imagen


    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement(R.drawable.background3gridview1, "Batido Proteico", "Post-Entreno", "Fácil", "2 taza avena + ½ taza azúcar +¾ taza H avena + Cucharada chía remojada +¼ taza coco + Pizca de canela + Media taza de jugo de naranja + También le puse chocolate picado, pero eso es a elección", "mezclar todos los ingredientes y haces bolitas. poner en una placa ligeramente aceitada y llevar a horno medio(180°) hasta que se doren .", R.drawable.background5));
        elements.add(new ListElement(R.drawable.background5,"Rizzoto", "Almuerzo/Cena", "Media", "2 taza avena + ½ taza azúcar +¾ taza H avena + Cucharada chía remojada +¼ taza coco + Pizca de canela + Media taza de jugo de naranja + También le puse chocolate picado, pero eso es a elección", "mezclar todos los ingredientes y haces bolitas. poner en una placa ligeramente aceitada y llevar a horno medio(180°) hasta que se doren .", R.drawable.background5));
        elements.add(new ListElement(R.drawable.background5, "Browl de quinóa", "Vegan", "Media", "2 taza avena + ½ taza azúcar +¾ taza H avena + Cucharada chía remojada +¼ taza coco + Pizca de canela + Media taza de jugo de naranja + También le puse chocolate picado, pero eso es a elección", "mezclar todos los ingredientes y haces bolitas. poner en una placa ligeramente aceitada y llevar a horno medio(180°) hasta que se doren .", R.drawable.background5));

        ListAdapter ListAdapter = new ListAdapter(elements, this, new ListAdapter.OnitemClickListener() {

            @Override
                    public void onItemClick(ListElement item) {
                moveToDescription(item);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(ListAdapter);
    }

    public void moveToDescription(ListElement item) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListElement", item);
        startActivity(intent);
    }


}
