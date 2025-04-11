package co.com.semillero.model;

//import org.checkerframework.checker.units.qual.s;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String celular;
    protected String correo;
    protected String nuemroDocumento;
    protected String tipoDocumento;
    protected String ciudad;
    protected String direccion;
}
