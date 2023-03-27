\c db_usuario;

CREATE TABLE tb_usuario (
    id uuid 		default gen_random_uuid() not null primary key,
    nombres			varchar(100),
    apellidos		varchar(100),
    nombre_usuario	varchar(100),
    contrasena		varchar(100),
    email			varchar(100)
);

INSERT INTO tb_usuario (nombres, apellidos, nombre_usuario, contrasena, email)
VALUES ('MARCO', 'LOPEZ', 'ADMIN', '$2a$10$NAy/Mtw9MvWDwVqSA7lF2u2ARSPctp8Gp.8WPIfVqFdu8RIopjws.', 'MARCOLOPEZPE@OUTLOOK.COM');

-- CONTRASENA: admin
