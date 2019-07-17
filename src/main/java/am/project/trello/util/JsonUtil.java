package am.project.trello.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    public static String serialize(Object object){
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.warn("Serialization error :");
        }
        return "";
    }

    public static <T> T deserialize(String value, TypeReference<T> type) throws IOException {
        return OBJECT_MAPPER.readValue(value,type);
    }

}
