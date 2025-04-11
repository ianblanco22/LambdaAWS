package co.com.semillero.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class EnrollmentRq {
    @SerializedName ("nombre")
    private String nombre;
    @SerializedName ("apellido")
    private String apellido;
    @SerializedName ("numeroDocumento")
    private String numeroDocumento;
    @SerializedName ("tipoDocumento")
    private String tipoDocumento;

}
