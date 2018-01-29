import java.util.*;

public class TestDefaultingLogic {
    static Map<String, List<String>> mapOfDefaultLogic;
    public static void main(String[] args) {

        mapOfDefaultLogic = new DefaultLogicPFM().getDefaultLogicMap();
        testDefaultingLogic();
    }

    private static void testDefaultingLogic(){
        List<String> marketsLaunchOrder;
        List<String> currentMarkets;
        marketsLaunchOrder = DefaultingLogicConstants.launchesOrder;
        currentMarkets = DefaultingLogicConstants.currentMarkets;
        displayCurrentDefaultsForEachSupportedPFM(marketsLaunchOrder, currentMarkets);
    }

    private static void displayCurrentDefaultsForEachSupportedPFM(List<String> marketsLaunchOrder, List<String> currentMarkets) {
        System.out.println(" marketsLaunchOrder : "+marketsLaunchOrder);
        for (String pfm: marketsLaunchOrder) {
            int count =0;
            String pfmCurrent = pfm;
//            System.out.println(" looking for pfm : "+pfm);
            if( currentMarkets.contains(pfm)){
                System.out.println(pfmCurrent+ " defaults to "+ pfm);
                continue;
            }
            else{
                while (true){
                    if(++count >= mapOfDefaultLogic.size()){
                        try {
                            throw new Exception(" Defaulting Logic is wrong");
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    List<String> list= mapOfDefaultLogic.get(pfm);
//                    System.out.println(" list : "+list);
                    if(count ==0 && marketsLaunchOrder.contains(pfm) == false){
                        try {
                            throw new Exception("Something wrong with this pfm "+ pfm);
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    else if(currentMarkets.contains(list.get(marketsLaunchOrder.indexOf(pfm)))){
                        System.out.println(pfmCurrent+" defaults to "+ list.get(marketsLaunchOrder.indexOf(pfm)));
                        break;
                    }
                    else if(count>0 || pfm == list.get(marketsLaunchOrder.indexOf(pfm))){
                        int index = marketsLaunchOrder.indexOf(pfm);
                        while(index >=0 && currentMarkets.contains(list.get(index)) == false){
                            index--;
                        }
                        System.out.println(pfmCurrent+" defaults to "+list.get(index));
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


