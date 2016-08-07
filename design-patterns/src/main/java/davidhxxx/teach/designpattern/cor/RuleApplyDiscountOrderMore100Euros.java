package davidhxxx.teach.designpattern.cor;

import davidhxxx.teach.designpattern.cor.common.AbstractDiscountRule;
import davidhxxx.teach.designpattern.cor.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.cor.common.Order;

public class RuleApplyDiscountOrderMore100Euros extends AbstractDiscountRule  {

    public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
	if (applyDiscountWhenOrderMore100Euros(inputDataForDiscountRules)) {
	    return true;
	}
	return applyNextRuleIfExist(inputDataForDiscountRules);

    }

    private boolean applyDiscountWhenOrderMore100Euros(InputForDiscountRules inputDataForDiscountRules) {
	Order order = inputDataForDiscountRules.getOrder();
	
	if (order.getPriceTotal() > 100) {
	    order.applyDiscountInPrct(0.1F);
	    return true;
	}
	return false;
    }

}
