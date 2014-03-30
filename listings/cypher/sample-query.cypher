START comment=node(1), john=node:nameIndex("name:John")
MATCH john-[:KNOWS]->friend->[:LIKES]->comment
RETURN friend.id, friend.name
