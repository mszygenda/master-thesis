trait Tree

case class Node(left: Tree, right: Tree) extends Tree
case class Leaf(value: Int) extends Tree

object TreeProgram {
  def showTree(tree: Tree) {
    tree match {
      case Node(left, right) => {
        showTree(left)
        showTree(right)
      }
      case Leaf(value) => {
        println("Value: " + value)
      }
    }
  } 
}
