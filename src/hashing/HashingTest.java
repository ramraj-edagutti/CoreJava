package hashing;

import java.util.UUID;

public class HashingTest {

	public static void main(String[] args) {
		//TODO: see how java.util.UUId.java versus hashing.UUID.java works?
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
	}
}
