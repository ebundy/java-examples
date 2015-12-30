package davidhxxx.teach.designpattern.cor;

public interface IRule {
    
    boolean apply(Order order);
    public void setNextRule(IRule nextRule);

}
