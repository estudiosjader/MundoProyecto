package com.umariana.sistemas.mundoproyecto.datosAPI;

import com.umariana.sistemas.mundoproyecto.models.Familia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 22/05/17.
 */

public interface DatosOpenAPIService {

    @GET("tkus-wm8m.json")
    Call<List<Familia>> obtenerListaFamilias();
}
