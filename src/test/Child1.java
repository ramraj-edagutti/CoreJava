package test;

public class Child1 extends Parent {

	@Override
	public Parent getObject() {
		return new Child1();
	}
}
