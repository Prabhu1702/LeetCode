class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findleft(nums,target);
        int second=findright(nums,target);
        return new int[]{first, second};
    }

    private int findleft(int[] nums, int target){
        int index=-1;
        int left=0 , right= nums.length-1;

        while(left<=right){
            int mid= left + (right - left) / 2;
            if(target==nums[mid]){
                index= mid;
                right=mid-1;
            }
            else if (target> nums[mid]){
                left=mid+1;
            }
            else
                right=mid-1;
        }
        return index;
    }

    private int findright(int[] nums, int target){
        int index=-1;
        int left=0, right= nums.length-1;

        while(left<=right){
         int mid=left + (right-left)/2;
         if(nums[mid]==target){
            index=mid;
            left=mid+1;
         }

         else if (target>nums[mid]){
            left= mid +1;
         }
         else 
            right=mid-1;
        }
        return index;
    }
}