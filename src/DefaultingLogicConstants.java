import java.util.*;

final public class DefaultingLogicConstants {
    public static final List<String> launchesOrder = new ArrayList<String>(Arrays.asList("US","UK","DE","IN","JP","CA","AU","FR","IT","ES","MX","CN","BR"));
    public static final Set<String> currentMarkets = new LinkedHashSet<>(Arrays.asList("US","CN","ES","UK"));
    public static final Set<String> betaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
    public static final Set<String> tentativeMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT","JP","CA"));
}
