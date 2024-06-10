package software.daveturner.mapsample.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import software.daveturner.mapsample.model.MapData;
import software.daveturner.mapsample.model.ValueMapperResponse;
import software.daveturner.mapsample.model.ValuesMapperInput;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static software.daveturner.mapsample.model.MapFields.*;

@Service
public class MapServiceImpl implements MapService {

    private Map<String, MapData> map = new <String, MapData>HashMap();

    @PostConstruct
    private void postConstruct () throws IOException, URISyntaxException {
        Path filePath = Paths.get(ClassLoader.getSystemResource("values.csv").toURI());
        Charset charset = StandardCharsets.UTF_8;
        List<String> lines = Files.readAllLines(filePath, charset);

        lines.forEach(s -> {
            String[] items = s.split(",");
            if (items.length != 8) {
                throw new RuntimeException("Values map is incorrect fix this and restart the app");
            }

            MapData mapData = new MapData();
            mapData.setNotifyType(items[NOTIFY_TYPE.value()]);
            mapData.setDeliveryType(items[DELIVERY_TYPE.value()]);
            mapData.setLanguage(items[LANG.value()].toLowerCase(Locale.ROOT));
            mapData.setCountry(items[COUNTRYCODE.value()].toUpperCase(Locale.ROOT));
            mapData.setSupportEmail(items[EMAIL_SUPPORT.value()]);
            mapData.setSubjectLine(items[SUBJECT_LINE.value()]);
            mapData.setMapFunc(items[MAPFUNC.value()]);
            map.put(items[0] + items[1] + items[2], mapData);
        });
    }

    @Override
    public ValueMapperResponse mapValues(String notif, String delivery, String locale, ValuesMapperInput input) {
        if(map.containsKey(notif + delivery + locale)) {
            // happy path
            MapData mapData = map.get(notif + delivery + locale);
            ValueMapperResponse response = mapData.toResponse(input);
            return response;
        } else {
            // handle error
            System.out.println("hes null");
            return null;
        }
    }
}
