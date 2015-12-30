package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountOrderMore200Euros extends AbstractRule {

    public boolean apply(Order order) {
	if (applyDiscountWhenOrderMore200Euros(order)) {
	    return true;
	}
	return checkNextRule(order);

    }

    private boolean applyDiscountWhenOrderMore200Euros(Order order) {
	if (order.getPriceTotal() > 200) {
	    order.applyDiscountInPrct(0.25F);
	    return true;
	}
	return false;
    }

}
