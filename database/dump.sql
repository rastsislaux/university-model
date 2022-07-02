--
-- PostgreSQL database dump
--

-- Dumped from database version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)
-- Dumped by pg_dump version 14.3 (Ubuntu 14.3-0ubuntu0.22.04.1)

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

--
-- Name: groups; Type: TABLE; Schema: public; Owner: university
--

CREATE TABLE public.groups (
                               id integer NOT NULL,
                               curator_id integer
);


ALTER TABLE public.groups OWNER TO university;

--
-- Name: groups_id_seq; Type: SEQUENCE; Schema: public; Owner: university
--

CREATE SEQUENCE public.groups_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.groups_id_seq OWNER TO university;

--
-- Name: groups_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: university
--

ALTER SEQUENCE public.groups_id_seq OWNED BY public.groups.id;


--
-- Name: lessons; Type: TABLE; Schema: public; Owner: university
--

CREATE TABLE public.lessons (
                                id integer NOT NULL,
                                subject_id integer,
                                teacher_id integer,
                                room_id text,
                                group_id integer,
                                date date
);


ALTER TABLE public.lessons OWNER TO university;

--
-- Name: lessons_id_seq; Type: SEQUENCE; Schema: public; Owner: university
--

CREATE SEQUENCE public.lessons_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lessons_id_seq OWNER TO university;

--
-- Name: lessons_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: university
--

ALTER SEQUENCE public.lessons_id_seq OWNED BY public.lessons.id;


--
-- Name: rooms; Type: TABLE; Schema: public; Owner: university
--

CREATE TABLE public.rooms (
                              number text NOT NULL,
                              responsible_person_id integer
);


ALTER TABLE public.rooms OWNER TO university;

--
-- Name: students; Type: TABLE; Schema: public; Owner: university
--

CREATE TABLE public.students (
                                 id integer NOT NULL,
                                 name text,
                                 group_id integer
);


ALTER TABLE public.students OWNER TO university;

--
-- Name: subjects; Type: TABLE; Schema: public; Owner: university
--

CREATE TABLE public.subjects (
                                 id integer NOT NULL,
                                 name text
);


ALTER TABLE public.subjects OWNER TO university;

--
-- Name: subjects_id_seq; Type: SEQUENCE; Schema: public; Owner: university
--

CREATE SEQUENCE public.subjects_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.subjects_id_seq OWNER TO university;

--
-- Name: subjects_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: university
--

ALTER SEQUENCE public.subjects_id_seq OWNED BY public.subjects.id;


--
-- Name: teachers; Type: TABLE; Schema: public; Owner: university
--

CREATE TABLE public.teachers (
                                 id integer NOT NULL,
                                 name text
);


ALTER TABLE public.teachers OWNER TO university;

--
-- Name: teachers_id_seq; Type: SEQUENCE; Schema: public; Owner: university
--

CREATE SEQUENCE public.teachers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.teachers_id_seq OWNER TO university;

--
-- Name: teachers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: university
--

ALTER SEQUENCE public.teachers_id_seq OWNED BY public.teachers.id;


--
-- Name: groups id; Type: DEFAULT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.groups ALTER COLUMN id SET DEFAULT nextval('public.groups_id_seq'::regclass);


--
-- Name: lessons id; Type: DEFAULT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.lessons ALTER COLUMN id SET DEFAULT nextval('public.lessons_id_seq'::regclass);


--
-- Name: subjects id; Type: DEFAULT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.subjects ALTER COLUMN id SET DEFAULT nextval('public.subjects_id_seq'::regclass);


--
-- Name: teachers id; Type: DEFAULT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.teachers ALTER COLUMN id SET DEFAULT nextval('public.teachers_id_seq'::regclass);


--
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: university
--

COPY public.groups (id, curator_id) FROM stdin;
121701	1
121702	2
121703	3
\.


--
-- Data for Name: lessons; Type: TABLE DATA; Schema: public; Owner: university
--

COPY public.lessons (id, subject_id, teacher_id, room_id, group_id, date) FROM stdin;
1	1	1	404-4к	121701	2022-07-02
2	1	1	405-4к	121702	2022-07-02
3	1	1	202-5к	121703	2022-07-02
4	2	2	202-5к	121701	2022-07-02
5	2	2	404-4к	121702	2022-07-02
6	2	2	405-4к	121703	2022-07-02
8	3	3	202-5к	121702	2022-07-02
9	3	3	404-4к	121703	2022-07-02
10	3	3	405-4к	121701	2022-07-02
11	1	1	404-4к	121701	2022-07-03
12	2	2	405-4к	121702	2022-07-03
13	3	3	202-5к	121703	2022-07-03
\.


--
-- Data for Name: rooms; Type: TABLE DATA; Schema: public; Owner: university
--

COPY public.rooms (number, responsible_person_id) FROM stdin;
404-4к	1
405-4к	2
202-5к	3
\.


--
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: university
--

COPY public.students (id, name, group_id) FROM stdin;
12170044	Студентов А. А.	121701
12170045	Тестов Б. Б.	121702
12170046	Новов В. В.	121703
12170047	Нанов Г. Г.	121701
12170048	Парков Д. Д.	121702
12170049	Никонов Е. Е.	121703
12170050	Тестовый З. З.	121701
12170051	Новый И. И.	121701
12170055	Гагарин Ю. А.	121701
12170052	Веселый И. А.	121702
12170053	Иванов Е. Е.	121702
12170054	Никитин Н. Н.	121702
12170056	Второй Е. В.	121703
12170057	Орлов А. Е.	121703
12170058	Павлов П. В.	121703
\.


--
-- Data for Name: subjects; Type: TABLE DATA; Schema: public; Owner: university
--

COPY public.subjects (id, name) FROM stdin;
1	Физика
2	Математика
3	Программирование
\.


--
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: university
--

COPY public.teachers (id, name) FROM stdin;
1	Первый А. А.
2	Второй Б. Б.
3	Третий В. В.
\.


--
-- Name: groups_id_seq; Type: SEQUENCE SET; Schema: public; Owner: university
--

SELECT pg_catalog.setval('public.groups_id_seq', 1, false);


--
-- Name: lessons_id_seq; Type: SEQUENCE SET; Schema: public; Owner: university
--

SELECT pg_catalog.setval('public.lessons_id_seq', 13, true);


--
-- Name: subjects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: university
--

SELECT pg_catalog.setval('public.subjects_id_seq', 3, true);


--
-- Name: teachers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: university
--

SELECT pg_catalog.setval('public.teachers_id_seq', 3, true);


--
-- Name: groups groups_pk; Type: CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_pk PRIMARY KEY (id);


--
-- Name: lessons lessons_pk; Type: CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT lessons_pk PRIMARY KEY (id);


--
-- Name: rooms rooms_pk; Type: CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.rooms
    ADD CONSTRAINT rooms_pk PRIMARY KEY (number);


--
-- Name: students students_pk; Type: CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pk PRIMARY KEY (id);


--
-- Name: subjects subjects_pk; Type: CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.subjects
    ADD CONSTRAINT subjects_pk PRIMARY KEY (id);


--
-- Name: teachers teachers_pk; Type: CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_pk PRIMARY KEY (id);


--
-- Name: groups_id_uindex; Type: INDEX; Schema: public; Owner: university
--

CREATE UNIQUE INDEX groups_id_uindex ON public.groups USING btree (id);


--
-- Name: lessons_id_uindex; Type: INDEX; Schema: public; Owner: university
--

CREATE UNIQUE INDEX lessons_id_uindex ON public.lessons USING btree (id);


--
-- Name: rooms_number_uindex; Type: INDEX; Schema: public; Owner: university
--

CREATE UNIQUE INDEX rooms_number_uindex ON public.rooms USING btree (number);


--
-- Name: students_id_uindex; Type: INDEX; Schema: public; Owner: university
--

CREATE UNIQUE INDEX students_id_uindex ON public.students USING btree (id);


--
-- Name: subjects_id_uindex; Type: INDEX; Schema: public; Owner: university
--

CREATE UNIQUE INDEX subjects_id_uindex ON public.subjects USING btree (id);


--
-- Name: teachers_id_uindex; Type: INDEX; Schema: public; Owner: university
--

CREATE UNIQUE INDEX teachers_id_uindex ON public.teachers USING btree (id);


--
-- Name: groups curator_fk; Type: FK CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT curator_fk FOREIGN KEY (curator_id) REFERENCES public.teachers(id);


--
-- Name: students group_fk; Type: FK CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT group_fk FOREIGN KEY (group_id) REFERENCES public.groups(id);


--
-- Name: rooms responsible_person_fk; Type: FK CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.rooms
    ADD CONSTRAINT responsible_person_fk FOREIGN KEY (responsible_person_id) REFERENCES public.teachers(id);


--
-- Name: lessons room_fk; Type: FK CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT room_fk FOREIGN KEY (room_id) REFERENCES public.rooms(number);


--
-- Name: lessons subject_fk; Type: FK CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT subject_fk FOREIGN KEY (subject_id) REFERENCES public.subjects(id);


--
-- Name: lessons teacher_fk; Type: FK CONSTRAINT; Schema: public; Owner: university
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT teacher_fk FOREIGN KEY (teacher_id) REFERENCES public.teachers(id);


--
-- PostgreSQL database dump complete
--

