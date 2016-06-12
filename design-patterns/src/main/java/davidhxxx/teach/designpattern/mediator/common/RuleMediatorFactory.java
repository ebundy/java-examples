package davidhxxx.teach.designpattern.mediator.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RuleMediatorFactory {

    private RuleMediatorFactory() {
    }

    private static class Holder {
	private static RuleMediatorFactory instance = new RuleMediatorFactory();
    }

    public static RuleMediatorFactory getInstance() {
	return Holder.instance;
    }

    public RuleMediator createDiscountChainOrderedDescByInterestClient(IDiscountRule... rules) {
	List<IDiscountRule> listOrdered = Arrays.asList(rules);
	Collections.sort(listOrdered, new DiscountRulesOrderedByInsterestClientComp());
	return new RuleMediator(listOrdered);
    }

}
