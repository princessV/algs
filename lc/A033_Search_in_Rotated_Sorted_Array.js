/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */

var search = function(nums, target) {
    let low = 0, high = nums.length - 1;

    while (low < high) {
        let mid = Math.floor((low + high) / 2);
        
        if (nums[mid] === target) return mid;
        
        if (nums[mid] > nums[high]) {
            if (nums[mid] > target && nums[low] <= target) high = mid;
            else low = mid + 1;
        } else if (num[mid] < nums[high]) {
            if (nums[mid] < target && nums[high] >= target) low = mid + 1;
            else high = mid;
        } else {
            high--;
        }
    }

    return nums[low] === target ? low : - 1;
};

console.log(search([1], 2));