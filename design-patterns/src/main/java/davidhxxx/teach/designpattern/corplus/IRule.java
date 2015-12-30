package davidhxxx.teach.designpattern.corplus;

public interface IRule {
    
    boolean apply(Order order);
    public void setNextRule(IRule nextRule);

}
