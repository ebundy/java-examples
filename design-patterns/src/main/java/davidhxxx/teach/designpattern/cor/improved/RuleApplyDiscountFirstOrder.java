package davidhxxx.teach.designpattern.cor.improved;

import davidhxxx.teach.designpattern.cor.improved.common.AbstractRule;
import davidhxxx.teach.designpattern.cor.improved.common.IDiscountRule;
import davidhxxx.teach.designpattern.cor.improved.common.InputForDiscountRules;

public class RuleApplyDiscountFirstOrder extends AbstractRule implements IDiscountRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (inputDataForDiscountRules.isFirstOrder()) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(0.075F);
	    return true;
	}
	return false;
    }

    public float getPrctDiscount() {
	return 0.075F;
    }

}
