package davidhxxx.teach.designpattern.cor.improve.client;

import org.junit.Test;

import davidhxxx.teach.designpattern.cor.improved.RuleApplyDiscountFirstOrder;
import davidhxxx.teach.designpattern.cor.improved.RuleApplyDiscountFirstOrderAndMore200Euros;
import davidhxxx.teach.designpattern.cor.improved.RuleApplyDiscountHappyHour;
import davidhxxx.teach.designpattern.cor.improved.RuleApplyDiscountOrderMore100Euros;
import davidhxxx.teach.designpattern.cor.improved.RuleApplyDiscountOrderMore200Euros;
import davidhxxx.teach.designpattern.cor.improved.common.IDiscountRule;
import davidhxxx.teach.designpattern.cor.improved.common.InputForDiscountRules;
import davidhxxx.teach.designpattern.cor.improved.common.Order;
import davidhxxx.teach.designpattern.cor.improved.common.RuleChainFactory;
import junit.framework.Assert;

public class ImprovedCorTest {

    @Test
    public void assertFirstAcceptedRuleAreAppliedInOrder() throws Exception {

	// fixture
	IDiscountRule firstRule = createChainOfRules();

	// CASE : more 200 euros applied and first order
	Order order = new Order(400F);
	InputForDiscountRules inputForDiscountRules = new InputForDiscountRules(order, true, 6, true);
	// action
	firstRule.applyChain(inputForDiscountRules);
	// assertion
	Assert.assertEquals(280F, order.getPriceTotal());

	// CASE : more 200 euros applied
	order = new Order(400F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 6, true);
	// action
	firstRule.applyChain(inputForDiscountRules);
	// assertion
	Assert.assertEquals(300F, order.getPriceTotal());

	// CASE : more 100 euros applied
	order = new Order(200F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 1, true);
	// action
	firstRule.applyChain(inputForDiscountRules);
	// assertion
	Assert.assertEquals(180F, order.getPriceTotal());

	// CASE : happy hour applied
	order = new Order(100F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 1, true);
	// action
	firstRule.applyChain(inputForDiscountRules);
	// assertion
	Assert.assertEquals(95F, order.getPriceTotal());

	// CASE : no reduction applied
	order = new Order(100F);
	inputForDiscountRules = new InputForDiscountRules(order, false, 4, false);
	// action
	firstRule.applyChain(inputForDiscountRules);
	// assertion
	Assert.assertEquals(100F, order.getPriceTotal());
    }

    private IDiscountRule createChainOfRules() {

	IDiscountRule firstRule = RuleChainFactory.getInstance().createDiscountChainOrderedByDecreasingDiscountApplied(
		new RuleApplyDiscountFirstOrder(),
		new RuleApplyDiscountHappyHour(),
		new RuleApplyDiscountOrderMore100Euros(),
		new RuleApplyDiscountOrderMore200Euros(),
		new RuleApplyDiscountFirstOrderAndMore200Euros());

	return firstRule;
    }

}
