package davidhxxx.teach.designpattern.cor.improved.common;

public interface IRule {
    
    public void setNextRule(IRule nextRule);
    
    /**
     * It's the business rule.
     * must not be called by the client.  It's called by applyRoot
     * @param inputDataForDiscountRules
     * @return
     */
    public abstract boolean apply(InputForDiscountRules inputDataForDiscountRules);
    
    /**
     * It's the chain rule processing
     * must be called by the client. It's the outer apply to process the whole rule chain
     * @param inputDataForDiscountRules
     * @return
     */
    public abstract boolean applyChain(InputForDiscountRules inputDataForDiscountRules);

}
