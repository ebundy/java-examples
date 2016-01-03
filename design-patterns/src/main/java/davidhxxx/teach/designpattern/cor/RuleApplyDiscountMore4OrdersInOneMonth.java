package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountMore4OrdersInOneMonth extends AbstractRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenMore4OrdersInOneMonth(inputDataForDiscountRules)) {
	    return true;
	}
	return checkNextRule(inputDataForDiscountRules);

    }

    private boolean applyDiscountWhenMore4OrdersInOneMonth(InputForDiscountRules inputDataForDiscountRules) {

	if (inputDataForDiscountRules.getOrderCountInOneMonth() > 4) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(0.15F);
	    return true;
	}
	return false;
    }

}
