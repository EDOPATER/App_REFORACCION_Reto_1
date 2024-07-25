package com.edopater.app_reforaccion_reto_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class RedesSocialesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPosts;
    private PostAdapter postAdapter;
    private List<Post> postList;
    private ProgressBar progressBar;
    private FloatingActionButton fabAddPost;
    private Button A_Panel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociales);

        A_Panel = findViewById(R.id.buttonVolverPanel);

        recyclerViewPosts = findViewById(R.id.recyclerViewPosts);
        progressBar = findViewById(R.id.progressBar);
        fabAddPost = findViewById(R.id.fabAddPost);

        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(postList);
        recyclerViewPosts.setAdapter(postAdapter);
        // Dummy data for illustration
        loadPosts();

        A_Panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent back = new Intent(RedesSocialesActivity.this, PanelControlActivity.class);
                startActivity(back);
            }
            });

        fabAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Añadir un nuevo post
            }
     });

    }

    private void loadPosts() {
        progressBar.setVisibility(View.VISIBLE);
        // Simular la carga de posts (reemplazar con carga real de datos)
        postList.add(new Post("John Doe", "Hace 2 horas", "¡Acabo de plantar un nuevo árbol!"));
        postList.add(new Post("Jane Smith", "Hace 3 horas", "Participé en un evento de plantación de árboles."));
        postList.add(new Post("Lana Stanford", "Hace 5 horas", "Realicé compra de insumos para la plantación."));
        postList.add(new Post("Stanly Idkins", "Hace 6 horas", "Compartí el avance de la plantación."));
        postAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }

}
