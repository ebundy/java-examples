package davidhxxx.teach.designpattern.cor.improved;

import davidhxxx.teach.designpattern.cor.improved.common.AbstractDiscountRule;
import davidhxxx.teach.designpattern.cor.improved.common.InputForDiscountRules;

public class RuleApplyDiscountFirstOrder extends AbstractDiscountRule {

	public boolean apply(InputForDiscountRules inputDataForDiscountRules) {
		if (inputDataForDiscountRules.isFirstOrder()) {
			inputDataForDiscountRules.getOrder()
			                         .applyDiscountInPrct(getPrctDiscount());
			return true;
		}
		return false;
	}

	public float getPrctDiscount() {
		return 0.075F;
	}

}
