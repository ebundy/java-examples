package davidhxxx.teach.designpattern.mediator.common;

import java.util.List;

public class RuleMediator {

    private int currentIndexOfList;
    private List<? extends IRule> rulesOrdered;


    public RuleMediator(List<? extends IRule> rulesOrdered) {
	this.rulesOrdered = rulesOrdered;
	currentIndexOfList=0;
    }

    public  boolean applyRules(InputForDiscountRules inputDataForDiscountRules) {
	if (rulesOrdered.get(currentIndexOfList).apply(inputDataForDiscountRules)) {
	    return true;
	}
	return applyNextRuleIfExist(inputDataForDiscountRules);

    }

    private boolean applyNextRuleIfExist(InputForDiscountRules inputDataForDiscountRules) {
	if (currentIndexOfList+1 < rulesOrdered.size()) {
	    currentIndexOfList++;
	    return applyRules(inputDataForDiscountRules);
	}

	return false;
    }

}
