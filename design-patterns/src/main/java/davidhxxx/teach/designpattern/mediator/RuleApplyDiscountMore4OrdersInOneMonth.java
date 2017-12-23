package davidhxxx.teach.designpattern.mediator;

import davidhxxx.teach.designpattern.mediator.common.IDiscountRule;
import davidhxxx.teach.designpattern.mediator.common.InputForDiscountRules;

public class RuleApplyDiscountMore4OrdersInOneMonth implements IDiscountRule {

	public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
		if (inputDataForDiscountRules.getOrderCountInOneMonth() > 4) {
			inputDataForDiscountRules.getOrder()
			                         .applyDiscountInPrct(getPrctDiscount());
			return true;
		}
		return false;

	}

	public float getPrctDiscount() {
		return 0.15F;
	}

}
