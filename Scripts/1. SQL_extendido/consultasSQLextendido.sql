/* Crear un paquete con procedimientos para resolver cada una de las siguientes consultas que usan sql extendido: */

/* Liste totales de cantidad enviada por hemisferio y continente, mostrando subtotales por hemisferio y el gran total */

select nvl(f.hemisferio,'Total') as hemisferio, 
    nvl(f.continente,'Total') as continente, 
    sum(e.cantidadenviada) as cantidadEnviada
from fuente f join envio e on f.id = e.fuenteid
group by rollup(f.hemisferio, f.continente);

/* Liste el hemisferio, el a�o y el total de cantidad enviada; totalice por hemisferio, a�o y total general */}

select nvl(f.hemisferio,'Total') as hemisferio, nvl(to_char(p.anio),'Total') as anio, sum(e.cantidadenviada) as cantidadEnviada
from fuente f join envio e on f.id = e.fuenteid join periodo p on p.id = e.periodoid
group by cube(f.hemisferio, p.anio);

/* Cu�l es el porcentaje de participaci�n de las cantidades enviadas de cada continente en el total enviado de la empresa 
(la suma de todas las cantidades enviadas). Liste el continente, total cantidad enviada por continente, total general enviado, 
porcentaje de participaci�n. */

select f.continente as continente, 
    sum(e.cantidadenviada) as cantidadEnviadaContinente,
    (select sum(cantidadenviada) from envio) as totalGeneralEnviado,
    round( (ratio_to_report(sum(e.cantidadenviada)) over () ) *100 ,2) as porcentajeParticipacion
from fuente f join envio e on f.id = e.fuenteid
group by f.continente;

/* Obtenga un listado por hemisferio del ranking de los continentes que m�s cantidad enviada han hecho. Liste el hemisferio, 
el continente, el total enviado y el n�mero del ranking */

select f.hemisferio, 
    f.continente, 
    sum(e.cantidadenviada) as totalEnviado,
    row_number() over(partition by f.hemisferio order by sum(e.cantidadenviada) desc) as numeroRanking
from fuente f join envio e on f.id = e.fuenteid
group by (f.hemisferio, f.continente)
order by f.hemisferio;

/* Escriba la consulta que genere la siguiente salida de totales de cantidad enviada por hemisferio. Ayuda: use PIVOT */

with parciales as (
    select f.hemisferio as hemisferio, to_char(p.anio) as anio, sum(e.cantidadenviada) as cantidadenviada
    from fuente f join envio e on f.id = e.fuenteid join periodo p on p.id = e.periodoid
    group by (hemisferio,anio)
    UNION
    select f.hemisferio as hemisferio, 'Total' as anio, sum(e.cantidadenviada)
    from fuente f join envio e on f.id = e.fuenteid join periodo p on p.id = e.periodoid
    group by (f.hemisferio)
    UNION
    select 'Totales' as hemisferio, to_char(p.anio) as anio, sum(e.cantidadenviada)
    from fuente f join envio e on f.id = e.fuenteid join periodo p on p.id = e.periodoid
    group by (p.anio)
    UNION
    select 'Totales' as hemisferio, 'Total' as anio, sum(e.cantidadenviada)
    from fuente f join envio e on f.id = e.fuenteid join periodo p on p.id = e.periodoid
)
select * from (
    select hemisferio, anio, cantidadenviada from parciales
)pivot( 
    sum(cantidadenviada) 
    for anio in ('2015', '2016', '2017', '2018', '2019', '2020','Total') 
)
order by hemisferio;
