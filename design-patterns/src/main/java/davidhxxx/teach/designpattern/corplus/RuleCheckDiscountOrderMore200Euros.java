package davidhxxx.teach.designpattern.corplus;

public class RuleCheckDiscountOrderMore200Euros extends AbstractRule {

    public boolean applySpecific(Order order) {
	return applyDiscountWhenOrderMore200Euros(order);
    }

    private boolean applyDiscountWhenOrderMore200Euros(Order order) {
	// Fake implementation
	return true;
    }

}
