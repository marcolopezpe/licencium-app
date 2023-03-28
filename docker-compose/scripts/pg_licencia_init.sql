\c db_licencia;

CREATE TABLE tb_licencia (
    id uuid                     default gen_random_uuid() not null primary key,
    numero_licencia             varchar(50),
    clase                       varchar(50),
    fecha_expedicion            date,
    categoria                   varchar(20),
    fecha_revalidacion          date,
    restricciones               varchar(200),
    cliente_numero_documento    varchar(20)
);

INSERT INTO tb_licencia
    (numero_licencia, clase, fecha_expedicion, categoria, fecha_revalidacion, restricciones, cliente_numero_documento)
VALUES
    ('Q46491904', 'A', '2010-01-08', 'Dos a profesional', '2027-08-01', 'SIN RESTRICCIONES', '46491904');
