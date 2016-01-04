package davidhxxx.teach.designpattern.corplus;

import davidhxxx.teach.designpattern.corplus.common.IDiscountRule;
import davidhxxx.teach.designpattern.corplus.common.InputForDiscountRules;

public class RuleApplyDiscountMore4OrdersInOneMonth  implements IDiscountRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (inputDataForDiscountRules.getOrderCountInOneMonth() > 4) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(getPrctDiscount());
	    return true;
	}
	return false;

    }

    public float getPrctDiscount() {
	return 0.15F;
    }

}
