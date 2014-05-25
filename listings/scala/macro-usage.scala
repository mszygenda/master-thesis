// Zwykle wyrazenie Boolean
val justBooleanExpr: Boolean = john.name == "John"

// Wyrazenie Boolean zamienione
// na instancje wlasnej klasy Condition przy pomocy makra
val nameCondition: Condition = boolExprToCondition(john.name == "John")

// Makro wywolane w sposob niejawny (implicit conversions)
// W ten sposob makro wykorzystywane jest w zapytaniach NeoDSL
val nameConditionImplicit: Condition = john.name == "John"
