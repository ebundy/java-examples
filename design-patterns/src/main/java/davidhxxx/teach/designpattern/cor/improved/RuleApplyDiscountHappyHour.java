package davidhxxx.teach.designpattern.cor.improved;

import davidhxxx.teach.designpattern.cor.improved.common.AbstractDiscountRule;
import davidhxxx.teach.designpattern.cor.improved.common.IDiscountRule;
import davidhxxx.teach.designpattern.cor.improved.common.InputForDiscountRules;

public class RuleApplyDiscountHappyHour extends AbstractDiscountRule implements IDiscountRule {

	public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
		if (inputDataForDiscountRules.isHappyHour()) {
			inputDataForDiscountRules.getOrder()
			                         .applyDiscountInPrct(getPrctDiscount());
			return true;
		}
		return false;
	}

	public float getPrctDiscount() {
		return 0.05F;
	}
}
