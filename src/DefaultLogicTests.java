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
    public void testGetDefaultForPFM(){
        //setUp
        final Set<String> mockCurrentMarkets = new LinkedHashSet<>(Arrays.asList("US","UK","DE"));
        final Set<String> mockBetaMarkets = new LinkedHashSet<>(Arrays.asList("ES","IT"));
        final Set<String> mockTentativeMarkets = new LinkedHashSet<>(Arrays.asList("IN","JP","CA","AU","FR","IT","MX","CN","BR","NL"));
        mockDefaultingLogic.ultimateDefault = "US";
        mockDefaultingLogic.currentMarkets = mockCurrentMarkets;
        mockDefaultingLogic.betaMarkets = mockBetaMarkets;
        mockDefaultingLogic.tentativeMarkets = mockTentativeMarkets;
        mockDefaultingLogic.idme_mfg = "de_IN";
        String expectedDefault = "IN";
        //test
        mockDefaultingLogic.initializeArtifacts();
        String defaultR = mockDefaultingLogic.getDefaultForPFM("FR");
        //verify
        assertEquals(expectedDefault, defaultR);
    }
}
