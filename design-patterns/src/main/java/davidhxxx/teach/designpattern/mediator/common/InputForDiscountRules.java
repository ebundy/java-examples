package davidhxxx.teach.designpattern.mediator.common;

public class InputForDiscountRules {

    private Order order;
    private boolean isFirstOrder;
    private int orderCountInOneMonth;
    private boolean isHappyHour;

    public InputForDiscountRules(Order order, boolean isFirstOrder, int orderCountInOneMonth, boolean isHappyHour) {
	this.order = order;
	this.isFirstOrder = isFirstOrder;
	this.orderCountInOneMonth = orderCountInOneMonth;
	this.isHappyHour = isHappyHour;
    }

    public int getOrderCountInOneMonth() {
	return orderCountInOneMonth;
    }

    public Order getOrder() {
	return order;
    }

    public boolean isFirstOrder() {
	return isFirstOrder;
    }

    public boolean isHappyHour() {
	return isHappyHour;
    }

}
