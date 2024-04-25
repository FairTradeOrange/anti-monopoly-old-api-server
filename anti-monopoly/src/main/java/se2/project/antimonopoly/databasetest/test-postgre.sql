CREATE TABLE game (
                      id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                      code VARCHAR(25) NOT NULL UNIQUE,
                      PRIMARY KEY (id)
);

CREATE TABLE player (
                        id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                        name VARCHAR(50) NOT NULL,
                        game_id INTEGER NOT NULL,
                        PRIMARY KEY (id),
                        FOREIGN KEY (game_id) REFERENCES game(id)
);

CREATE TABLE payment (
                         id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                         amount DECIMAL(10, 2) NOT NULL,
                         player_id INTEGER NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (player_id) REFERENCES player(id)
);