package davidhxxx.teach.designpattern.cor.improved;

import davidhxxx.teach.designpattern.cor.improved.common.AbstractRule;
import davidhxxx.teach.designpattern.cor.improved.common.IDiscountRule;
import davidhxxx.teach.designpattern.cor.improved.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.cor.improved.common.Order;

public class RuleApplyDiscountMore4OrdersInOneMonth extends AbstractRule implements IDiscountRule {

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
