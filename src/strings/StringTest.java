package strings;

public class StringTest {
    public static void main(String[] args) {
    	String sql = "select distinct period_id, trans_id from xc_tracking "+
	             " unpivot (period_id for period_type in (\"PERIOD_ID\",\"CREDIT_PERIOD_ID\",\"COMM_PERIOD_ID\",\"BONUS_PERIOD_ID\",\"PAYMENT_PERIOD_ID\"))" +
	             " where business_id = :businessId and queue_event_id = :queueEventId";
    	System.out.println(sql);
	}
}
