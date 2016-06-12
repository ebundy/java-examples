package davidhxxx.teach.designpattern.cor;

import davidhxxx.teach.designpattern.cor.common.AbstractRule;
import davidhxxx.teach.designpattern.cor.common.InputForDiscountRules;

public class RuleApplyDiscountHappyHour extends AbstractRule  {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenHappyHour(inputDataForDiscountRules)) {
	    return true;
	}
	return applyNextRuleIfExist(inputDataForDiscountRules);
    }

    private boolean applyDiscountWhenHappyHour(InputForDiscountRules inputDataForDiscountRules) {
	if (inputDataForDiscountRules.isHappyHour()) {
	    inputDataForDiscountRules.getOrder().applyDiscountInPrct(0.05F);
	    return true;
	}
	return false;
    }

}
