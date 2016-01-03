package davidhxxx.teach.designpattern.cor;

import davidhxxx.teach.designpattern.cor.common.AbstractRule;
import davidhxxx.teach.designpattern.cor.common.InputForDiscountRules;

public class RuleApplyDiscountFirstOrder extends AbstractRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenFirstOrder(inputDataForDiscountRules)) {
	    return true;
	}
	return applyNextRuleIfExist(inputDataForDiscountRules);

    }

    private boolean applyDiscountWhenFirstOrder(InputForDiscountRules inputDataForDiscountRules) {
	if (inputDataForDiscountRules.isFirstOrder()) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(0.075F);
	    return true;
	}
	return false;
    }

}
