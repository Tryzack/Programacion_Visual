PGDMP         $        	        {         	   productos    14.4    14.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    41284 	   productos    DATABASE     e   CREATE DATABASE productos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE productos;
                postgres    false            �            1259    41286 	   productos    TABLE     �   CREATE TABLE public.productos (
    id integer NOT NULL,
    producto text NOT NULL,
    categoria text,
    seccion text,
    monto double precision
);
    DROP TABLE public.productos;
       public         heap    postgres    false            �            1259    41285    productos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.productos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.productos_id_seq;
       public          postgres    false    210            �           0    0    productos_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.productos_id_seq OWNED BY public.productos.id;
          public          postgres    false    209            \           2604    41289    productos id    DEFAULT     l   ALTER TABLE ONLY public.productos ALTER COLUMN id SET DEFAULT nextval('public.productos_id_seq'::regclass);
 ;   ALTER TABLE public.productos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209    210            �          0    41286 	   productos 
   TABLE DATA           L   COPY public.productos (id, producto, categoria, seccion, monto) FROM stdin;
    public          postgres    false    210   �
       �           0    0    productos_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.productos_id_seq', 2, true);
          public          postgres    false    209            ^           2606    41293    productos productos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.productos DROP CONSTRAINT productos_pkey;
       public            postgres    false    210            �   ?   x�3�,M-��t�H,J.-I-�L�4q�4г��2��H,��K�H�KLKYp�r��qqq ���     