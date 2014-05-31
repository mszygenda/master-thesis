# Wysłanie żądania
$ curl http://localhost:7474/db/data/cypher --data '
{ 
  "query": "START john=node(0) MATCH john-[:KNOWS]-friend RETURN friend.name", 
  "params": {} 
}' -H "Content-Type: application/json"

# Odpowiedź serwera
{
  "columns" : [ "friend.name" ],
  "data" : [ [ "Anne" ], [ "Jessica" ] ]
}
