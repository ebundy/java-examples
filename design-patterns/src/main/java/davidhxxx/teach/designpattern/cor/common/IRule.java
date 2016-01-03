package davidhxxx.teach.designpattern.cor.common;

public interface IRule {
    
    public void setNextRule(IRule nextRule);
    public abstract boolean apply(InputForDiscountRules inputDataForDiscountRules);

}
