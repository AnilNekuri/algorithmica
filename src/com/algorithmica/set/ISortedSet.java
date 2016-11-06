package com.algorithmica.set;

import com.algorithmica.lists.IList;

public interface ISortedSet<E> extends ISet<E> {
	E findMin();
	E findMax();
	E select(int k);
	IList<E> findRange(E s,E m);	
}
