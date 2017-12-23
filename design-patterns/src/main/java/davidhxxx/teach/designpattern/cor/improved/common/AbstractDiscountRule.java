package davidhxxx.teach.designpattern.cor.improved.common;

public abstract class AbstractDiscountRule implements IDiscountRule {

	protected IDiscountRule nextRule;

	public void setNextRule(IDiscountRule nextRule) {
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
