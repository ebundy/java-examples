package davidhxxx.teach.designpattern.cor.client;

import org.junit.Test;

import davidhxxx.teach.designpattern.cor.IRule;
import davidhxxx.teach.designpattern.cor.Order;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountFirstOrder;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountHappyHour;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountOrderMore100Euros;
import davidhxxx.teach.designpattern.cor.RuleApplyDiscountOrderMore200Euros;
import junit.framework.Assert;

public class ClientRulesTest {

    @Test
    public void assertFirstAcceptedRuleIsAppliedInOrder() throws Exception {

	// fixture
	IRule ruleFirstOrder = new RuleApplyDiscountFirstOrder();
	IRule ruleHappyHour = new RuleApplyDiscountHappyHour();
	IRule ruleOrderMore100Euros = new RuleApplyDiscountOrderMore100Euros();
	IRule ruleOrderMore200Euros = new RuleApplyDiscountOrderMore200Euros();

	ruleOrderMore200Euros.setNextRule(ruleOrderMore100Euros);
	ruleOrderMore100Euros.setNextRule(ruleFirstOrder);
	ruleFirstOrder.setNextRule(ruleHappyHour);

	// CASE : more 200 euros applied 
	Order order = new Order(400F);
	// action
	ruleOrderMore200Euros.apply(order);
	// assertion
	Assert.assertEquals(300F, order.getPriceTotal());
	
	// CASE : more 100 euros applied 
	 order = new Order(200F);
	// action
	ruleOrderMore200Euros.apply(order);
	// assertion
	Assert.assertEquals(180F, order.getPriceTotal());
    }
    
    

}
