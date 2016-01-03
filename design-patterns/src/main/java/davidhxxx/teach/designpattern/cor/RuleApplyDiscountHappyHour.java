package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountHappyHour extends AbstractRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenHappyHour(inputDataForDiscountRules)) {
	    return true;
	}
	return checkNextRule(inputDataForDiscountRules);
    }

    private boolean applyDiscountWhenHappyHour(InputForDiscountRules inputDataForDiscountRules) {
	if (inputDataForDiscountRules.isHappyHour()) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(0.05F);
	    return true;
	}
	return false;
    }

}
