package gallery.calfit.galeriaimagenes;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.calfit.galeriaimagenes.R;

import gallery.calfit.models.ListElement;

public class DescriptionActivity extends AppCompatActivity {


    TextView tittleDescriptionTextView;
    TextView ingredientesDescriptionTextView;
    TextView preparacionDescriptionTextView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        //luego agregar también la linea de la imagen

        ListElement element = (ListElement) getIntent().getSerializableExtra("ListElement");
        tittleDescriptionTextView = findViewById(R.id.tittleDescriptionTextView);
        ingredientesDescriptionTextView = findViewById(R.id.ingredientesDescriptionTextView);
        preparacionDescriptionTextView = findViewById(R.id.preparacionDescriptionTextView);

        tittleDescriptionTextView.setText(element.getName());

        ingredientesDescriptionTextView.setText(element.getIngredientes());

        preparacionDescriptionTextView.setText(element.getPreparacion());

        preparacionDescriptionTextView.setTextColor(Color.GRAY);



    }
}