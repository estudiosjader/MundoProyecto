package com.umariana.sistemas.mundoproyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.umariana.sistemas.mundoproyecto.models.Familia;

import java.util.ArrayList;

/**
 * Created by Camilo on 5/6/2017.
 */

public class FamiliasAdapter extends RecyclerView.Adapter<FamiliasAdapter.ViewHolder> {
    private ArrayList<Familia> dataset;

    private Context context;

    public FamiliasAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_familia, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Familia a = dataset.get(position);
        holder.nombreDelResguardo.setText(a.getNombreDelResguardo());
        holder.nombreDelGobenadorDelCabildo.setText(a.getNombreDelGobenadorDelCabildo().toString());
        holder.puebloIndGena.setText(a.getPuebloIndGena().toString());
        holder.inspeccionCorregimientoMunicipio.setText(a.getInspeccionCorregimientoMunicipio().toString());
        holder.nombreDeLaComunidad.setText(a.getNombreDeLaComunidad().toString());


    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void adicionarListaFamilia(ArrayList<Familia> listaAuto) {
        dataset.addAll(listaAuto);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView nombreDelResguardo;
        private TextView nombreDelGobenadorDelCabildo;
        private TextView puebloIndGena;
        private TextView inspeccionCorregimientoMunicipio;
        private TextView nombreDeLaComunidad;


        public ViewHolder(View itemView) {
            super(itemView);


            nombreDelResguardo = (TextView) itemView.findViewById(R.id.nombreDelResguardo);
            nombreDelGobenadorDelCabildo= (TextView) itemView.findViewById(R.id.nombreDelGobenadorDelCabildo);
            puebloIndGena=(TextView) itemView.findViewById(R.id.puebloIndGena);
            inspeccionCorregimientoMunicipio=(TextView) itemView.findViewById(R.id.inspeccionCorregimientoMunicipio);
            nombreDeLaComunidad=(TextView) itemView.findViewById(R.id.nombreDeLaComunidad);

        }
    }
}
