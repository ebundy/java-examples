package davidhxxx.teach.designpattern.corplus;

public class RuleCheckDiscountHappyHour extends AbstractRule {

    public boolean applySpecific(Order order) {
	return applyDiscountWhenHappyHour(order);
    }

    private boolean applyDiscountWhenHappyHour(Order order) {
	// Fake implementation
	return true;
    }

}
