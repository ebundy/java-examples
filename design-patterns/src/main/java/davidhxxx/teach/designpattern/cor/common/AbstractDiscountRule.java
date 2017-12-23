package davidhxxx.teach.designpattern.cor.common;

public abstract class AbstractDiscountRule implements IDiscountRule {

	protected IDiscountRule nextRule;

	public void setNextRule(IDiscountRule nextRule) {
		this.nextRule = nextRule;
	}

	public boolean applyNextRuleIfExist(InputForDiscountRules inputForDiscountRules) {
		if (this.nextRule != null) {
			return this.nextRule.apply(inputForDiscountRules);
		}
		return false;
	}

}
