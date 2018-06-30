package datetime;

import java.util.Calendar;

public class TimeAgo {
	private static final int SECOND_MILLIS = 1000;
	private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
	private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
	private static final int DAY_MILLIS = 24 * HOUR_MILLIS;


	public static String getTimeAgo(long time) {
	    
	    long now = Calendar.getInstance().getTimeInMillis();
	    if (time > now || time <= 0) {
	        return null;
	    }

	    final long diff = now - time;
	    if (diff < MINUTE_MILLIS) {
	        return diff/SECOND_MILLIS +" seconds ago";
	    } else if (diff < 60 * MINUTE_MILLIS) {
	        return diff / MINUTE_MILLIS + " minutes ago";
	    } else if (diff < 24 * HOUR_MILLIS) {
	        return diff / HOUR_MILLIS + " hours ago";
	    } else {
	        return diff / DAY_MILLIS + " days ago";
	    }
	}
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 11, 22, 17, 11, 0);
		System.out.println(getTimeAgo(cal.getTimeInMillis()));
	}
}
