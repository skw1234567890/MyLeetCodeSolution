/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        if(root.left == null && root.right == null){
            if(root.val == sum){
                List<Integer> e = new LinkedList<>();
                e.add(root.val);
                results.add(e);
                return results;
            } else{
                return results;
            }
        }
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        if(left != null){
            for(List<Integer> list : left){
                if(list != null){
                    list.add(0, root.val);
                    results.add(list);
                }
            }
        }
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        if(right != null){
            for(List<Integer> list: right){
                if(list != null){
                    list.add(0, root.val);
                    results.add(list);
                }
            }
        }
        return results;
    }
}