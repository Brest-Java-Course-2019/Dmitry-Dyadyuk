
-- Table address

CREATE TABLE IF NOT EXISTS address (
                                     id_address BIGSERIAL  NOT NULL,
                                     address_name VARCHAR(1024) NOT NULL,
                                     PRIMARY KEY (id_address));




-- Table hotel

CREATE TABLE IF NOT EXISTS hotel (
                                   id_hotel BIGSERIAL  NOT NULL,
                                   contact VARCHAR(45) NOT NULL,
                                   hotel_type VARCHAR(45) NOT NULL,
                                   address BIGSERIAL NOT NULL,
                                   PRIMARY KEY (id_hotel),
                                   FOREIGN KEY (address)
                                   REFERENCES address (id_address)
                                   ON DELETE NO ACTION
                                   ON UPDATE NO ACTION);

-- Table room_capacity

CREATE TABLE IF NOT EXISTS room_capacity (
                                           id_room_capacity BIGSERIAL  NOT NULL,
                                           capacity INT NOT NULL,
                                           PRIMARY KEY (id_room_capacity));




-- Table room_type

CREATE TABLE IF NOT EXISTS room_type (
                                       id_room_type BIGSERIAL  NOT NULL,
                                       type_name VARCHAR(45) NOT NULL,
                                       PRIMARY KEY (id_room_type));




-- Table room

CREATE TABLE IF NOT EXISTS room (
                                  id_room BIGSERIAL  NOT NULL,
                                  status VARCHAR(45) NOT NULL,
                                  price_per_hour FLOAT NOT NULL,
                                  hotel BIGSERIAL NOT NULL,
                                  room_capacity INT NOT NULL,
                                  room_type INT NOT NULL,
                                  PRIMARY KEY (id_room, hotel),
                                    FOREIGN KEY (hotel)
                                      REFERENCES hotel (id_hotel)
                                      ON DELETE NO ACTION
                                      ON UPDATE NO ACTION,

                                    FOREIGN KEY (room_capacity)
                                      REFERENCES room_capacity (id_room_capacity)
                                      ON DELETE NO ACTION
                                      ON UPDATE NO ACTION,

                                    FOREIGN KEY (room_type)
                                      REFERENCES room_type (id_room_type)
                                      ON DELETE NO ACTION
                                      ON UPDATE NO ACTION);




-- Table user_type

CREATE TABLE IF NOT EXISTS user_type (
                                       id_user_type BIGSERIAL  NOT NULL,
                                       type_name VARCHAR(45) NOT NULL,
                                       PRIMARY KEY (id_user_type));



-- Table user

CREATE TABLE IF NOT EXISTS app_user (
                                      id_app_user BIGSERIAL NOT NULL,
                                      email VARCHAR(45) NOT NULL,
                                      password VARCHAR(45) NOT NULL,
                                      phone VARCHAR(45) NOT NULL,
                                      address BIGSERIAL NOT NULL,
                                      user_type INT NOT NULL,
                                      PRIMARY KEY (id_app_user, email, user_type),
                                        FOREIGN KEY (address)
                                          REFERENCES address (id_address)
                                          ON DELETE NO ACTION
                                          ON UPDATE NO ACTION,
                                        FOREIGN KEY (user_type)
                                          REFERENCES user_type (id_user_type)
                                          ON DELETE NO ACTION
                                          ON UPDATE NO ACTION);



-- Table guest

CREATE TABLE IF NOT EXISTS guest (
                                   id_guest BIGSERIAL  NOT NULL,
                                   user_id BIGSERIAL NOT NULL,
                                   PRIMARY KEY (id_guest, user_id),
                                     FOREIGN KEY (user_id)
                                       REFERENCES app_user (id_app_user)
                                       ON DELETE NO ACTION
                                       ON UPDATE NO ACTION);



-- Table reservation

CREATE TABLE IF NOT EXISTS reservation (
                                         country VARCHAR(45) NOT NULL,
                                         room_type VARCHAR(45) NOT NULL,
                                         start_booking DATE NOT NULL,
                                         end_booking DATE NOT NULL,
                                         guest BIGSERIAL NOT NULL,
                                         room BIGSERIAL NOT NULL,
                                         hotel BIGSERIAL NOT NULL,
                                         PRIMARY KEY (guest, room, hotel, start_booking),
                                           FOREIGN KEY (guest)
                                             REFERENCES guest (id_guest)
                                             ON DELETE NO ACTION
                                             ON UPDATE NO ACTION,
                                           FOREIGN KEY (room , hotel)
                                             REFERENCES room (id_room , hotel)
                                             ON DELETE NO ACTION
                                             ON UPDATE NO ACTION);
