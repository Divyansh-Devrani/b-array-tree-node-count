/** CREATED N ARRAY TREE AND WRITE RESURSIVE FUNC TO CALCULATE NODES AND CHiLD NODE USING RECURSSION */
/**
 * These two function finds the total no of nodes and total no of child nodes
 *

  def nodeCountRecursive( root: TreeNode): Int = {
    var count = 1
    if (root == null) return 0
    else {
      for (child <- root.child) {
        count += nodeCountRecursive(child)
      }
    }
    count
  }

  def nodeChildCountRecursive( root: TreeNode): Int = {
    var count = 0
    if (root == null) return 0
    else {
      if (root.child.size > 0) count += 1
      for (child <- root.child) {
        count += nodeChildCountRecursive(child)
      }
    }
    count
  }
 */

import scala.collection.mutable._

class TreeNode(var key: Int,var child: ArrayBuffer[TreeNode])
{
  def this(key: Int)
  {
    this(key, new ArrayBuffer[TreeNode]())
  }
  def addChild(key: Int): Unit = {
    var t: TreeNode = new TreeNode(key)
    this.child += t
  }
}


class NAryTree(var root: TreeNode)
{
  def this()
  {
    this(null)
  }
  def printPreorder(node: TreeNode): Unit = {
    if (node == null)
    {
      return
    }
    var i: Int = 0
    var temp: TreeNode = null
    print("  " + node.key)
    // iterating the child of given node
    while (i < node.child.size)
    {
      temp = node.child(i)
      printPreorder(temp)
      i += 1
    }

  }
  /**------------Count node ------------*/
  def nodeCountRecursive( root: TreeNode): Int = {
    var count = 1
    if (root == null) return 0
    else {
      for (child <- root.child) {
        count += nodeCountRecursive(child)
      }
    }
    count
  }

  /**-----------Count child node----------------*/
  def nodeChildCountRecursive( root: TreeNode): Int = {
    var count = 0
    if (root == null) return 0
    else {
      if (root.child.size > 0) count += 1
      for (child <- root.child) {
        count += nodeChildCountRecursive(child)
      }
    }
    count
  }
}

object NArrayTree extends App
{
    var narytree = new NAryTree()
    narytree.root = new TreeNode(1)
    narytree.root.addChild(2)
    narytree.root.addChild(3)
    narytree.root.child(0).addChild(4)
    narytree.root.child(0).addChild(5)
    narytree.root.child(0).addChild(6)
    narytree.root.child(0).child(1).addChild(7)
    narytree.root.child(0).child(1).addChild(8)
    narytree.root.child(1).addChild(9)
    narytree.root.child(1).addChild(10)
    narytree.root.child(1).addChild(11)
    narytree.root.child(1).addChild(12)
    narytree.root.child(1).child(0).addChild(13)
    narytree.root.child(1).child(3).addChild(14)
    narytree.root.child(1).child(3).addChild(15)
    narytree.root.child(1).child(3).addChild(16)
    print("\n  Preorder : \n")
    // Print tree element
    narytree.printPreorder(narytree.root)
    println("\n Node Count")
    println(narytree.nodeCountRecursive(narytree.root))
    println("\n Child Node Count")
    println(narytree.nodeChildCountRecursive(narytree.root))

}






