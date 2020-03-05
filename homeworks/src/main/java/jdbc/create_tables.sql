CREATE TABLE accomodation (
    id INTEGER PRIMARY KEY,
    type VARCHAR(32),
    bed_type VARCHAR(32),
    max_guests INTEGER,
    description VARCHAR(512)
);

CREATE TABLE room_fair (
    id INTEGER PRIMARY KEY,
    value DOUBLE PRECISION,
    season VARCHAR(32)
);

CREATE TABLE accomodation_fair_relation (
    id INTEGER PRIMARY KEY ,
    id_accommodation INTEGER,
    id_room_fair INTEGER,
    CONSTRAINT fk_accommodation
        FOREIGN KEY (id_accommodation) REFERENCES accomodation(id),
    CONSTRAINT fk_room_fair
        FOREIGN KEY (id_room_fair) REFERENCES room_fair(id)
);