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
    public void testGetDefaultPFM_With_US_As_UltimateDefault(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","DE"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "de_FR";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Mohit1(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","DE"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "de_FR";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Tarak1(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","DE"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","FR"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "en_IN";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Tarak2(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","DE"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","FR"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "en_FR";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Mohit2(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("IN"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.ultimateDefault="IN";
        mockDefaultingLogic.idme_mfg = "en_IN";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Tirth1(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("UK","DE","IN"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IT","ES"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_IT";
        mockDefaultingLogic.ultimateDefault="UK";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Tirth2(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","UK","CA"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("JP"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_IT";
        mockDefaultingLogic.ultimateDefault="US";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Mohit3(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","UK","CA"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("JP"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_JP";
        mockDefaultingLogic.ultimateDefault="US";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Tirth3(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("IN","CA"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("JP","IT","ES"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("JP"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_JP";
        mockDefaultingLogic.ultimateDefault="IN";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("IN", mockDefaultingLogic.getDefaultForPFM("US"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Failure(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","JP"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("JP","IT","ES"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","IT"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_IN";
        mockDefaultingLogic.ultimateDefault="US";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("JP", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Tirth4(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","DE"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("IT","ES"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IT","ES"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_ES";
        mockDefaultingLogic.ultimateDefault="US";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_Failure2(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","UK"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("JP","IT","ES"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","IT"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_IN";
        mockDefaultingLogic.ultimateDefault="US";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_CircularDependency(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("UK","IT"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("JP","CA"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("JP","CA"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_CA";
        mockDefaultingLogic.ultimateDefault="UK";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_US_As_UltimateDefault_CircularDependency2(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("IT"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("JP","CA"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("JP","CA"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "it_CA";
        mockDefaultingLogic.ultimateDefault="UK";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify

        assertEquals("CA", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        //assertEquals("DE", mockDefaultingLogic.getDefaultForPFM("DE"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("IN"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("JP"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CA"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("AU"));
        //assertEquals("FR", mockDefaultingLogic.getDefaultForPFM("FR"));
        //assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("MX"));
        //assertEquals("US", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_UK_As_UltimateDefault(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("UK"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","JP","CA","AU","FR","IT","MX","CN","BR","NL"));
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "de_CN";
        //test
        mockDefaultingLogic.initializeArtifacts();
        //verify
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("US"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("UK"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("DE"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IN"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("JP"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("CA"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("AU"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("FR"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("IT"));
        assertEquals("UK", mockDefaultingLogic.getDefaultForPFM("MX"));
        assertEquals("CN", mockDefaultingLogic.getDefaultForPFM("CN"));
    }

    @Test
    public void testGetDefaultPFM_With_DE_AS_UltimateDefault(){
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
    public void testGetDefaultPFM_First_Launch_India(){
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
