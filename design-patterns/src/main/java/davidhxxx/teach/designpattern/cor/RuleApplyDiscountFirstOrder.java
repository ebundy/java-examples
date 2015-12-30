package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountFirstOrder extends AbstractRule {

    public boolean apply(Order order) {
	if (applyDiscountWhenFirstOrder(order)) {
	    return true;
	}
	return checkNextRule(order);

    }

    private boolean applyDiscountWhenFirstOrder(Order order) {
	//Fake implementation
	order.applyDiscountInPrct(0.075F);
	return true;
    }

}
