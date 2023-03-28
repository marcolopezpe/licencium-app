\c db_cliente;

CREATE TABLE tb_cliente (
    id uuid                 default gen_random_uuid() not null primary key,
    apellidos               varchar(100),
    nombres                 varchar(100),
    numero_documento        varchar(20),
    fecha_nacimiento        date,
    domicilio               varchar(500),
    grupo_factor_sanguineo  varchar(20),
    donacion_organos        boolean
);

INSERT INTO tb_cliente 
    (id, apellidos, nombres, numero_documento, fecha_nacimiento, domicilio, grupo_factor_sanguineo, donacion_organos)
VALUES 
    ('fee67de8-495d-493c-ad27-236b26dc96f6', 'LOPEZ', 'CAMACHO', '46491904', '1990-08-31', 'SAN JUAN DE MIRAFLORES', 'O+', FALSE);
