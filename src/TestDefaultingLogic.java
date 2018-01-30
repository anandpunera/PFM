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
        defaultLogicPFM.populateArtifacts();
        System.out.println(defaultLogicPFM.getmSetOfSupportedPFM());
        System.out.println(defaultLogicPFM.getMapOfDefaultingLogic());
    }
}


