package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountFirstOrderAndMore200Euros extends AbstractRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenOrderMore200Euros(inputDataForDiscountRules)) {
	    return true;
	}
	return checkNextRule(inputDataForDiscountRules);

    }

    private boolean applyDiscountWhenOrderMore200Euros(InputForDiscountRules inputDataForDiscountRules) {
	Order order = inputDataForDiscountRules.getOrder();
	
	if (inputDataForDiscountRules.isFirstOrder() && order.getPriceTotal() > 200) {
	    order.applyDiscountInPrct(0.25F);
	    return true;
	}
	return false;
    }

}
