-- "C##FIRSTPROJ".ZOOCALE definition

CREATE TABLE "C##FIRSTPROJ"."ZOOCALE" 
   (	"ZC_TITLE" VARCHAR2(20) NOT NULL ENABLE, 
	"ZC_CON" VARCHAR2(20), 
	 CONSTRAINT "PK_ZOOCALE" PRIMARY KEY ("ZC_TITLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

CREATE UNIQUE INDEX "C##FIRSTPROJ"."PK_ZOOCALE" ON "C##FIRSTPROJ"."ZOOCALE" ("ZC_TITLE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;