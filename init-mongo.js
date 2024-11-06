db = db.getSiblingDB('wiki-managment');

db.createCollection('wiki');

db['wiki'].createIndex({
    "wikiId": "550e8400-e29b-41d4-a716-446655440000",
    "title": "Ejemplo de Wiki",
    "description": "Descripción detallada de la wiki.",
    "entryEntities": [
        {
            "entryId": "1",
            "content": "Contenido de la entrada 1"
        },
        {
            "entryId": "2",
            "content": "Contenido de la entrada 2"
        }
    ],
    "userEntity": {
        "userId": "12345",
        "username": "autorEjemplo"
    }
});