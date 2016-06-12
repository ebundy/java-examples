package davidhxxx.teach.designpattern.mediator.client;

import org.junit.Test;

import davidhxxx.teach.designpattern.mediator.RuleApplyDiscountFirstOrder;
import davidhxxx.teach.designpattern.mediator.RuleApplyDiscountFirstOrderAndMore200Euros;
import davidhxxx.teach.designpattern.mediator.RuleApplyDiscountHappyHour;
import davidhxxx.teach.designpattern.mediator.RuleApplyDiscountOrderMore100Euros;
import davidhxxx.teach.designpattern.mediator.RuleApplyDiscountOrderMore200Euros;
import davidhxxx.teach.designpattern.mediator.common.RuleMediatorFactory;
import davidhxxx.teach.designpattern.mediator.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.mediator.common.Order;
import davidhxxx.teach.designpattern.mediator.common.RuleMediator;
import junit.framework.Assert;

public class ClientRulesTest {

    @Test
    public void assertFirstAcceptedRuleAreAppliedInOrder() throws Exception {

	// fixture
	RuleMediator ruleMediator = createChainOfDiscountRules();

	// CASE : more 200 euros applied
	Order order = new Order(400F);
	InputForDiscountRules inputForDiscountRules = new InputForDiscountRules(order, false, 6, true);
	// action
	ruleMediator.applyRules(inputForDiscountRules);
	// assertion
	Assert.assertEquals(300F, order.getPriceTotal());

	// CASE : more 100 euros applied
	order = new Order(200F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 1, true);
	// action
	ruleMediator.applyRules(inputForDiscountRules);
	// assertion
	Assert.assertEquals(180F, order.getPriceTotal());

	// CASE : happy hour applied
	order = new Order(100F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 1, true);
	// action
	ruleMediator.applyRules(inputForDiscountRules);
	// assertion
	Assert.assertEquals(95F, order.getPriceTotal());

	// CASE : no reduction applied
	order = new Order(100F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 4, false);
	// action
	ruleMediator.applyRules(inputForDiscountRules);
	// assertion
	Assert.assertEquals(100F, order.getPriceTotal());
    }

    private RuleMediator createChainOfDiscountRules() {
	RuleMediator ruleMediator = RuleMediatorFactory.getInstance().
		createDiscountChainOrderedDescByInterestClient(	new RuleApplyDiscountFirstOrder(),
								new RuleApplyDiscountHappyHour(), 
								new RuleApplyDiscountOrderMore100Euros(), 
								new RuleApplyDiscountOrderMore200Euros(), 
								new RuleApplyDiscountFirstOrderAndMore200Euros());

	return ruleMediator;
    }

}
