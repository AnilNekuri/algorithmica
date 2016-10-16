package com.algorithmica.set;

import com.algorithmica.lists.iList;

public interface ISortedSet<E> extends ISet<E> {
	E findMin();
	E findMax();
	int select(int k);
	iList<E> findRange(E s,E m);	
}
