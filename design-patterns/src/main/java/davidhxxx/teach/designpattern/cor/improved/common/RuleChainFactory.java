package davidhxxx.teach.designpattern.cor.improved.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RuleChainFactory {

	private RuleChainFactory() {
	}

	private static class Holder {
		private static RuleChainFactory instance = new RuleChainFactory();
	}

	public static RuleChainFactory getInstance() {
		return Holder.instance;
	}

	public IDiscountRule createDiscountChainOrderedByDecreasingDiscountApplied(IDiscountRule... rules) {

		if (rules.length < 2) {
			throw new IllegalArgumentException("a chain must contain at least two rules");
		}

		List<IDiscountRule> listOrdered = Arrays.asList(rules);
		Collections.sort(listOrdered, new DiscountRulesOrderedByInsterestClientComp());

		IDiscountRule prevRule = listOrdered.get(0);
		for (int i = 1; i < listOrdered.size(); i++) {
			IDiscountRule currentRule = listOrdered.get(i);
			prevRule.setNextRule(currentRule);
			prevRule = currentRule;
		}

		return listOrdered.get(0);
	}

}
