// Zwykłe wyrażenie Boolean
val justBooleanExpr: Boolean = john.name == "John"

// Wyrażenie Boolean zamienione na instancję 
// własnej klasy Condition przy pomocy makra
val nameCondition: Condition = boolExprToCondition(john.name == "John")

// Makro wywołane w sposób niejawny (implicit conversions)
// W ten sposób makro wykorzystywane jest w zapytaniach NeoDSL
val nameConditionImplicit: Condition = john.name == "John"
