/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     13/08/2021 10:44:05                          */
/*==============================================================*/


drop table if exists ADMIN;

drop table if exists DIPLOME;

drop table if exists DOMAINE;

drop table if exists ETABLISSEMENT;

drop table if exists EXPERIENCE;

drop table if exists LOISIR;

drop table if exists NATURE;

drop table if exists NIVEAU;

drop table if exists POSTULANT;

drop table if exists RECRUTEUR;

drop table if exists STAGE;

drop table if exists TYPE_STAGE;

drop table if exists USER;

/*==============================================================*/
/* Table: ADMIN                                                 */
/*==============================================================*/
create table ADMIN
(
   ID_USER              int not null,
   NOM                  varchar(255),
   PRENOM               varchar(255),
   LOGIN                varchar(255),
   PASSWORD             varchar(255),
   primary key (ID_USER)
);

/*==============================================================*/
/* Table: DIPLOME                                               */
/*==============================================================*/
create table DIPLOME
(
   ID_DIPLOME           int not null AUTO_INCREMENT,
   ID_ETABLISS          int not null,
   ID_NATURE            int not null,
   ID_USER              int not null,
   DATE_OBTENTION       date,
   DESCRIPTION          varchar(255),
   primary key (ID_DIPLOME)
);

/*==============================================================*/
/* Table: DOMAINE                                               */
/*==============================================================*/
create table DOMAINE
(
   ID_DOMAINE          int not null AUTO_INCREMENT,
   ID_USER              int not null,
   LIBELLE              varchar(255),
   primary key (ID_DOMAINE)
);

/*==============================================================*/
/* Table: ETABLISSEMENT                                         */
/*==============================================================*/
create table ETABLISSEMENT
(
   ID_ETABLISS          int not null AUTO_INCREMENT,
   LIBELLE              varchar(255),
   primary key (ID_ETABLISS)
);

/*==============================================================*/
/* Table: EXPERIENCE                                            */
/*==============================================================*/
create table EXPERIENCE
(
   ID_EXPERIENCE        int not null AUTO_INCREMENT,
   ID_USER              int not null,
   ENTREPRISE           varchar(255),
   TYPE_EMPLOIE         varchar(255),
   DECRIPTION           varchar(255),
   DATE_DEBUT           date,
   DATE_FIN             date,
   primary key (ID_EXPERIENCE)
);

/*==============================================================*/
/* Table: LOISIR                                                */
/*==============================================================*/
create table LOISIR
(
   ID_LOISIR            int not null AUTO_INCREMENT,
   ID_USER              int not null,
   LIBELLE              varchar(255),
   primary key (ID_LOISIR)
);

/*==============================================================*/
/* Table: NATURE                                                */
/*==============================================================*/
create table NATURE
(
   ID_NATURE            int not null AUTO_INCREMENT,
   LIBELLE              varchar(255),
   primary key (ID_NATURE)
);

/*==============================================================*/
/* Table: NIVEAU                                                */
/*==============================================================*/
create table NIVEAU
(
   ID_NIVEAU            int not null AUTO_INCREMENT,
   ID_DIPLOME           int not null,
   LIBELLE              varchar(255),
   primary key (ID_NIVEAU)
);

/*==============================================================*/
/* Table: POSTULANT                                             */
/*==============================================================*/
create table POSTULANT
(
   ID_USER              int not null,
   DATE_NAISSANCE       date,
   SEXE                 varchar(255),
   primary key (ID_USER)
);

/*==============================================================*/
/* Table: RECRUTEUR                                             */
/*==============================================================*/
create table RECRUTEUR
(
   ID_USER              int not null,
   NOM                  varchar(255),
   PRENOM               varchar(255),
   LOGIN                varchar(255),
   PASSWORD             varchar(255),
   primary key (ID_USER)
);

/*==============================================================*/
/* Table: STAGE                                                 */
/*==============================================================*/
create table STAGE
(
   ID_STAGE             int not null AUTO_INCREMENT,
   ID_TYPE_STAGE        int not null,
   ID_USER              int not null,
   DESCRIPTION          varchar(255),
   DATE_DEBUT           date,
   DATE_FIN             date,
   primary key (ID_STAGE)
);

/*==============================================================*/
/* Table: TYPE_STAGE                                            */
/*==============================================================*/
create table TYPE_STAGE
(
   ID_TYPE_STAGE        int not null AUTO_INCREMENT,
   LIBELLE              varchar(255),
   primary key (ID_TYPE_STAGE)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   ID_USER              int not null AUTO_INCREMENT,
   NOM                  varchar(255),
   PRENOM               varchar(255),
   LOGIN                varchar(255),
   PASSWORD             varchar(255),
   primary key (ID_USER)
);

alter table ADMIN add constraint FK_HERITAGE_1 foreign key (ID_USER)
      references USER (ID_USER) on delete restrict on update restrict;

alter table DIPLOME add constraint FK_CONCERNER foreign key (ID_NATURE)
      references NATURE (ID_NATURE) on delete restrict on update restrict;

alter table DIPLOME add constraint FK_DELIVRER foreign key (ID_ETABLISS)
      references ETABLISSEMENT (ID_ETABLISS) on delete restrict on update restrict;

alter table DIPLOME add constraint FK_OBTENIR foreign key (ID_USER)
      references POSTULANT (ID_USER) on delete restrict on update restrict;

alter table DOMAINE add constraint FK_SPECIALISER foreign key (ID_USER)
      references POSTULANT (ID_USER) on delete restrict on update restrict;

alter table EXPERIENCE add constraint FK_TRAVAILLER foreign key (ID_USER)
      references POSTULANT (ID_USER) on delete restrict on update restrict;

alter table LOISIR add constraint FK_AVOIR foreign key (ID_USER)
      references POSTULANT (ID_USER) on delete restrict on update restrict;

alter table NIVEAU add constraint FK_CONTENIR foreign key (ID_DIPLOME)
      references DIPLOME (ID_DIPLOME) on delete restrict on update restrict;

alter table POSTULANT add constraint FK_INHERITANCE_1 foreign key (ID_USER)
      references USER (ID_USER) on delete restrict on update restrict;

alter table RECRUTEUR add constraint FK_INHERITANCE_3 foreign key (ID_USER)
      references USER (ID_USER) on delete restrict on update restrict;

alter table STAGE add constraint FK_AYANT foreign key (ID_TYPE_STAGE)
      references TYPE_STAGE (ID_TYPE_STAGE) on delete restrict on update restrict;

alter table STAGE add constraint FK_FAIRE foreign key (ID_USER)
      references POSTULANT (ID_USER) on delete restrict on update restrict;

