package davidhxxx.teach.designpattern.corplus;

import davidhxxx.teach.designpattern.corplus.common.IDiscountRule;
import davidhxxx.teach.designpattern.corplus.common.InputForDiscountRules;

public class RuleApplyDiscountFirstOrder   implements IDiscountRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (inputDataForDiscountRules.isFirstOrder()) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(getPrctDiscount());
	    return true;
	}
	return false;

    }

    public float getPrctDiscount() {
	return 0.075F;
    }

}
