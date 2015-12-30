package davidhxxx.teach.designpattern.corplus;

public class RuleCheckDiscountFirstOrder extends AbstractRule {

    public boolean applySpecific(Order order) {
	return applyDiscountWhenFirstOrder(order);

    }

    private boolean applyDiscountWhenFirstOrder(Order order) {
	//Fake implementation
	return true;
    }

}
