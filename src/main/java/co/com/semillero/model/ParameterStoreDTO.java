package co.com.semillero.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterStoreDTO {
    String urlDynamo;
    String region;
    String arnSecre;
    String table;
}
