DROP TABLE IF EXISTS teams CASCADE;
DROP TABLE IF EXISTS developers CASCADE;
DROP SEQUENCE IF EXISTS teams_id_seq CASCADE;
DROP SEQUENCE IF EXISTS developers_id_seq CASCADE;
CREATE TABLE public.teams
(
  team_id integer NOT NULL,
  team_name character varying(255),
  CONSTRAINT teams_pkey PRIMARY KEY (team_id)
);

CREATE TABLE public.developers
(
  id integer NOT NULL,
  name character varying(255),
  phone_number character varying(255),
  team_id integer,
  CONSTRAINT developers_pkey PRIMARY KEY (id),
  CONSTRAINT fkg9bvcwc6ltdrwbp953is3i6dt FOREIGN KEY (team_id)
      REFERENCES public.teams (team_id) 
);

CREATE SEQUENCE public.teams_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999
  START 1;
  
alter table teams alter column team_id set default nextval('teams_id_seq');

CREATE SEQUENCE public.developers_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999
  START 1;
  
  alter table developers alter column id set default nextval('developers_id_seq');