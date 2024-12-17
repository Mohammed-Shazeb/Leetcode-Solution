/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const k = new Map();
    for (let i = 0; i < nums.length; i++){
        const num = nums[i];
        if(k.has(target-num)){
            return [k.get(target - num), i];
        }
        k.set(num,i);
    }
    return[];
};
