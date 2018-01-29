import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;

public class DefaultLogicPFM {

    private static Map<String, List<String>> defaultLogicMap;

    public static Map<String, List<String>> getDefaultLogicMap() {
        return defaultLogicMap;
    }

    public DefaultLogicPFM() {
        JSONObject defaultJson;

        try {
            String text = new String(Files.readAllBytes(Paths.get("/home/local/ANT/punanand/DefaultLogic/src/main/logic.json")));
            defaultJson = new JSONObject(text);
            Iterator<String> keys = defaultJson.keys();
            defaultLogicMap = new LinkedHashMap<>();
            while (keys.hasNext()){
                List<String> list = new ArrayList<>();
                String key = keys.next();
                JSONArray jsonArray = defaultJson.getJSONArray(key);
                for( int i=0; i<jsonArray.length();i++){
                    list.add(jsonArray.getString(i));
                }
                defaultLogicMap.put(key,list);
            }
        } catch (JSONException | IOException e) {
            throw new RuntimeException("Exception in reading defaults JSON", e); }
    }
}