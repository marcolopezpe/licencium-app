\c db_licencia;

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


CREATE TABLE tb_licencia (
    id uuid                     default gen_random_uuid() not null primary key,
    numero_licencia             varchar(50),
    clase                       varchar(50),
    fecha_expedicion            date,
    categoria                   varchar(20),
    fecha_revalidacion          date,
    restricciones               varchar(200),
    cliente_id                  uuid,
    CONSTRAINT fk_licencia_cliente
        FOREIGN KEY (cliente_id)
            REFERENCES tb_cliente (id)
);

INSERT INTO tb_licencia
    (numero_licencia, clase, fecha_expedicion, categoria, fecha_revalidacion, restricciones, cliente_id)
VALUES
    ('Q46491904', 'A', '2010-01-08', 'Dos a profesional', '2027-08-01', 'SIN RESTRICCIONES', 'fee67de8-495d-493c-ad27-236b26dc96f6');
