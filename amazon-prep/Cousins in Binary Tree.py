'''
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        q = [root]
        while q:
            c = []
            s = set()
            for i in q:
                if i.left and i.right and ((i.left.val == x and i.right.val == y) or (i.left.val == y and i.right.val == x)): return False
                if i.left: 
                    c.append(i.left)
                    s.add(i.left.val)
                if i.right: 
                    c.append(i.right)
                    s.add(i.right.val)
            if x in s and y in s: return True
            q = c
        return False