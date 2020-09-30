SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[ListarEmpleado]
AS
SELECT EMPLEADO.IDEMP, EMPLEADO.NOMEMP, EMPLEADO.APEPATEMP, EMPLEADO.APEMATEMP, 
EMPLEADO.CELEMP, EMPLEADO.DNIEMP, EMPLEADO.SEXEMP, EMPLEADO.TIPEMP, EMPLEADO.ESTEMP, 
SUCURSAL.IDSUC, SUCURSAL.DISSUC FROM EMPLEADO
INNER JOIN SUCURSAL ON SUCURSAL.IDSUC = EMPLEADO.IDSUC WHERE EMPLEADO.ESTEMP = 'A'
GO
