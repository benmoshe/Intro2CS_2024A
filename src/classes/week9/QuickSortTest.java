package classes.week9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class QuickSortTest {
	@Test
	void testSort() {
		double[] arr = {1,-3.2,1,5,-3.2};
		QuickSort.sort(arr);
		boolean b = MyArrayLibrary.isSortedAscending(arr);
		if(b!=true) {
			fail("ERR: the array should be sorted!");
		}
	}

}
