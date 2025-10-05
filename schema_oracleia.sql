-- schema_oracleia.sql
-- Script para Oracle 19c: crea tablas y puebla con 20 registros cada una.

-- ============================================
--   ELIMINAR TABLAS SI EXISTEN
-- ============================================

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE FACTURA';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE PROYECTO';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE EMPLEADO';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE CLIENTE';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE TECNOLOGIA';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE EMPRESA';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- ============================================
--   CREACIÓN DE TABLAS
-- ============================================

CREATE TABLE EMPRESA (
    id_empresa NUMBER PRIMARY KEY,
    nombre VARCHAR2(100),
    direccion VARCHAR2(200),
    telefono VARCHAR2(20)
);

CREATE TABLE EMPLEADO (
    id_empleado NUMBER PRIMARY KEY,
    nombre VARCHAR2(100),
    puesto VARCHAR2(50),
    salario NUMBER,
    id_empresa NUMBER REFERENCES EMPRESA(id_empresa)
);

CREATE TABLE PROYECTO (
    id_proyecto NUMBER PRIMARY KEY,
    nombre VARCHAR2(100),
    fecha_inicio DATE,
    fecha_fin DATE,
    id_empresa NUMBER REFERENCES EMPRESA(id_empresa)
);

CREATE TABLE CLIENTE (
    id_cliente NUMBER PRIMARY KEY,
    nombre VARCHAR2(100),
    email VARCHAR2(100),
    telefono VARCHAR2(20)
);

CREATE TABLE FACTURA (
    id_factura NUMBER PRIMARY KEY,
    id_cliente NUMBER REFERENCES CLIENTE(id_cliente),
    id_proyecto NUMBER REFERENCES PROYECTO(id_proyecto),
    monto NUMBER,
    fecha_emision DATE
);

CREATE TABLE TECNOLOGIA (
    id_tecnologia NUMBER PRIMARY KEY,
    nombre VARCHAR2(50),
    version VARCHAR2(20)
);

-- ============================================
--   INSERCIÓN DE DATOS
-- ============================================

-- EMPRESA
BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO EMPRESA (id_empresa, nombre, direccion, telefono)
        VALUES (i, 'Empresa '||i, 'Calle '||i||', Ciudad', '555-100'||LPAD(i,2,'0'));
    END LOOP;
    COMMIT;
END;
/

-- CLIENTE
BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO CLIENTE (id_cliente, nombre, email, telefono)
        VALUES (i, 'Cliente '||i, 'cliente'||i||'@cliente.com', '555-200'||LPAD(i,2,'0'));
    END LOOP;
    COMMIT;
END;
/

-- PROYECTO
BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO PROYECTO (id_proyecto, nombre, fecha_inicio, fecha_fin, id_empresa)
        VALUES (i, 'Proyecto '||i, SYSDATE - (i*7), SYSDATE + (i*15), i);
    END LOOP;
    COMMIT;
END;
/

-- TECNOLOGIA  ✅ corregido
BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO TECNOLOGIA (id_tecnologia, nombre, version)
        VALUES (i, 'Tecnologia '||i, 'v' || (MOD(i,5)+1) || '.0');
    END LOOP;
    COMMIT;
END;
/

-- EMPLEADO  ✅ corregido
BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO EMPLEADO (id_empleado, nombre, puesto, salario, id_empresa)
        VALUES (i, 'Empleado '||i, 'Puesto ' || (MOD(i,5)+1), 2500 + i*120, i);
    END LOOP;
    COMMIT;
END;
/

-- FACTURA
BEGIN
    FOR i IN 1..20 LOOP
        INSERT INTO FACTURA (id_factura, id_cliente, id_proyecto, monto, fecha_emision)
        VALUES (i, MOD(i-1,20)+1, MOD(i-1,20)+1, 500 + i*75, SYSDATE - (i*3));
    END LOOP;
    COMMIT;
END;
/

-- ============================================
--   FIN DEL SCRIPT
-- ============================================
PROMPT '✅ Script ejecutado correctamente. Tablas y datos creados con éxito.';

-- join tablas :. 
SELECT
    c.id_cliente,
    c.nombre AS nombre_cliente,
    c.email,
    f.id_factura,
    f.monto,
    f.fecha_emision,
    p.id_proyecto,
    p.nombre AS nombre_proyecto,
    e.id_empresa,
    e.nombre AS nombre_empresa,
    emp.id_empleado,
    emp.nombre AS nombre_empleado,
    emp.puesto,
    emp.salario
FROM FACTURA f
JOIN CLIENTE c
    ON f.id_cliente = c.id_cliente
JOIN PROYECTO p
    ON f.id_proyecto = p.id_proyecto
JOIN EMPRESA e
    ON p.id_empresa = e.id_empresa
JOIN EMPLEADO emp
    ON emp.id_empresa = e.id_empresa
ORDER BY c.id_cliente, f.id_factura;
