package davidhxxx.teach.designpattern.cor.client;

import org.junit.Test;

import davidhxxx.teach.designpattern.cor.IRule;
import davidhxxx.teach.designpattern.cor.InputForDiscountRules;
import davidhxxx.teach.designpattern.cor.Order;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountFirstOrder;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountFirstOrderAndMore200Euros;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountHappyHour;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountOrderMore100Euros;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountOrderMore200Euros;
import junit.framework.Assert;

public class ClientRulesTest {

    @Test
    public void assertFirstAcceptedRuleIsAppliedInOrder() throws Exception {

	// fixture
	IRule firstRule = createChainOfRules();

	// CASE : more 200 euros applied
	Order order = new Order(400F);
	InputForDiscountRules inputForDiscountRules = new InputForDiscountRules(order, false, 6, true);
	// action
	firstRule.apply(inputForDiscountRules);
	// assertion
	Assert.assertEquals(300F, order.getPriceTotal());

	// CASE : more 100 euros applied
	order = new Order(200F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 1, true);
	// action
	firstRule.apply(inputForDiscountRules);
	// assertion
	Assert.assertEquals(180F, order.getPriceTotal());

	// CASE : happy hour applied
	order = new Order(100F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 1, true);
	// action
	firstRule.apply(inputForDiscountRules);
	// assertion
	Assert.assertEquals(95F, order.getPriceTotal());

	// CASE : no reduction applied
	order = new Order(100F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 4, false);
	// action
	firstRule.apply(inputForDiscountRules);
	// assertion
	Assert.assertEquals(100F, order.getPriceTotal());
    }

    private IRule createChainOfRules() {
	IRule ruleFirstOrder = new RuleApplyDiscountFirstOrder();
	IRule ruleHappyHour = new RuleApplyDiscountHappyHour();
	IRule ruleOrderMore100Euros = new RuleApplyDiscountOrderMore100Euros();
	IRule ruleOrderMore200Euros = new RuleApplyDiscountOrderMore200Euros();
	
	// first node of the chain
	IRule firstRule = new RuleApplyDiscountFirstOrderAndMore200Euros();

	firstRule.setNextRule(ruleOrderMore200Euros);
	ruleOrderMore200Euros.setNextRule(ruleOrderMore100Euros);
	ruleOrderMore100Euros.setNextRule(ruleFirstOrder);
	ruleFirstOrder.setNextRule(ruleHappyHour);
	return firstRule;
    }

}
