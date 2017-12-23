package davidhxxx.teach.designpattern.cor;

import davidhxxx.teach.designpattern.cor.common.AbstractDiscountRule;
import davidhxxx.teach.designpattern.cor.common.InputForDiscountRules;

public class RuleApplyDiscountMore4OrdersInOneMonth extends AbstractDiscountRule {

	public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
		if (applyDiscountWhenMore4OrdersInOneMonth(inputDataForDiscountRules)) {
			return true;
		}
		return applyNextRuleIfExist(inputDataForDiscountRules);

	}

	private boolean applyDiscountWhenMore4OrdersInOneMonth(InputForDiscountRules inputDataForDiscountRules) {

		if (inputDataForDiscountRules.getOrderCountInOneMonth() > 4) {
			inputDataForDiscountRules.getOrder()
			                         .applyDiscountInPrct(0.15F);
			return true;
		}
		return false;
	}

}
