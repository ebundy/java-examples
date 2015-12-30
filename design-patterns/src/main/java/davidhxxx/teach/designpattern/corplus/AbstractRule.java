package davidhxxx.teach.designpattern.corplus;

public abstract class AbstractRule implements IRule {

    protected IRule nextRule;

    public abstract boolean applySpecific(Order order);

    public void setNextRule(IRule nextRule) {
	this.nextRule = nextRule;
    }

    public boolean checkNextRule(Order order) {
	if (this.nextRule != null) {
	    return this.nextRule.apply(order);
	}

	return true;
    }

    public boolean apply(Order order) {
	if (applySpecific(order)) {
	    return true;
	}
	return checkNextRule(order);

    }

}
