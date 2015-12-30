package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountOrderMore100Euros extends AbstractRule {

    public boolean apply(Order order) {
	if (applyDiscountWhenOrderMore100Euros(order)) {
	    return true;
	}
	return checkNextRule(order);

    }

    private boolean applyDiscountWhenOrderMore100Euros(Order order) {
	if (order.getPriceTotal() > 100) {
	    order.applyDiscountInPrct(0.1F);
	    return true;
	}
	return false;
    }

}
