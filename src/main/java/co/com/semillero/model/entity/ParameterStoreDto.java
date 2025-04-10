package co.com.semillero.model.entity;

import co.com.semillero.util.ParameterStoreUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class ParameterStoreDto {

    String urlDynamo;
    String region;
    String tabla;
    String arnSecret;

}
