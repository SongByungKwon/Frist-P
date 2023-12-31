-- "C##FIRSTPROJ".ZOOSEARCH definition

CREATE TABLE "C##FIRSTPROJ"."ZOOSEARCH" 
   (	"ZS_NAME" VARCHAR2(20) NOT NULL ENABLE, 
	"ZS_SORT" VARCHAR2(20) NOT NULL ENABLE, 
	"ZS_NSTR" VARCHAR2(20), 
	 CONSTRAINT "PK_ZOOSEARCH" PRIMARY KEY ("ZS_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

CREATE UNIQUE INDEX "C##FIRSTPROJ"."PK_ZOOSEARCH" ON "C##FIRSTPROJ"."ZOOSEARCH" ("ZS_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;