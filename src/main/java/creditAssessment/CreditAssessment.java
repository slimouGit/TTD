package creditAssessment;

public class CreditAssessment {

    public enum AssistmentResult {
        CREDIT_WORTHINESS, CREDIT_UNWORTHINESS
    }


    public AssistmentResult creditScreening(Balance balance, Dept dept){
        return (balance.getAmount()-dept.getAmount()>0)?AssistmentResult.CREDIT_WORTHINESS:AssistmentResult.CREDIT_UNWORTHINESS;
    }

    public static void main(String[] args){
        CreditAssessment creditAssessment = new CreditAssessment();
        System.out.println(creditAssessment.creditScreening(new Balance(500), new Dept(200)));
    }

}
