package davidhxxx.teach.designpattern.cor.improved.common;

public abstract class AbstractRule implements IRule {

    protected IRule nextRule;

    public void setNextRule(IRule nextRule) {
	this.nextRule = nextRule;
    }

    public final boolean applyChain(InputForDiscountRules inputDataForDiscountRules) {
	if (apply(inputDataForDiscountRules)) {
	    return true;
	}

	return applyNextRuleIfExist(inputDataForDiscountRules);
    }

    private boolean applyNextRuleIfExist(InputForDiscountRules inputDataForDiscountRules) {
	if (this.nextRule != null) {
	    return this.nextRule.applyChain(inputDataForDiscountRules);
	}
	return false;
    }

}
