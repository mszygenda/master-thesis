// Definiowanie sposobu przechodzenia grafu
TraversalDescription traversalDesc = Traversal.description().relationships(
    DynamicRelationshipType.withName("KNOWS")
).evaluator(Evaluators.atDepth(1));

// Uruchomienie algorytmu zaczynając od węzła john
Traverser traverser = traversalDesc.traverse(john);

// Odczytanie kolekcji węzłów
Iterable<Node> johnFriends = traverser.nodes();
