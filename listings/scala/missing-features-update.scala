// Wzorce niestniejące w bazie
val patterns = { john knows matthew } and
               { matthew likes comment }

// Utworzenie wspomnianych wzorców
patterns.create

// Węzeł który nie istnieje w bazie
val andy = Person("Andy")

// Utworzenie nowego węzła i relacji w jednym kroku
{ 
  john knows andy 
} createAndSelect(andy)

val bob = Person("Bob")

// Utworzenie węzła Bob w bazie
bob.create

// Aktualizacja istniejącego węzła
john.update { "name" -> "Josh" }
