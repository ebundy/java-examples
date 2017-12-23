package davidhxxx.teach.designpattern.cor.improved.common;

import java.util.Comparator;

public class DiscountRulesOrderedByInsterestClientComp implements Comparator<IDiscountPrct> {

	public int compare(IDiscountPrct o1, IDiscountPrct o2) {

		if (o1.getPrctDiscount() > o2.getPrctDiscount()) {
			return -1;
		}

		else if (o1.getPrctDiscount() < o2.getPrctDiscount()) {
			return 1;
		}

		return 0;
	}

}
