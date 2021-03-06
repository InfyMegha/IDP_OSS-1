--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.3

-- Started on 2018-07-27 14:22:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;


--
-- Name: i2p; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE i2p;


ALTER DATABASE i2p OWNER TO postgres;

\connect i2p


--
-- TOC entry 1 (class 3079 OID 12393)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16600)
-- Name: appinfo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE appinfo (
    id integer NOT NULL,
    application_name text NOT NULL,
    pipeline_name text NOT NULL,
    created_at timestamp without time zone DEFAULT now()
);


ALTER TABLE appinfo OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16607)
-- Name: appinfo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE appinfo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE appinfo_id_seq OWNER TO postgres;

--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 186
-- Name: appinfo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE appinfo_id_seq OWNED BY appinfo.id;


--
-- TOC entry 192 (class 1259 OID 444447)
-- Name: apporg; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE apporg (
    application_name text NOT NULL,
    org_name text NOT NULL
);


ALTER TABLE apporg OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16609)
-- Name: buildinfo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE buildinfo (
    appid integer NOT NULL,
    buildtime numeric NOT NULL,
    buildstatus text NOT NULL,
    buildid integer NOT NULL,
    lastcompletebuildid integer NOT NULL,
    lastsuccessfulbuildid integer NOT NULL,
    lastunstablebuildid integer NOT NULL,
    lastunsuccessfulbuildid integer NOT NULL,
    lastfailedbuildid integer NOT NULL,
    pipelineno integer NOT NULL,
    score numeric NOT NULL,
    stagename text NOT NULL,
    created_at timestamp without time zone DEFAULT now()
);


ALTER TABLE buildinfo OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16616)
-- Name: codeanalysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE codeanalysis (
    appid integer,
    buildid integer NOT NULL,
    pipelineno integer NOT NULL,
    severity text,
    line integer,
    packagename text,
    rulename text,
    category text,
    recommendation text,
    created_at timestamp without time zone DEFAULT now()
);


ALTER TABLE codeanalysis OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16623)
-- Name: codecoverage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE codecoverage (
    appid integer,
    buildid integer NOT NULL,
    pipelineno integer NOT NULL,
    linecoverage integer NOT NULL,
    classname text,
    category text,
    packagename text,
    created_at timestamp without time zone DEFAULT now()
);


ALTER TABLE codecoverage OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 616518)
-- Name: icqa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE icqa (
    appid integer NOT NULL,
    classname text NOT NULL,
    mi text NOT NULL,
    cp text NOT NULL,
    dp text NOT NULL,
    created_at timestamp without time zone DEFAULT now(),
    buildid text
);


ALTER TABLE icqa OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16630)
-- Name: scminfo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE scminfo (
    appid integer,
    pipelineno integer,
    lastmodifiedon text,
    lastmodifiedby text,
    commitmessage text,
    created_at timestamp without time zone DEFAULT now(),
    affectedpath text
);


ALTER TABLE scminfo OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16637)
-- Name: testanalysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE testanalysis (
    appid integer,
    buildid integer NOT NULL,
    pipelineno integer NOT NULL,
    packagename text,
    message text,
    testsuitename text,
    category text,
    status text,
    duration numeric,
    created_at timestamp without time zone DEFAULT now()
);


ALTER TABLE testanalysis OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 444455)
-- Name: userorg; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE userorg (
    user_name text NOT NULL,
    org_name text NOT NULL
);


ALTER TABLE userorg OWNER TO postgres;

--
-- TOC entry 2047 (class 2604 OID 16644)
-- Name: appinfo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appinfo ALTER COLUMN id SET DEFAULT nextval('appinfo_id_seq'::regclass);


--
-- TOC entry 2055 (class 2606 OID 16646)
-- Name: appinfo appinfo_application_name_pipeline_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appinfo
    ADD CONSTRAINT appinfo_application_name_pipeline_name_key UNIQUE (application_name, pipeline_name);


--
-- TOC entry 2057 (class 2606 OID 16648)
-- Name: appinfo appinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appinfo
    ADD CONSTRAINT appinfo_pkey PRIMARY KEY (id);


--
-- TOC entry 2061 (class 2606 OID 444454)
-- Name: apporg apporg_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY apporg
    ADD CONSTRAINT apporg_pkey PRIMARY KEY (application_name);


--
-- TOC entry 2059 (class 2606 OID 16650)
-- Name: buildinfo buildinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY buildinfo
    ADD CONSTRAINT buildinfo_pkey PRIMARY KEY (appid, buildid, stagename);


--
-- TOC entry 2063 (class 2606 OID 444462)
-- Name: userorg userorg_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY userorg
    ADD CONSTRAINT userorg_pkey PRIMARY KEY (user_name);


--
-- TOC entry 2064 (class 2606 OID 16651)
-- Name: buildinfo buildinfo_appid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY buildinfo
    ADD CONSTRAINT buildinfo_appid_fkey FOREIGN KEY (appid) REFERENCES appinfo(id);


--
-- TOC entry 2069 (class 2606 OID 616527)
-- Name: icqa buildinfo_appid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY icqa
    ADD CONSTRAINT buildinfo_appid_fkey FOREIGN KEY (appid) REFERENCES appinfo(id);


--
-- TOC entry 2065 (class 2606 OID 16656)
-- Name: codeanalysis codeanalysis_appid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY codeanalysis
    ADD CONSTRAINT codeanalysis_appid_fkey FOREIGN KEY (appid) REFERENCES appinfo(id);


--
-- TOC entry 2066 (class 2606 OID 16661)
-- Name: codecoverage codecoverage_appid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY codecoverage
    ADD CONSTRAINT codecoverage_appid_fkey FOREIGN KEY (appid) REFERENCES appinfo(id);


--
-- TOC entry 2067 (class 2606 OID 16666)
-- Name: scminfo scminfo_appid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scminfo
    ADD CONSTRAINT scminfo_appid_fkey FOREIGN KEY (appid) REFERENCES appinfo(id);


--
-- TOC entry 2068 (class 2606 OID 16671)
-- Name: testanalysis testanalysis_appid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY testanalysis
    ADD CONSTRAINT testanalysis_appid_fkey FOREIGN KEY (appid) REFERENCES appinfo(id);


	
	
INSERT INTO userorg(user_name,org_name) VALUES('idpadmin@infosys.com','INFOSYS');
	
	
-- Completed on 2018-07-27 14:23:25

--
-- PostgreSQL database dump complete
--

