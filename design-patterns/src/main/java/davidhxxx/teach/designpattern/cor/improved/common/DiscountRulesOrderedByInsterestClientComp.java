package davidhxxx.teach.designpattern.cor.improved.common;

import java.util.Comparator;

public class DiscountRulesOrderedByInsterestClientComp implements Comparator<IDiscountRule> {

    public int compare(IDiscountRule o1, IDiscountRule o2) {

	if (o1.getPrctDiscount() > o2.getPrctDiscount()) {
	    return -1;
	}

	else if (o1.getPrctDiscount() < o2.getPrctDiscount()) {
	    return 1;
	}

	return 0;
    }

}
