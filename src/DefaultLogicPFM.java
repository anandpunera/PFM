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

    private static Map<String, List<String>> defaultLogicTable;
    private static Set<String> mSetOfSupportedPFM;
    private static Set<String> mSetOfBetaSupportedPFM;
    private static Set<String> mSetOfTentativeSupportedPFM;
    private static Map<String, String> mapOfDefaultingLogic;
    private static List<String> marketsLaunchOrder;

    public static Set<String> getmSetOfSupportedPFM() {
        return mSetOfSupportedPFM;
    }

    public static Set<String> getmSetOfBetaSupportedPFM() {
        return mSetOfBetaSupportedPFM;
    }

    public static Set<String> getmSetOfTentativeSupportedPFM() {
        return mSetOfTentativeSupportedPFM;
    }

    public static Map<String, String> getMapOfDefaultingLogic() {
        return mapOfDefaultingLogic;
    }

    public static Map<String, List<String>> getDefaultLogicTable() {
        return defaultLogicTable;
    }

    public DefaultLogicPFM() {
        JSONObject defaultJson;
        mSetOfTentativeSupportedPFM = DefaultingLogicConstants.tentativeMarkets;
        mSetOfSupportedPFM = DefaultingLogicConstants.currentMarkets;
        marketsLaunchOrder = DefaultingLogicConstants.launchesOrder;
        mSetOfBetaSupportedPFM = DefaultingLogicConstants.betaMarkets;
        mapOfDefaultingLogic = new HashMap<>();
        try {
            String text = new String(Files.readAllBytes(Paths.get("/home/local/ANT/punanand/DefaultingLogic/src/res/logic.json")));
            defaultJson = new JSONObject(text);
            Iterator<String> keys = defaultJson.keys();
            defaultLogicTable = new LinkedHashMap<>();
            while (keys.hasNext()){
                List<String> list = new ArrayList<>();
                String key = keys.next();
                JSONArray jsonArray = defaultJson.getJSONArray(key);
                for( int i=0; i<jsonArray.length();i++){
                    list.add(jsonArray.getString(i));
                }
                defaultLogicTable.put(key,list);
            }
        } catch (JSONException | IOException e) {
            throw new RuntimeException("Exception in reading defaults JSON", e); }
    }

    public void populateArtifacts() {
        for (String pfm: marketsLaunchOrder) {
            int count =0;
            String pfmCurrent = pfm;
            if( mSetOfSupportedPFM.contains(pfm)){
                //System.out.println(pfmCurrent+ " defaults to "+ pfm);
                continue;
            }
            else{
                while (true){
                    if(++count >= defaultLogicTable.size()){
                        try {
                            throw new Exception(" Defaulting Logic is wrong");
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    List<String> list= defaultLogicTable.get(pfm);
                    if(count ==0 && marketsLaunchOrder.contains(pfm) == false){
                        try {
                            throw new Exception("Something wrong with this pfm "+ pfm);
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    else if(mSetOfSupportedPFM.contains(list.get(marketsLaunchOrder.indexOf(pfm)))){
                        mapOfDefaultingLogic.put(pfmCurrent, list.get(marketsLaunchOrder.indexOf(pfm)));
                        //System.out.println(pfmCurrent+" defaults to "+ list.get(marketsLaunchOrder.indexOf(pfm)));
                        break;
                    }
                    else if(count>0 || pfm == list.get(marketsLaunchOrder.indexOf(pfm))){
                        int index = marketsLaunchOrder.indexOf(pfm);
                        while(index >=0 && mSetOfSupportedPFM.contains(list.get(index)) == false){
                            index--;
                        }
                        //System.out.println(pfmCurrent+" defaults to "+list.get(index));
                        mapOfDefaultingLogic.put(pfmCurrent, list.get(index));
                        break;
                    }
                    else {
                        pfm = list.get(marketsLaunchOrder.indexOf(pfm));
                        continue;
                    }
                }
            }
        }
    }
}