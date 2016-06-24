package exercices.day8.unit_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.models.CaseDesign;
import exercices.day6.dependency_injection.models.CaseDevice;
import exercices.day6.dependency_injection.models.Provider;

import static org.hamcrest.CoreMatchers.*;

public class CaseTest {

	@Mock
	CaseDesign caseDesignMock;
	
	@Mock
	CaseDevice caseDeviceMock;
	
	@Mock
	Provider providerMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new Case(null,caseDeviceMock,10.0,providerMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new Case(caseDesignMock,null,10.0,providerMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new Case(caseDesignMock,caseDeviceMock,null,providerMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new Case(caseDesignMock,caseDeviceMock,10.0,null);
	}
	
	@Test
	public void testCreation() {
		Case test = new Case(caseDesignMock,caseDeviceMock,10.0,providerMock);
		assertThat("Case Design wasnt correctly assigned",test.getDesign(),is(caseDesignMock));
		assertThat("Case Device wasnt correctly assigned",test.getDevice(),is(caseDeviceMock));
		assertThat("Provider wasnt correctly assigned",test.getProvider(),is(providerMock));
		assertThat("Price wasnt correctly assigned",test.getPrice(),is(10.0));
	}
	
	@Test
	public void testToString(){
		Case test = new Case(caseDesignMock,caseDeviceMock,10.0,providerMock);
		assertThat("To String method doesnt work as expected",test.toString(),equalTo("Design: "+caseDesignMock.getName()+
				", Device: "+caseDeviceMock.getName()+", Provider: "+providerMock.getName()+"("+providerMock.getLocation()+")"));
	}

}
