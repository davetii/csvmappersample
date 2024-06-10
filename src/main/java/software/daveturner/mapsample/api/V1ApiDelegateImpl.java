package software.daveturner.mapsample.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import software.daveturner.mapsample.model.ValueMapperResponse;
import software.daveturner.mapsample.model.ValuesMapperInput;
import software.daveturner.mapsample.service.MapService;


@RestController
public class V1ApiDelegateImpl implements  V1ApiDelegate {

    final MapService service;

    public V1ApiDelegateImpl(MapService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<ValueMapperResponse> postData(String notifyType, String deliveryType, String locale, ValuesMapperInput valuesMapperInput) {
        return ResponseEntity.ok(service.mapValues(notifyType, deliveryType, locale, valuesMapperInput));
    }
}
