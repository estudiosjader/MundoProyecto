package com.umariana.sistemas.mundoproyecto;

import android.os.Bundle;
import android.util.Log;

import com.umariana.sistemas.mundoproyecto.datosAPI.DatosOpenAPIService;
import com.umariana.sistemas.mundoproyecto.models.Familia;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    public final static String TAG = "OpenData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        FamiliasAdapter = new FamiliasAdapter(this);
        recyclerView.setAdapter(FamiliasAdapter);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            obtenerDatosFamilias();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        obtenerDatosFamilias();

    private void obtenerDatosFamilias(){

        DatosOpenAPIService service = retrofit.create(DatosOpenAPIService.class);
        Call<List<Familia>>CadenaRespuestaCall = service.obtenerListaFamilias();

            CadenaRespuestaCall.enqueue(new Callback<List<Familia>>() {
            @Override
            public void onResponse(Call<List<Familia>> call, Response<List<Familia>> response) {
                if (response.isSuccessful()) {
                    List lista = response.body();

                    for (int i = 0; i < lista.size(); i++) {
                        Familia p = (Familia) lista.get(i);
                        Log.i(TAG, " comunidad: " + p.getNombreDeLaComunidad()+ " Gobernador: " + p.getNombreDelGobenadorDelCabildo()+ " resguardo: " + p.getNombreDelResguardo());
                    }

                } else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Familia>> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });

    }


}
