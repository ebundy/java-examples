package davidhxxx.teach.designpattern.corplus;

public class RuleCheckDiscountOrderMore100Euros extends AbstractRule {

    public boolean applySpecific(Order order) {
	return applyDiscountWhenOrderMore100Euros(order);
    }

    private boolean applyDiscountWhenOrderMore100Euros(Order order) {
	// Fake implementation
	return true;
    }

}
