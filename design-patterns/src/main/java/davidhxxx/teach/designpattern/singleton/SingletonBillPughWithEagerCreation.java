package davidhxxx.teach.designpattern.singleton;

public class SingletonBillPughWithEagerCreation {

	// executed as soon as he SingletonBillPughWithEagerCreation class is loaded by the classLoader
	private static SingletonBillPughWithEagerCreation instance = new SingletonBillPughWithEagerCreation();

	private SingletonBillPughWithEagerCreation() {
	}

	public static SingletonBillPughWithEagerCreation getInstance() {
		return instance;
	}
}
