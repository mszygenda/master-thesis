START comment=node(1), john=node:nameIndex("name:John")
CREATE 
newFriend { name: "New friend" },
john-[:KNOWS]->newFriend-[:LIKES]->comment
RETURN newFriend.id
