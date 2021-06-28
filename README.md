To run the application open terminal and type
mvn spring-boot:run in the directory of the project.

--------------------------------
You can access main endpoints:
For example:
http://localhost:8080/ (domain)
adv/ (controller api identifier)
newAdvertiser/
>http://localhost:8080/adv/newAdvertiser
with a request body example

{
"latitude":"-77.00",
"longitude":" 30.00",
"radius":"100.000",
"city":"tirane",
"googleAddress":""
}

-------------------------------

To have a working project you need to setup PostgreSql db locally.
And also enable PostGis Extension:
If you  want to use lattest versions of postgresql and Postgis in MAC
it is suggested to use HomeBrew  install commands for both of them.
> Before installing please check version compatibility for postgres and postgis in this 
> link https://trac.osgeo.org/postgis/wiki/UsersWikiPostgreSQLPostGIS
---------------------------------
 For Older postgres version and customized Postgis version it i suggested to download the code 
 from the official page and then enable symbolic lincs example : 

 PostGis 2.xx  and Postgres 9.3
 sudo ln -s  /usr/local/share/postgresql/extension/postgis*  /Library/PostgreSQL/9.3/share/postgresql/extension
 sudo ln -s   /usr/local/lib/postgresql/postgis-2.so   /Library/PostgreSQL/9.3/lib/postgis-2.so
-----------------------------------
Enabble Postgis Extension

-- Enable PostGIS (as of 3.0 contains just geometry/geography)
CREATE EXTENSION postgis;
-- enable raster support (for 3+)
CREATE EXTENSION postgis_raster;
-- Enable Topology
CREATE EXTENSION postgis_topology;

------------------------------------

Enable  main tables:

-- Create table with spatial column
CREATE TABLE mytable (
id SERIAL PRIMARY KEY,
geom GEOMETRY(Point, 26910),
name VARCHAR(128)
);

-- Add a spatial index
CREATE INDEX mytable_gix
ON mytable
USING GIST (geom);

-- Add a point
INSERT INTO mytable (geom) VALUES (
ST_GeomFromText('POINT(0 0)', 26910)
);

-- Query for nearby points
SELECT id, name
FROM mytable
WHERE ST_DWithin(
geom,
ST_GeomFromText('POINT(0 0)', 26910),
1000
);