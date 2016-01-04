package davidhxxx.teach.designpattern.corplus.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChainOfRulesFactory {

    private ChainOfRulesFactory() {
    }

    private static class Holder {
	private static ChainOfRulesFactory instance = new ChainOfRulesFactory();
    }

    public static ChainOfRulesFactory getInstance() {
	return Holder.instance;
    }

    public RuleOrchestrator createDiscountChainOrderedDescByInterestClient(IDiscountRule... rules) {

	List<IDiscountRule> listOrdered = Arrays.asList(rules);
	Collections.sort(listOrdered, new DiscountRulesOrderedByInsterestClientComp());
	
	return new RuleOrchestrator(listOrdered);
    }

}
