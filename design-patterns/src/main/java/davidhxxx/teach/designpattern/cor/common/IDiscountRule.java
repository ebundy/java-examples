package davidhxxx.teach.designpattern.cor.common;

public interface IDiscountRule {
    
    public void setNextRule(IDiscountRule nextRule);
    public abstract boolean apply(InputForDiscountRules inputDataForDiscountRules);

}
