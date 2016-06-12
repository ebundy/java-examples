package davidhxxx.teach.designpattern.cor.common;

public abstract class AbstractRule implements IRule {

    protected IRule nextRule;

    public void setNextRule(IRule nextRule) {
	this.nextRule = nextRule;
    }

    public boolean applyNextRuleIfExist(InputForDiscountRules inputDataForDiscountRules) {
	if (this.nextRule != null) {
	    return this.nextRule.apply(inputDataForDiscountRules);
	}

	return false;
    }

}
