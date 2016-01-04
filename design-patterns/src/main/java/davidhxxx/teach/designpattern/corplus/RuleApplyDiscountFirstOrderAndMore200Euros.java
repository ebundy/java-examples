package davidhxxx.teach.designpattern.corplus;

import davidhxxx.teach.designpattern.corplus.common.IDiscountRule;
import davidhxxx.teach.designpattern.corplus.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.corplus.common.Order;

public class RuleApplyDiscountFirstOrderAndMore200Euros  implements IDiscountRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	Order order = inputDataForDiscountRules.getOrder();

	if (inputDataForDiscountRules.isFirstOrder() && order.getPriceTotal() > 200) {
	    order.applyDiscountInPrct(getPrctDiscount());
	    return true;
	}
	return false;
    }

    public float getPrctDiscount() {
	return 0.28F;
    }

}
