package davidhxxx.teach.designpattern.singleton;

public class SingletonBillPughWithLazyCreation {

    // Class responsible to create, store and get the singleton
    private static class LazyHolder {
	// executed only after the object instance is used by SingletonBillPughWithLazyCreation.getInstance()
	private static SingletonBillPughWithLazyCreation instance = new SingletonBillPughWithLazyCreation();
    }

    private SingletonBillPughWithLazyCreation() {
    }

    public static SingletonBillPughWithLazyCreation getInstance() {
	return LazyHolder.instance;
    }
}
