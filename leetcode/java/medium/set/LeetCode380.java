package ds.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode380 {
	// https://leetcode.com/problems/insert-delete-getrandom-o1
	// Time Complexity: O(1)
	// Space Complexity: O(n)
	private Map<Integer, Integer> indexMap;
	private List<Integer> numList;

	public LeetCode380() {
		this.indexMap = new HashMap<>();
		this.numList = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (this.indexMap.containsKey(val)) {
			return false;
		}
		// Insert in both map and list
		int insertIdx = this.numList.size();
		this.numList.add(val);
		this.indexMap.put(val, insertIdx);

		return true;
	}

	public boolean remove(int val) {
		if (!this.indexMap.containsKey(val)) {
			return false;
		}

		// Check the index which is being removed
		int removeIdx = this.indexMap.get(val);
		// Check the list current size
		int lastIdx = this.numList.size() - 1;

		// Find the value at last index of list and move it to the index
		// which is being removed
		int lastIdxNum = this.numList.get(lastIdx);
		this.numList.set(removeIdx, lastIdxNum);
		// Change the position of last index num and remove from map
		this.indexMap.put(lastIdxNum, removeIdx);
		this.indexMap.remove(val);

		// remove the last index num from list as it is duplicate now
		this.numList.remove(lastIdx);
		return true;
	}

	public int getRandom() {
		// Get the random number between 0 and size of numList
		int randomIdx = (int) (Math.random() * this.numList.size());
		return this.numList.get(randomIdx);
	}
}