SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE public."KullaniciHesabi" (
    id integer NOT NULL,
    "kullaniciadi" character varying(40) NOT NULL,
    sifre character varying(40) NOT NULL
);

ALTER TABLE public."KullaniciHesabi" OWNER TO postgres;

CREATE SEQUENCE public."KullaniciHesabi_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public."KullaniciHesabi_id_seq" OWNER TO postgres;

ALTER SEQUENCE public."KullaniciHesabi_id_seq" OWNED BY public."KullaniciHesabi".id;

ALTER TABLE ONLY public."KullaniciHesabi" ALTER COLUMN id SET DEFAULT nextval('public."KullaniciHesabi_id_seq"'::regclass);

INSERT INTO public."KullaniciHesabi" VALUES
	(1, 'ahmethe', 1),
	(2, 'selmanee', 2);
	
SELECT pg_catalog.setval('public."KullaniciHesabi_id_seq"', 3, true);

ALTER TABLE ONLY public."KullaniciHesabi"
    ADD CONSTRAINT "KullaniciHesabi_pkey" PRIMARY KEY (id);
