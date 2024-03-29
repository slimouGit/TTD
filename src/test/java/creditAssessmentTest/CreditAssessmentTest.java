package creditAssessmentTest;

import creditAssessment.Balance;
import creditAssessment.CreditAssessment;
import creditAssessment.Dept;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreditAssessmentTest {

    //https://www.vogella.com/tutorials/Mockito/article.html
    @Test
    public void mockitoTest() {
        CreditAssessment test = mock(CreditAssessment.class);
        when(test.creditScreening(new Balance(500), new Dept(200))).thenReturn(CreditAssessment.AssistmentResult.CREDIT_WORTHINESS);
    }

    @Test
    public void checkCreditWorthiness() {
        assertEquals(new CreditAssessment().creditScreening(new Balance(500), new Dept(200)), CreditAssessment.AssistmentResult.CREDIT_WORTHINESS);
    }

    @Test
    public void checkCreditUnworthiness() {
        assertEquals(new CreditAssessment().creditScreening(new Balance(200), new Dept(500)), CreditAssessment.AssistmentResult.CREDIT_UNWORTHINESS);
    }
}
