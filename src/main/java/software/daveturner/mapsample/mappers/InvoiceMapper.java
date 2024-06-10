package software.daveturner.mapsample.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import software.daveturner.mapsample.model.ValueMapperResponse;
import software.daveturner.mapsample.model.ValuesMapperInput;

public class InvoiceMapper implements FuncMapper {

    public ValueMapperResponse map(ValueMapperResponse response, ValuesMapperInput input) {
        response.setBody("I am the body of the invoice");
        return response;
    }
}
