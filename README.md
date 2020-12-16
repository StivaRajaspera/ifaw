# ifaw

Afin de lancer l'application, assurez-vous de bien importer le projet dans Spring Tools, 
et créer une base de donnée "agora" en isérant le code sql suivant : 

    INSERT INTO user (enabled, password, username) VALUES (0b1, "$2a$04$BCVKq5e3vTl7GgWZQ6eoJ.bXRT2E50.h1QiWS9.ZMXOL3SZcLrgie", "service_technique");
    INSERT INTO role (id, role) VALUES (1, "ROLE_TECH"); 
    INSERT INTO user_role (user_id, role_id) VALUES (1,1);

Bonne navigation !

- Anastasiya Velychko
- Stiva Rajaspera
- Asma Henoune
- Duc-Chin Phamh
- Taoufiq Kounaidi
- Ruffine Maffo Mbemo
