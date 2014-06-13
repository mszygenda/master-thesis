class BoolExprToConditionMacro[C <: Context](val context: C) 
extends BooleanExpressionTransformer with ConditionsCodeBuilder {
  import context._

  override def onComparison
  (leftOp: Tree, cmpOp: BinaryComparisonOperator, rightOp: Tree): Tree = {
    val leftSelector = buildSelector(leftOp)
    val rightSelector = buildSelector(rightOp)

    buildPropertyComparison(leftSelector, cmpOp, rightSelector)
  }

  override def onUnaryLogicalOperation
  (leftOp: Tree, operator: UnaryLogicalOperator): Tree = {
    operator match {
      case Not => {
        buildNot(leftOp)
      }
    }
  }

  override def onBinaryLogicalOperation
  (leftOp: Tree, operator: BinaryLogicalOperator, rightOp: Tree): Tree = {
    operator match {
      case Or => {
        buildOr(leftOp, rightOp)
      }
      case And => {
        buildAnd(leftOp, rightOp)
      }
    }
  }

  override def onCustomUnaryOperator
  (leftOp: Tree, customOp: CustomOperator): Tree = {
    val propSelector = buildObjectPropertySelector(leftOp, customOp.name)
    val trueValueSelector = buildSimpleValueSelector(literal(true))

    buildPropertyComparison(propSelector, Eq, trueValueSelector)
  }
}
