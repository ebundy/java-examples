package davidhxxx.teach.designpattern.singleton;

// systematic synchronization when accessing 
public class SingletonCostly {

	private static SingletonCostly instance;

	private SingletonCostly() {
	}

	public static synchronized SingletonCostly getInstance() {
		if (instance == null) {
			instance = new SingletonCostly();
		}
		return instance;
	}
}
