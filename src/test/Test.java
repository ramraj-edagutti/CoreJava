package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		
		String sessionId = "h://staging1.x.co:8080/c/a/x:-:4d733bec08bbf;fbb80ceb337d49aa953f0fa3e634aa41";
		String lyraSessionId = "h://lyra01.x.lo/xi/a/x:-:4885041c48a8e;e8a84c1405884d9c94ea003e3d7e6563";
		
		int length = (int) Math.floor((77 - sessionId.toString().length()) / 2);
		if (length < 0) {
			length = (int) Math.floor((94 - sessionId.toString().length()) / 2);
		}
		System.out.println("Staging="+sessionId.length());
		System.out.println("Lyra = "+lyraSessionId.length());
		System.out.println("Length = "+length);
		
		String secureFinalLength = "0s://secure1.x.co:8080/c/a/x:-:4fcbac8c4f003;300f4c8cabcf494aa9941cad5ccc3a4e0000000000000000009";
		System.out.println("Secure finalLength="+secureFinalLength.length());
		
		String lyraFinalLength = "0s://lyra01.x.co:8080/c/a/x:-:4fcbac8c4f003;300f4c8cabcf494aa9941cad5ccc3a4e001";
		System.out.println("Lyra finalLength="+lyraFinalLength.length());
		
		String stagingFinalLength ="0s://staging01.x.co:8080/xi/a/x:-:4fcbac8c4f003;300f4c8cabcf494aa9941cad5ccc3a4e000000000000007";
		System.out.println("Staging FinalLength="+ stagingFinalLength.length());
		
	}
	
	
}