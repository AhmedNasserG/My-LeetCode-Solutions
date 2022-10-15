        sort(nums, mid + 1, end, results);
        
        List<int[]> list = new ArrayList();
        
        int l = start, r = mid + 1;
        int numOfSmallElementsInRight = 0;
        
        while (l <= mid && r <= end) {
            if (nums[l][0] > nums[r][0]) {
                numOfSmallElementsInRight++;
                list.add(nums[r]);
                r++;
            } else {
                list.add(nums[l]);
                results[nums[l][1]] += numOfSmallElementsInRight;
                l++;
            }
        }
        
        while (l <= mid) {
            list.add(nums[l]);
            results[nums[l][1]] += numOfSmallElementsInRight;
            l++;
        }
        
        while (r <= end) {
            list.add(nums[r]);
            r++;
        }
        
        for (int k = start; k <= end; k++) {
            nums[k] = list.get(k - start);
        }
        
    }
}
