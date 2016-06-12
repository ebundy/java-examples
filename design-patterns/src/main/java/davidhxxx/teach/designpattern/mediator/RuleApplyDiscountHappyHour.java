package davidhxxx.teach.designpattern.mediator;

import davidhxxx.teach.designpattern.mediator.common.IDiscountRule;
import davidhxxx.teach.designpattern.mediator.common.InputForDiscountRules;

public class RuleApplyDiscountHappyHour   implements IDiscountRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (inputDataForDiscountRules.isHappyHour()) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(getPrctDiscount());
	    return true;
	}
	return false;
    }

    public float getPrctDiscount() {
	return 0.05F;
    }


}
