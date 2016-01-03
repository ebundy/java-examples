package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountOrderMore100Euros extends AbstractRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenOrderMore100Euros(inputDataForDiscountRules)) {
	    return true;
	}
	return checkNextRule(inputDataForDiscountRules);

    }

    private boolean applyDiscountWhenOrderMore100Euros(InputForDiscountRules inputDataForDiscountRules) {
	Order order = inputDataForDiscountRules.getOrder();
	
	if (order.getPriceTotal() > 100) {
	    order.applyDiscountInPrct(0.1F);
	    return true;
	}
	return false;
    }

}
