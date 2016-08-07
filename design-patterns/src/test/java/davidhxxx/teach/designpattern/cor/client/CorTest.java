package davidhxxx.teach.designpattern.cor.client;

import org.junit.Test;

import davidhxxx.teach.designpattern.cor.RuleApplyDiscountFirstOrder;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountFirstOrderAndMore200Euros;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountHappyHour;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountOrderMore100Euros;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountOrderMore200Euros;
import davidhxxx.teach.designpattern.cor.common.IDiscountRule;
import davidhxxx.teach.designpattern.cor.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.cor.common.Order;
import junit.framework.Assert;

public class CorTest {

    @Test
    public void assertFirstAcceptedRuleAreAppliedInOrder() throws Exception {

	// fixture
	IDiscountRule firstRule = createChainOfRules();

	// CASE : more 200 euros applied and first order
	Order order = new Order(400F);
	InputForDiscountRules inputForDiscountRules = new InputForDiscountRules(order, true, 6, true);
	// action
	firstRule.apply(inputForDiscountRules);
	// assertion
	Assert.assertEquals(280F, order.getPriceTotal());

	// CASE : more 200 euros applied
	order = new Order(400F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 6, true);
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

    private IDiscountRule createChainOfRules() {
	IDiscountRule ruleFirstOrder = new RuleApplyDiscountFirstOrder();
	IDiscountRule ruleHappyHour = new RuleApplyDiscountHappyHour();
	IDiscountRule ruleOrderMore100Euros = new RuleApplyDiscountOrderMore100Euros();
	IDiscountRule ruleOrderMore200Euros = new RuleApplyDiscountOrderMore200Euros();

	// first node of the chain
	IDiscountRule firstRule = new RuleApplyDiscountFirstOrderAndMore200Euros();

	firstRule.setNextRule(ruleOrderMore200Euros);
	ruleOrderMore200Euros.setNextRule(ruleOrderMore100Euros);
	ruleOrderMore100Euros.setNextRule(ruleFirstOrder);
	ruleFirstOrder.setNextRule(ruleHappyHour);
	return firstRule;
    }

}
