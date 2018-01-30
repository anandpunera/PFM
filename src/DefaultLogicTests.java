import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


public class DefaultLogicTests {

    private DefaultLogicPFM mockDefaultingLogic = new DefaultLogicPFM();

    @Test
    public void testGetDefaultForPFMWithUSUltimateDefault(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","UK","DE"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","JP","CA","AU","FR","IT","MX","CN","BR","NL"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "de_FR";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("US"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultForPFMWithUKUltimateDefault(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","UK"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","JP","CA","AU","FR","IT","MX","CN","BR","NL"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "de_CN";
        String expectedDefault = "US";
        //test
        mockDefaultingLogic.initializeArtifacts();
        String defaultR = mockDefaultingLogic.getDefaultForPFM("IN");
        //verify
        assertEquals(expectedDefault, defaultR);
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("US"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("DE"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("FR"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        assertEquals("CN", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultForPFMWithDEASUltimateDefault(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("DE"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","JP","CA","AU","FR","IT","MX","CN","BR","NL"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "de_IN";
        String expectedDefault = "IN";
        //test
        mockDefaultingLogic.initializeArtifacts();
        String defaultR = mockDefaultingLogic.getDefaultForPFM("IN");
        //verify
        assertEquals(expectedDefault, defaultR);
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("US"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("UK"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("IN"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("JP"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("CA"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("AU"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("FR"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("IT"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("MX"));
        assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultForPFMForFirstPFMLaunchIN(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList(""));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","JP","CA","AU","FR","IT","MX","CN","BR","NL"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "de_IN";
        String expectedDefault = "IN";
        //test
        mockDefaultingLogic.initializeArtifacts();
        String defaultR = mockDefaultingLogic.getDefaultForPFM("IN");
        //verify
        assertEquals(expectedDefault, defaultR);
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("US"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("UK"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("DE"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("IN"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("JP"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("CA"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("AU"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("FR"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("IT"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("MX"));
        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("CN"));
    }
}
