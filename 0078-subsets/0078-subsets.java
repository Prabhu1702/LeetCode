class Solution {
    private void subsetsum(int ind, int sum,int [] arr, List<List<Integer>> ans, List<Integer> ds){
        if(ind==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
         ds.add(arr[ind]);
        subsetsum(ind+1,sum +arr[ind],arr,ans,ds);
         ds.remove(ds.size()-1);
        subsetsum(ind+1,sum,arr,ans,ds);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        subsetsum(0, 0, nums, ans, new ArrayList<>());
        return ans;
    }
}