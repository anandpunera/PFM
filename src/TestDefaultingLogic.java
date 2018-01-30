import java.util.*;

public class TestDefaultingLogic {

    private static Map<String, List<String>> tableOfDefaultLogic;
    private static DefaultLogicPFM defaultLogicPFM;

    public static void main(String[] args) {
        defaultLogicPFM = new DefaultLogicPFM();
        tableOfDefaultLogic = defaultLogicPFM.getDefaultLogicTable();
        testDefaultingLogic();
    }

    private static void testDefaultingLogic() {
        //displayAllArtifacts();
        System.out.println(" defaults "+ defaultLogicPFM.getDefaultForPFM("IT"));
    }

    private static void displayAllArtifacts(){
        System.out.println(" Supported PFMs " + defaultLogicPFM.getmSetOfSupportedPFM());
        System.out.println(" Defaulting Logic " + defaultLogicPFM.getMapOfDefaultingLogic());
        System.out.println(" Launch Order " + defaultLogicPFM.getMarketsLaunchOrder());
        System.out.println(" Beta : " + defaultLogicPFM.getmSetOfBetaSupportedPFM());
        System.out.println(" Tenative supportable : " + defaultLogicPFM.getmSetOfTentativeSupportedPFM());
    }
}


