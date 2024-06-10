package software.daveturner.mapsample.service;

import org.springframework.stereotype.Service;
import software.daveturner.mapsample.model.ValueMapperResponse;
import software.daveturner.mapsample.model.ValuesMapperInput;

public interface MapService {

    public ValueMapperResponse mapValues(String notifyType, String deliveryType, String locale, ValuesMapperInput input);
}
