// Rozpoczęcie transakcji
Transaction tx = graphDb.beginTx();

try {
  // Utworzenie węzła john
  Node john = graphDb.createNode();  
  john.setProperty("name", "John");

  // Wyszukanie węzła matthew na podstawie identyfikatora
  Node matthew = graphDb.getNodeById(1);

  // Odczytanie listy krawędzi połączonych z matthew
  Iterable<Relationship> relationships = matthew.getRelationships();

  // Utworzenie krawędzi KNOWS pomiędzy john i matthew
  john.createRelationshipTo(
    matthew,
    DynamicRelationshipType.withName("KNOWS")
  );

  // Zakończenie transakcji
  tx.success();
} catch(Exception e) {
  tx.failure();  
} finally {
  tx.finish();
}
