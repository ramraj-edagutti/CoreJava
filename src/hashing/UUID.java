package hashing;

import java.net.InetAddress;
import java.util.StringTokenizer;

public class UUID {


	  private long time;
	  private short count;

	  private int unique;

	  private StringBuffer hostAddr = new StringBuffer();



	  /**
	   * In the absence of an actual pid, just do something somewhat
	   * random.
	   */
	  private static int getHostUniqueNum() {
	    return (new Object()).hashCode();
	  }

	  private static int hostUnique = getHostUniqueNum();
	  private static long lastTime = System.currentTimeMillis();
	  private static short lastCount = Short.MAX_VALUE - 2000;
	  private static Object mutex = new Object();
	  private static long  ONE_SECOND = 1000; // in milliseconds

	  public UUID ()
	  {

	    synchronized (mutex) {

	      if (lastCount == Short.MAX_VALUE) {
		     boolean done = false;
		     while (!done) {
		        time = System.currentTimeMillis();

		        if (time < lastTime+ONE_SECOND) {
		        // pause for a second to wait for time to change
		           try {
		             Thread.sleep(ONE_SECOND);
		           }
		           catch (java.lang.InterruptedException e) {

		           }	// ignore exception
		           continue;
		       }
			   else {
		         lastTime = time;
		         lastCount = Short.MAX_VALUE - 2000;
		         done = true;
		     }
		   }
	     }
	     else {
		    time = lastTime;
	     }
	      unique =  hostUnique;
		  if(unique < 0) unique *= -1;
	      count = lastCount++;
	    }



		try {
	      StringTokenizer st = new StringTokenizer(InetAddress.getLocalHost().getHostAddress(),".");
	      hostAddr.append(Integer.toHexString( new Integer(st.nextToken()).intValue()));
		  hostAddr.append(Integer.toHexString( new Integer(st.nextToken()).intValue()));
		  hostAddr.append(Integer.toHexString( new Integer(st.nextToken()).intValue()));
		  hostAddr.append(Integer.toHexString( new Integer(st.nextToken()).intValue()));

		}

		catch(Exception e){
			throw new RuntimeException("Error generatig unique id",e);

		}


	  }


	  public UUID(String in){


	     StringTokenizer st = new StringTokenizer(in,"[");
	     StringTokenizer st1 =
	           new StringTokenizer(st.nextToken(),"]");

		 StringTokenizer st2 =
							   new StringTokenizer(st1.nextToken(),":");

	     this.count = (short)Integer.parseInt(st2.nextToken(),16);
	     this.time = Long.parseLong(st2.nextToken(),16);
	     this.unique = Integer.parseInt(st2.nextToken(),16);
		 this.hostAddr.append(st2.nextToken());




	  }

	  @Override
	public int hashCode()
	  {
	    int hc = (int)time + count;
	    return (hc > 0 ? hc : (hc *= -1));
	  }

	  @Override
	public boolean equals(Object obj)
	  {

	      if ((obj != null) && (obj instanceof UUID)) {
		     UUID id = (UUID)obj;
	 	     return ( unique == id.unique &&
			     count == id.count &&
			     time == id.time &&
			     hostAddr.toString().equals(id.hostAddr.toString()));
	      }
	      else {
		     return false;
	      }
	  }

	  @Override
	public String toString()
	  {
	     return ("[" + Integer.toString(count,16) + ":" +
		         Long.toString(time,16) + ":" +
		         Integer.toString(unique,16) +":" +
	             hostAddr.toString() + "]");
	  }

	  public String toStringNoSeparator()
	  {
	     return (Integer.toString(count,16) +
		         Long.toString(time,16) +
		         Integer.toString(unique,16) +
	             hostAddr.toString());
	  }


}
