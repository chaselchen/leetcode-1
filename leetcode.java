import java.util.HashMap;

class Solution {

	/*1. Two Sum (Easy)
	Given an array of integers nums and an integer target, return indices of 
	the two numbers such that they add up to target. You may assume that each 
	input would have exactly one solution, and you may not use the same element 
	twice. You can return the answer in any order.

	Example 1:
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

	Example 2:
	Input: nums = [3,2,4], target = 6
	Output: [1,2]

	Example 3:
	Input: nums = [3,3], target = 6
	Output: [0,1]

	Constraints:
	* 2 <= nums.length <= 10^4
	* -10^9 <= nums[i] <= 10^9
	* -10^9 <= target <= 10^9
	* Only one valid answer exists.

	Follow-up: Can you come up with an algorithm that is less than O(n2) time 
	           complexity?*/

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>(); 
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i]; 
            if (seen.containsKey(diff)) return new int[]{seen.get(diff), i}; 
            seen.put(nums[i], i); 
        }
        return null; 
    }


    /*9. Palindrome Number (Easy)
	Given an integer x, return true if x is a palindrome, and false otherwise.

	Example 1:
	Input: x = 121
	Output: true
	Explanation: 121 reads as 121 from left to right and from right to left.

	Example 2:
	Input: x = -121
	Output: false
	Explanation: From left to right, it reads -121. From right to left, it 
	             becomes 121-. Therefore it is not a palindrome.

	Example 3:
	Input: x = 10
	Output: false
	Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 	Constraints: -2^31 <= x <= 2^31 - 1

	Follow up: Could you solve it without converting the integer to a string?*/

    public boolean isPalindrome(int x) {
        if (x % 10 == 0 && x != 0 || x < 0) return false; 
        int rev = 0; 
        for (; x > rev; x /= 10) 
            rev = 10*rev + x%10; 
        return x == rev || x == rev/10; 
    }


    /*13. Roman to Integer (Easy)
	Roman numerals are represented by seven different symbols: I, V, X, L, C, D 
	and M.
	    Symbol       Value
	    I             1
	    V             5
	    X             10
	    L             50
	    C             100
	    D             500
	    M             1000
	For example, 2 is written as II in Roman numeral, just two ones added 
	together. 12 is written as XII, which is simply X + II. The number 27 is 
	written as XXVII, which is XX + V + II. Roman numerals are usually written 
	largest to smallest from left to right. However, the numeral for four is 
	not IIII. Instead, the number four is written as IV. Because the one is 
	before the five we subtract it making four. The same principle applies to 
	the number nine, which is written as IX. There are six instances where 
	subtraction is used:
	* I can be placed before V (5) and X (10) to make 4 and 9. 
	* X can be placed before L (50) and C (100) to make 40 and 90. 
	* C can be placed before D (500) and M (1000) to make 400 and 900.
	Given a roman numeral, convert it to an integer.

	Example 1:
	Input: s = "III"
	Output: 3
	Explanation: III = 3.

	Example 2:
	Input: s = "LVIII"
	Output: 58
	Explanation: L = 50, V= 5, III = 3.

	Example 3:
	Input: s = "MCMXCIV"
	Output: 1994
	Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

	Constraints:
	* 1 <= s.length <= 15
	* s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
	* It is guaranteed that s is a valid roman numeral in the range [1, 3999].*/

    public int romanToInt(String s) {
        HashMap<Character, Integer> mp = new HashMap<>() {{
            put('I', 1); 
            put('V', 5); 
            put('X', 10); 
            put('L', 50); 
            put('C', 100); 
            put('D', 500); 
            put('M', 1000); 
        }}; 
        int ans = 0; 
        for (int i = 0; i < s.length(); ++i) {
            if (i+1 < s.length() && mp.get(s.charAt(i)) < mp.get(s.charAt(i+1))) ans -= mp.get(s.charAt(i)); 
            else ans += mp.get(s.charAt(i)); 
        }
        return ans; 
    }


    /*14. Longest Common Prefix (Easy)
	Write a function to find the longest common prefix string amongst an array 
	of strings. If there is no common prefix, return an empty string "".

	Example 1:
	Input: strs = ["flower","flow","flight"]
	Output: "fl"

	Example 2:
	Input: strs = ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.

	Constraints:
	* 1 <= strs.length <= 200
	* 0 <= strs[i].length <= 200
	* strs[i] consists of only lowercase English letters.*/

    public String longestCommonPrefix(String[] strs) {
        String lo = Collections.min(Arrays.asList(strs)), hi = Collections.max(Arrays.asList(strs)); 
        int i = 0; 
        for (; i < lo.length() && i < hi.length() && lo.charAt(i) == hi.charAt(i); ++i); 
        return lo.substring(0, i); 
    }


    /*20. Valid Parentheses (Easy)
	Given a string s containing just the characters '(', ')', '{', '}', '[' and 
	']', determine if the input string is valid. An input string is valid if:
	* Open brackets must be closed by the same type of brackets.
	* Open brackets must be closed in the correct order.
	* Every close bracket has a corresponding open bracket of the same type.

	Example 1:
	Input: s = "()"
	Output: true

	Example 2:
	Input: s = "()[]{}"
	Output: true

	Example 3:
	Input: s = "(]"
	Output: false

	Constraints:
	* 1 <= s.length <= 10^4
	* s consists of parentheses only '()[]{}'.*/

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>(); 
        for (char ch : s.toCharArray()) {
            if (ch == '(') stk.push(')'); 
            else if (ch == '[') stk.push(']'); 
            else if (ch == '{') stk.push('}'); 
            else if (stk.empty() || stk.pop() != ch) return false; 
        }
        return stk.empty(); 
    }


    /*21. Merge Two Sorted Lists (Easy)
	You are given the heads of two sorted linked lists list1 and list2. Merge 
	the two lists in a one sorted list. The list should be made by splicing 
	together the nodes of the first two lists. Return the head of the merged 
	linked list.

	Example 1:
	Input: list1 = [1,2,4], list2 = [1,3,4]
	Output: [1,1,2,3,4,4]

	Example 2:
	Input: list1 = [], list2 = []
	Output: []

	Example 3:
	Input: list1 = [], list2 = [0]
	Output: [0]

	Constraints:
	* The number of nodes in both lists is in the range [0, 50].
	* -100 <= Node.val <= 100
	* Both list1 and list2 are sorted in non-decreasing order.*/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), node = dummy; 
        while (list1 != null && list2 != null) 
            if (list1.val < list2.val) {
                node = node.next = list1; 
                list1 = list1.next; 
            } else {
                node = node.next = list2; 
                list2 = list2.next; 
            }
        if (list1 != null) node.next = list1; 
        if (list2 != null) node.next = list2; 
        return dummy.next; 
    }


    /*26. Remove Duplicates from Sorted Array (Easy)
	Given an integer array nums sorted in non-decreasing order, remove the 
	duplicates in-place such that each unique element appears only once. The 
	relative order of the elements should be kept the same. Since it is 
	impossible to change the length of the array in some languages, you must 
	instead have the result be placed in the first part of the array nums. More 
	formally, if there are k elements after removing the duplicates, then the 
	first k elements of nums should hold the final result. It does not matter 
	what you leave beyond the first k elements. Return k after placing the 
	final result in the first k slots of nums. Do not allocate extra space for 
	another array. You must do this by modifying the input array in-place with 
	O(1) extra memory.

	Custom Judge:
	The judge will test your solution with the following code:

	int[] nums = [...]; // Input array
	int[] expectedNums = [...]; // The expected answer with correct length

	int k = removeDuplicates(nums); // Calls your implementation

	assert k == expectedNums.length;
	for (int i = 0; i < k; i++) {
	    assert nums[i] == expectedNums[i];
	}
	If all assertions pass, then your solution will be accepted.

	Example 1:
	Input: nums = [1,1,2]
	Output: 2, nums = [1,2,_]
	Explanation: Your function should return k = 2, with the first two elements 
	             of nums being 1 and 2 respectively. It does not matter what 
	             you leave beyond the returned k (hence they are underscores).
	
	Example 2:
	Input: nums = [0,0,1,1,1,2,2,3,3,4]
	Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
	Explanation: Your function should return k = 5, with the first five 
	             elements of nums being 0, 1, 2, 3, and 4 respectively. It does 
	             not matter what you leave beyond the returned k (hence they 
	             are underscores).

	Constraints:
	* 1 <= nums.length <= 3 * 10^4
	* -100 <= nums[i] <= 100
	* nums is sorted in non-decreasing order.*/

    public int removeDuplicates(int[] nums) {
        int i = 0; 
        for (int x : nums) 
            if (i == 0 || nums[i-1] < x) nums[i++] = x; 
        return i; 
    }
}