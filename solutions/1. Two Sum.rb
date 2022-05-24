# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
    hash = {}
    nums.each_with_index do |num, index|
        if hash[target - num]
            return [hash[target - num], index]
        else
            hash[num] = index
        end
    end
end
​
