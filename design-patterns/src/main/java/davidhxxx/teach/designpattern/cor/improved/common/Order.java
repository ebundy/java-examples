package davidhxxx.teach.designpattern.cor.improved.common;

public class Order {

    private float priceTotal;

    public Order(float priceTotal) {
	this.priceTotal = priceTotal;
    }

    public float getPriceTotal() {
	return priceTotal;
    }

    public void applyDiscountInPrct(float discountInPrct) {
	this.priceTotal = priceTotal * (1F - discountInPrct);
    }

}
