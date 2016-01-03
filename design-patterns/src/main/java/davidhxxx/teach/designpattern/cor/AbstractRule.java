package davidhxxx.teach.designpattern.cor;

public abstract class AbstractRule implements IRule {

    protected IRule nextRule;

    public void setNextRule(IRule nextRule) {
	this.nextRule = nextRule;
    }

    public boolean checkNextRule(InputForDiscountRules inputDataForDiscountRules) {
	if (this.nextRule != null) {
	    return this.nextRule.apply(inputDataForDiscountRules);
	}

	return true;
    }

}
