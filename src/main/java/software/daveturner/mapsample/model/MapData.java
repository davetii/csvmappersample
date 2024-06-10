package software.daveturner.mapsample.model;

import lombok.Data;
import software.daveturner.mapsample.mappers.FuncMapper;

import static software.daveturner.mapsample.mappers.FuncMapperFactory.*;

@Data
public class MapData {

    private String notifyType;
    private String deliveryType;
    private String language;
    private String country;
    private String supportEmail;
    private String subjectLine;
    private String mapFunc;

    public ValueMapperResponse toResponse(ValuesMapperInput input) {
        ValueMapperResponse r = new ValueMapperResponse();
        r.setDeliveryType(this.deliveryType);
        r.setNotifyType(this.notifyType);
        r.setCountry(this.country);
        r.setLanguage(this.language);
        r.setSupportEmail(this.supportEmail);
        r.setSubject(this.subjectLine);
        r.setTarget(input.getTarget());

        FuncMapper mapper = getMapper(this.mapFunc);
        r = mapper.map(r, input);
        return r;
    }


}
