Create Table Curso(
  nombre varchar(200) Not null,
  codigoUnico varchar(7) not null,
  cantidadCreditos int Not null,
  cantidadHoras int not null,
  Primary key (codigoUnico)
);

Create Table Correquisito(
  cursoPrincipal varchar(7) not null,
  cursoSecundario varchar(7) not null,
  Foreign key (cursoPrincipal) references Curso(codigoUnico) On Delete No Action On Update No Action,
  Foreign key (cursoSecundario) references Curso(codigoUnico) On Delete No Action On Update No Action
);

Create Table Requisito(
  cursoPrincipal varchar(7) not null,
  cursoSecundario varchar(7) not null,
  Foreign key (cursoPrincipal) references Curso(codigoUnico) On Delete No Action On Update No Action,
  Foreign key (cursoSecundario) references Curso(codigoUnico) On Delete No Action On Update No Action
);

Create Table Bloque(
  numeroDeSemestre int not null,
  Primary key (numeroDeSemestre)
);

Create Table BloqueCursos(
  bloque int not null,
  codigoCurso varchar(7) not null,
  Foreign key (bloque) References Bloque(numeroDeSemestre) On Delete Cascade On Update Cascade,
  Foreign key (codigoCurso) References Curso(codigoUnico) On Delete Cascade On Update Cascade
);

Create Table PlanDeEstudio(
  numeroDePlan int not null,
  fechaDeEntrada varchar(20) not null,
  Primary key (numeroDePlan)
);


Create Table PlanBloque(
  numeroPlan int not null,
  bloque int not null,
  Foreign key (numeroPlan) References PlanDeEstudio(numeroDePlan) On Delete Cascade On Update Cascade,
  Foreign key (bloque) References Bloque(numeroDeSemestre) On Delete Cascade On Update Cascade
);


Create Table AreaAcademica(
  nombre varchar(200) not null,
  codigo varchar(3) not null,
  Primary key (codigo)
);

Create Table AreaPlan(
  codigoArea varchar(3) not null,
  numeroPlan int not null,
  Foreign key (codigoArea) References AreaAcademica(codigo) On Delete Cascade On Update Cascade,
  Foreign key (numeroPlan) References PlanDeEstudio(numeroDePlan) On Delete Cascade On Update Cascade
);
