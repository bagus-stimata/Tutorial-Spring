--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-10 23:58:59 WIB

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

--
-- TOC entry 3157 (class 0 OID 16539)
-- Dependencies: 203
-- Data for Name: fuser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fuser (id, email, first_name, last_name, locked, password_hash, role) FROM stdin;
1	bagus	bagus	winarno	f	hacker	\N
2	anis	anis	winarni	f	hacker	\N
\.


--
-- TOC entry 3158 (class 0 OID 16547)
-- Dependencies: 204
-- Data for Name: fuser_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fuser_roles (id, roleid, fuser_bean) FROM stdin;
1	ADMIN	1
2	USER	1
3	USER	2
4	ACCOUNTING	2
\.


--
-- TOC entry 3159 (class 0 OID 16552)
-- Dependencies: 205
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.person (id, address, name) FROM stdin;
\.


--
-- TOC entry 3160 (class 0 OID 16560)
-- Dependencies: 206
-- Data for Name: todo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.todo (id, date_from, date_to, description, person_bean) FROM stdin;
\.


--
-- TOC entry 3166 (class 0 OID 0)
-- Dependencies: 202
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


-- Completed on 2020-05-10 23:58:59 WIB

--
-- PostgreSQL database dump complete
--

