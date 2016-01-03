package davidhxxx.teach.designpattern.cor;

public interface IRule {
    
    boolean apply(InputForDiscountRules inputDataForDiscountRules);
    public void setNextRule(IRule nextRule);

}
