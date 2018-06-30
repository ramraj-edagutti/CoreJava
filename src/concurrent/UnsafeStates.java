package concurrent;

public class UnsafeStates {

	private String[] states = new String[] {
			"Andhra Pradesh", "Telangana", "Delhi"
	};
	
	public String[] getStates() {
		return states;
	}
	
	public static void main(String[] args) {
		UnsafeStates us = new UnsafeStates();
		String[] states2 = us.getStates();
		for (String state : states2) {
		    System.out.print(state + " ");
		}
		System.out.println("");
		states2[1] = "Dummy";
		for (String state : us.getStates()) {
		    System.out.print(state + " ");
		}
	}
}
