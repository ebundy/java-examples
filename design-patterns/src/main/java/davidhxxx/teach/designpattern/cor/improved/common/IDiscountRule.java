package davidhxxx.teach.designpattern.cor.improved.common;

public interface IDiscountRule extends IDiscountPrct {

    void setNextRule(IDiscountRule nextRule);

    /**
     * It's the business rule.
     * must not be called by the client. It's called by applyRoot
     * 
     * @param inputDataForDiscountRules
     * @return
     */
    boolean apply(InputForDiscountRules inputDataForDiscountRules);

    /**
     * It's the chain rule processing
     * must be called by the client. It's the outer apply to process the whole rule chain
     * 
     * @param inputDataForDiscountRules
     * @return
     */
    boolean applyChain(InputForDiscountRules inputDataForDiscountRules);


}
