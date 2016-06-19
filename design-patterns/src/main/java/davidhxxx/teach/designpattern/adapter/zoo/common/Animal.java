package davidhxxx.teach.designpattern.adapter.zoo.common;

public abstract class Animal {

    public abstract boolean isHerbivor();

    private int hungryLevel;

    public void feed() {
	if (hungryLevel > 0) {
	    hungryLevel--;
	}
    }

    public boolean isFreeable() {
	return false;
    }

}
