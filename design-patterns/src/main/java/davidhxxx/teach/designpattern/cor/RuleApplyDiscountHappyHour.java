package davidhxxx.teach.designpattern.cor;

public class RuleApplyDiscountHappyHour extends AbstractRule {

    public boolean apply(Order order) {
	if (applyDiscountWhenHappyHour(order)) {
	    return true;
	}
	return checkNextRule(order);

    }

    private boolean applyDiscountWhenHappyHour(Order order) {
	// Fake implementation
	order.applyDiscountInPrct(0.05F);
	return true;
    }

}
