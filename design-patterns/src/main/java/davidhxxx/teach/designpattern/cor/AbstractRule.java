package davidhxxx.teach.designpattern.cor;

public abstract class AbstractRule implements IRule {

    protected IRule nextRule;

    public void setNextRule(IRule nextRule) {
	this.nextRule = nextRule;
    }

    public boolean checkNextRule(Order order) {
	if (this.nextRule != null) {
	    return this.nextRule.apply(order);
	}

	return true;
    }

}
