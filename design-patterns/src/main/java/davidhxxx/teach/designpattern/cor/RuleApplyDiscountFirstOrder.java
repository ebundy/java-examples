package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountFirstOrder extends AbstractRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenFirstOrder(inputDataForDiscountRules)) {
	    return true;
	}
	return checkNextRule(inputDataForDiscountRules);

    }

    private boolean applyDiscountWhenFirstOrder(InputForDiscountRules inputDataForDiscountRules) {
	if (inputDataForDiscountRules.isFirstOrder()) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(0.075F);
	    return true;
	}
	return false;
    }

}
