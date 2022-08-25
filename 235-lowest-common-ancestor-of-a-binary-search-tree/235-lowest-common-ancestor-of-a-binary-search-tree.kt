class Solution {
    /**
     * ref.: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives
     * BST, `(root!!.`val` - p!!.`val`) * (root.`val` - q!!.`val`) < 1` 의 뜻은 `root`와 `p` 또는 `q`와 같은 값을 가지고 있음을 의미하기도 하지만,
     * `p`와 `q`가 `root`의 `left`와 `right`에 각각 존재함을 의미한다. 따라서 추가적으로 확인할 필요 없이 `root`가 공통 조상이 된다.
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return if ((root!!.`val` - p!!.`val`) * (root.`val` - q!!.`val`) < 1)  {
            root
        }
        else {
            lowestCommonAncestor(if (p.`val` < root.`val`) root.left else root.right, p, q)
        }
    }
}
