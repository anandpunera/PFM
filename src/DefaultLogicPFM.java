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

    public Map<String, List<String>> defaultLogicTable;
    public Set<String> mSetOfSupportedPFM;
    public Set<String> mSetOfBetaSupportedPFM;
    public Set<String> mSetOfTentativeSupportedPFM;
    public Map<String, String> mapOfDefaultingLogic;
    public String ultimateDefault;
    public String idme_mfg = "en_IN";
    public String currentLaunch;

    public static List<String> defaultAvailableForThisSet;// = new LinkedHashSet<>(Arrays.asList("US","UK","DE","IN","JP","CA","AU","FR","IT","ES","MX","CN","BR","NL"));
    public static Set<String> currentMarkets = new LinkedHashSet<>(Arrays.asList("UK","FR"));
    public static Set<String> betaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
    public static Set<String> tentativeMarkets = new LinkedHashSet<>(Arrays.asList("UK","DE","IN","JP","CA","AU","IT","MX","CN","BR","NL"));

    public List<String> getMarketsLaunchOrder() {
        return marketsLaunchOrder;
    }

    public List<String> marketsLaunchOrder;

    public Set<String> getmSetOfSupportedPFM() {
        return mSetOfSupportedPFM;
    }

    public Set<String> getmSetOfBetaSupportedPFM() {
        return mSetOfBetaSupportedPFM;
    }

    public Set<String> getmSetOfTentativeSupportedPFM() {
        return mSetOfTentativeSupportedPFM;
    }

    public Map<String, String> getMapOfDefaultingLogic() {
        return mapOfDefaultingLogic;
    }

    public Map<String, List<String>> getDefaultLogicTable() {
        return defaultLogicTable;
    }

    public DefaultLogicPFM() {
       initializeArtifacts();
    }

    public void initializeArtifacts() {
        JSONObject defaultJson;
        ultimateDefault = "US";
        mSetOfTentativeSupportedPFM = tentativeMarkets;
        mSetOfSupportedPFM = currentMarkets;
        mSetOfBetaSupportedPFM = betaMarkets;
        mapOfDefaultingLogic = new HashMap<String, String>();
        try {
            String text = new String(Files.readAllBytes(Paths.get("/home/local/ANT/punanand/PFM/src/res/logic.json")));
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
            throw new RuntimeException("Exception in reading defaults JSON", e);
        }
        updateSetOFSupportedPFM();
    }

    public String getDefaultForPFM(String pfm){
        if( mapOfDefaultingLogic.containsKey(pfm)) {
           return mapOfDefaultingLogic.get(pfm);
        }
        return ultimateDefault;
    }

    public void updateSetOFSupportedPFM() {
        String latestLaunchPFM = idme_mfg.split("_")[1];
        currentLaunch = latestLaunchPFM;
        mSetOfSupportedPFM.add(latestLaunchPFM);
        mSetOfTentativeSupportedPFM.remove(latestLaunchPFM);
        marketsLaunchOrder = new ArrayList<>();
        marketsLaunchOrder.addAll(mSetOfSupportedPFM);
        marketsLaunchOrder.addAll(mSetOfTentativeSupportedPFM);
        populateArtifacts();
    }

    public void populateArtifacts() {
        for (String pfm: marketsLaunchOrder) {
            int count =0;
            String pfmCurrent = pfm;
            if( mSetOfSupportedPFM.contains(pfm)){
                mapOfDefaultingLogic.put(pfmCurrent, pfm);
                continue;
            }
            else{
                while (true){

                    List<String> list= defaultLogicTable.get(pfm);
                    System.out.println(list+" "+count+ " "+pfm );
                    if(++count >= list.size()){
                        try {
                            throw new Exception(" Defaulting Logic is wrong.. No converging default PFM ");
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }

                    if(marketsLaunchOrder.indexOf(pfm) < list.size() && mSetOfSupportedPFM.contains(list.get(marketsLaunchOrder.indexOf(pfm)))){
                        mapOfDefaultingLogic.put(pfmCurrent, list.get(marketsLaunchOrder.indexOf(pfm)));
                        break;
                    }
                    else if(marketsLaunchOrder.indexOf(pfm) >= list.size() || count>0 || pfm == list.get(marketsLaunchOrder.indexOf(currentLaunch))){
                        //pfm = currentLaunch;
                        int index = list.indexOf(marketsLaunchOrder.indexOf(currentLaunch));
                        while(index >= 0 && mSetOfSupportedPFM.contains(list.get(index)) == false){
                            index--;
                        }
                        if(index < 0 ) {
                            mapOfDefaultingLogic.put(pfmCurrent, ultimateDefault);
                        }
                        else {
                            mapOfDefaultingLogic.put(pfmCurrent, list.get(index));
                        }
                        break;
                    }
                    else {
                        continue;
                    }
                }
            }
        }
    }
}