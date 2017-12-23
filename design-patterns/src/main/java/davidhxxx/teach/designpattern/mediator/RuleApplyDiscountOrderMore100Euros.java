package davidhxxx.teach.designpattern.mediator;

import davidhxxx.teach.designpattern.mediator.common.IDiscountRule;
import davidhxxx.teach.designpattern.mediator.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.mediator.common.Order;

public class RuleApplyDiscountOrderMore100Euros implements IDiscountRule {

	public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
		Order order = inputDataForDiscountRules.getOrder();

		if (order.getPriceTotal() > 100) {
			order.applyDiscountInPrct(getPrctDiscount());
			return true;
		}
		return false;

	}

	public float getPrctDiscount() {
		return 0.1F;
	}

}
