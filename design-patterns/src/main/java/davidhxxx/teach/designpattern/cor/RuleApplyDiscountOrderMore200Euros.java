package davidhxxx.teach.designpattern.cor;

import davidhxxx.teach.designpattern.cor.common.AbstractRule;
import davidhxxx.teach.designpattern.cor.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.cor.common.Order;

public class RuleApplyDiscountOrderMore200Euros extends AbstractRule {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenOrderMore200Euros(inputDataForDiscountRules)) {
	    return true;
	}
	return applyNextRuleIfExist(inputDataForDiscountRules);

    }

    private boolean applyDiscountWhenOrderMore200Euros(InputForDiscountRules inputDataForDiscountRules) {
	Order order = inputDataForDiscountRules.getOrder();
	
	if (order.getPriceTotal() > 200) {
	    order.applyDiscountInPrct(0.25F);
	    return true;
	}
	return false;
    }

}
