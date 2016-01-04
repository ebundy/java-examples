package davidhxxx.teach.designpattern.corplus.client;

import org.junit.Test;

import davidhxxx.teach.designpattern.corplus.RuleApplyDiscountFirstOrder;
import davidhxxx.teach.designpattern.corplus.RuleApplyDiscountFirstOrderAndMore200Euros;
import davidhxxx.teach.designpattern.corplus.RuleApplyDiscountHappyHour;
import davidhxxx.teach.designpattern.corplus.RuleApplyDiscountOrderMore100Euros;
import davidhxxx.teach.designpattern.corplus.RuleApplyDiscountOrderMore200Euros;
import davidhxxx.teach.designpattern.corplus.common.ChainOfRulesFactory;
import davidhxxx.teach.designpattern.corplus.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.corplus.common.Order;
import davidhxxx.teach.designpattern.corplus.common.RuleOrchestrator;
import junit.framework.Assert;

public class ClientRulesTest {

    @Test
    public void assertFirstAcceptedRuleIsAppliedInOrder() throws Exception {

	// fixture
	RuleOrchestrator ruleOrchestrator = createChainOfDiscountRules();

	// CASE : more 200 euros applied
	Order order = new Order(400F);
	InputForDiscountRules inputForDiscountRules = new InputForDiscountRules(order, false, 6, true);
	// action
	ruleOrchestrator.applyRules(inputForDiscountRules);
	// assertion
	Assert.assertEquals(300F, order.getPriceTotal());

	// CASE : more 100 euros applied
	order = new Order(200F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 1, true);
	// action
	ruleOrchestrator.applyRules(inputForDiscountRules);
	// assertion
	Assert.assertEquals(180F, order.getPriceTotal());

	// CASE : happy hour applied
	order = new Order(100F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 1, true);
	// action
	ruleOrchestrator.applyRules(inputForDiscountRules);
	// assertion
	Assert.assertEquals(95F, order.getPriceTotal());

	// CASE : no reduction applied
	order = new Order(100F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 4, false);
	// action
	ruleOrchestrator.applyRules(inputForDiscountRules);
	// assertion
	Assert.assertEquals(100F, order.getPriceTotal());
    }

    private RuleOrchestrator createChainOfDiscountRules() {
	RuleOrchestrator orchestrator = ChainOfRulesFactory.getInstance().
		createDiscountChainOrderedDescByInterestClient(	new RuleApplyDiscountFirstOrder(),
								new RuleApplyDiscountHappyHour(), 
								new RuleApplyDiscountOrderMore100Euros(), 
								new RuleApplyDiscountOrderMore200Euros(), 
								new RuleApplyDiscountFirstOrderAndMore200Euros());

	return orchestrator;
    }

}
