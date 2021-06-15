-- public.geofence definition

-- Drop table

-- DROP TABLE public.geofence;

CREATE TABLE public.geofence (
	id int8 NOT NULL,
	longitude float8 NOT NULL,
	latitude float8 NOT NULL,
	city varchar(255) NULL,
	google_address varchar(255) NULL,
	"timestamp" timestamp NULL DEFAULT now(),
	radius float8 NOT NULL
);


-- public.advertiser definition

-- Drop table

-- DROP TABLE public.advertiser;

CREATE TABLE public.advertiser (
	id varchar NOT NULL,
	"name" varchar NULL,
	latitude float8 NOT NULL,
	longitude float8 NOT NULL,
	url varchar NULL,
	url_code varchar NULL
);