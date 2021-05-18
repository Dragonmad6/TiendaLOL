CREATE DATABASE tiendaLOL;
USE tiendaLOL;
CREATE TABLE Login(
idusuario int(11) PRIMARY KEY AUTO_INCREMENT,
nombre varchar(25),
contrasena varchar(25),
email varchar(25)
);

CREATE TABLE TipoItem(
idtipo int(11) PRIMARY KEY,
tipo varchar(25)
);
CREATE TABLE Items(
id int(11) PRIMARY KEY AUTO_INCREMENT,
tipo int (11),
nombre varchar(50),
precio int(11),
descripcion varchar(200),
foto varchar(100),
CONSTRAINT fk_TipoItem FOREIGN KEY (tipo) REFERENCES TipoItem(idtipo)
);
INSERT INTO Login(nombre, contrasena, email) VALUES
("carlosc","01478520C", "carlos.calvo@gmail.com"),
("federicoperez","987654P", "ferico.perez@gmail.com"),
("evar","01234W","eva.rodriguez@hotmail.com"),
("prueba","01478520C", "prueba.calvo@gmail.com"); 
INSERT INTO TipoItem(idtipo, tipo) VALUES
(1, "Iniciales"),
(2, "Pociones"),
(3, "Visión"),
(4, "Botas"),
(5, "Epic Items"),
(6, "Legendary Items"),
(7, "Mythic Items");

INSERT INTO Items (tipo, nombre, precio, descripcion,foto) VALUES
-- Iniciales
(1,"Espada de Doran", 450, "+8 de daño de ataque +80 de vida","/objetoimagenes/EspadaDoran.png"),
(1,"Anillo de Doran", 400, "+15 de poder de habilidad +70 de vida","/objetoimagenes/AnilloDoran.png"),
(1,"Escudo de Doran", 450, "+80 de vida","/objetoimagenes/EscudoDoran.png"),
(1,"Sacrificar", 450, "+7 de daño de ataque +3 de vida al impactar","/objetoimagenes/Sacrificar.png"),
(1,"Martillo del Guardián", 950, "+25 de daño de ataque +150 de vida +10% de robo de vida","/objetoimagenes/MartilloGuardian.png"),
-- Pociones
(2,"Pociones de vida", 50, "Regenera 5 de vida cada medio segundo durante 15 segundos, restaurando un total de 150 de vida.","/objetoimagenes/Pocionesvida.png"),
(2,"Poción reutilizable", 150, "Regenera 5.21 de vida cada medio segundo durante 12 segundos, restaurando un total de 125 de vida.","/objetoimagenes/PocionReutilizable.png"),
(2,"Poción de corrupción", 500, "Durante 12 segundos, regeneras 5.208 de vida y 3.125 de maná cada medio segundo para un total de 125 de vida y 75 de maná","/objetoimagenes/PocionCorrupción.png"),
-- Objetos de vision
(3,"Centinela Invisible", 0, " objeto de un solo uso, puede colocar un límite de 3 centinelas en el mapa.","/objetoimagenes/CentilaInvisible.png"),
(3,"Lente del Oráculo", 0, "Invoca un Dron Explorador que te acompaña durante los siguientes 10 segundos","/objetoimagenes/LenteOraculo.png"),
(3,"Alteración de Visión Lejana", 0, "Revela un área de hasta 4000 unidades de distancia durante 2 segundos","/objetoimagenes/VistaLejana.png"),
-- Botas
(4,"Botas", 300, "+25 de velocidad de movimiento","/objetoimagenes/Botas.png"),
(4,"Botas Jonias de la Lucidez", 900, "+20 de aceleración de habilidad +45 de velocidad de movimiento +12 de aceleración de hechizos de invocador","/objetoimagenes/BotasLucidez.png"),
(4,"Botas de Mercurio", 1100, "+25 de resistencia mágica +45 de velocidad de movimiento +30% de tenacidad","/objetoimagenes/BotasMercurio.png"),
(4,"Botas de Movilidad", 1000, "+115 velocidad de movimiento (fuera de combate)","/objetoimagenes/BotasMovilidad.png"),
(4,"Botas de Rapidez", 900, "+25% resistencia a la ralentización","/objetoimagenes/BotasRapidez.png"),
(4,"Botas del Hechicero", 1100, "+45 de velocidad de movimiento +18 de penetración mágica","/objetoimagenes/BotasHechicero.png"),
(4,"Grebas del Berserker", 1100, "+35% de velocidad de ataque +45 de velocidad de movimiento","/objetoimagenes/BotasBerserker.png"),
(4,"Punteras de Acero Revestidas", 1100, "Reduce el daño entrante de todos los ataques básicos en un 12%","/objetoimagenes/BotasAcero.png"),
-- Objetos epicos
(5,"Arco Recurvado", 1000, "+25% de velocidad de ataque","/objetoimagenes/ArcoRecurvado.png"),
(5,"Bacteriófago", 1100, "Después de infligir daño físico a un campeón enemigo, te curas la vida máxima durante 6 segundos.","/objetoimagenes/Bacteriofago.png"),
(5,"Brazal Cristalino", 650, "+200 de vida +50% de regeneración de vida básica","/objetoimagenes/BrazelCristalino.png"),
(5,"Brillo", 700, " Después de usar una habilidad, tu próximo ataque básico en 10 segundos inflige 100% DA base como daño físico adicional al impacto","/objetoimagenes/Brillo.png"),
(5,"Brisa de Éter", 850, "+30 de poder de habilidad","/objetoimagenes/BrisaEter.png"),
(5,"Capítulo Perdido", 1300, "+40 de poder de habilidad +10 de aceleración de habilidad +300 de maná","/objetoimagenes/CapituloPerdido.png"),
(5,"Carcaj de Mediodía", 1300, "+30 de daño de ataque +15% de velocidad de ataque","/objetoimagenes/CarcajMediodia.png"),
(5,"Ceniza de Bami", 1000, "+300 de vida","/objetoimagenes/CenizaBami.png"),
(5,"Cinturón de Gigante", 900, "+350 de vida","/objetoimagenes/CinturonGigante.png"),
(5,"Cota de Malla", 800, "+40 de armadura","/objetoimagenes/CotaMalla.png"),
(5,"Cota del Guardabosques", 1000, "+40 de armadura +1000 de vida máxima","/objetoimagenes/CotaGuardabosques.png"),
(5,"Códice Diabólico", 900, "+35 de poder de habilidad +10 de aceleración de habilidad","/objetoimagenes/CodiceDiabolico.png"),
(5,"Puñal Serrado", 1100, "+30 de daño de ataque","/objetoimagenes/PunalSerrado.png"),
(5,"Sorbechizos", 1300, "+20 de daño de ataque +35 de resistencia mágica","/objetoimagenes/Sorbechizos.png"),
(5,"Vesta Espinosa", 800, "+35 de armadura, al ser golpeado por un ataque básico, infliges 3 (+ 10% de armadura adicional)","/objetoimagenes/VestaEspinosa.png"),
(5,"Último Suspiro", 1450, "+20 de penetración de armadura +20 de daño de ataque","/objetoimagenes/UltimoSuspiro.png"),
-- Objetos Legendarios
(6,"Abrazo Demoníaco", 3000, "+70 de poder de habilidad +350 de vida","/objetoimagenes/AbrazoDemoniaco.png"),
(6,"Abrazo del Serafín", 2100, "+65 de poder de habilidad +800 de maná","/objetoimagenes/AbrazoSerafin.png"),
(6,"Al Filo de la Cordura", 3100, "+30 de daño de ataque +50 de resistencia mágica +40% de velocidad de movimiento","/objetoimagenes/FiloCordura.png"),
(6,"Apariencia Espiritual", 2900, "+10 de aceleración de habilidad +450 de vida +100% de regeneración de vida básica +40 de resistencia mágica","/objetoimagenes/AparienciaEspiritual.png"),
(6,"Armadura Pétrea", 3300, "+15 de aceleración de habilidad +60 de armadura +60 de resistencia mágica","/objetoimagenes/AramaduraPetrea.png"),
(6,"Armadura de Warmog", 3000, "+10 de aceleración de habilidad +800 de vida +200% de regeneración de vida básica","/objetoimagenes/ArmaduraWarmog.png"),
(6,"Bailarín Espectral", 2600, "+20 de daño de ataque +25% de velocidad de ataque +20% de probabilidad de golpe crítico +7% de velocidad de movimiento","/objetoimagenes/BailarinEspectral.png"),
(6,"Báculo del Vacío", 2700, "+70 de poder de habilidad +40 de penetración mágica","/objetoimagenes/BaculoVacio.png"),
(6,"Cañón de Fuego Rápido", 2700, "+30% de velocidad de ataque +25% de probabilidad de golpe crítico +7% de velocidad de movimiento","/objetoimagenes/CanonFuegoRapido.png"),
(6,"Cetro de Cristal de Rylai", 3000, "+90 de poder de habilidad +300 de vida","/objetoimagenes/CristalRylai.png"),
(6,"Corazón de Hielo", 2500, "+20 de aceleración de habilidad +70 de armadura +400 de maná","/objetoimagenes/CorazonHielo.png"),
(6,"Cota de Espinas", 2700, "+60 de armadura +350 de vida","/objetoimagenes/CotaEspinas.png"),
(6,"Cuchilla Oscura", 3100, "+25 de aceleración de habilidad +40 de daño de ataque +400 de vida","/objetoimagenes/CuchillaOscura.png"),
(6,"Danza de la Muerte", 3100, "+15 de aceleración de habilidad +30 de armadura +50 de daño de ataque","/objetoimagenes/DanzaMuerte.png"),
(6,"El Coleccionista", 3000, "+55 de daño de ataque +20% de probabilidad de golpe crítico","/objetoimagenes/Coleccionista.png"),
(6,"Espadafuria de Guinsoo", 2800, "+45% de velocidad de ataque +20% de probabilidad de golpe crítico","/objetoimagenes/Guinsso.png"),
(6,"Filo de la Tormenta", 2700, "+40 de daño de ataque +15% de velocidad de ataque +20% de probabilidad de golpe crítico","/objetoimagenes/FiloTormenta.png"),
(6,"Filo del Infinito", 3400, "+80 de daño de ataque +20% de probabilidad de golpe crítico","/objetoimagenes/FiloInfinito.png"),
(6,"Hidra Voraz", 3300, "+20 de aceleración de habilidad +60 de daño de ataque +10% de omnivampirismo","/objetoimagenes/HidraVoraz.png"),
(6,"Morellonomicón", 2500, "+80 de poder de habilidad +300 de vida","/objetoimagenes/Morellonomicon.png"),
(6,"Placa del Hombre Muerto", 2900, "+60 de armadura +400 de vida +5% de velocidad de movimiento","/objetoimagenes/CorazaMuerto.png"),
(6,"Reloj de Arena de Zhonya", 2600, "+65 de poder de habilidad +10 de aceleración de habilidad +45 de armadura","/objetoimagenes/Zhonya.png"),
(6,"Saqueador de Esencias", 2800, "+20 de aceleración de habilidad +45 de daño de ataque +20% de probabilidad de golpe crítico","/objetoimagenes/SaqueadorEsencias.png"),
(6,"Sombrero Mortífero de Rabadon", 3600, "+120 de poder de habilidad","/objetoimagenes/Rabodon.png"),
(6,"Ángel Guardián", 2800, "+40 de armadura +45 de daño de ataque","/objetoimagenes/AngelGuardian.png"),
-- Objetos Míticos
(7,"Agrietador", 3200, "+80 de poder de habilidad +15 de aceleración de habilidad +300 de vida +8% de omnivampirismo","/objetoimagenes/Agrietador.png"),
(7,"Angustia de Liandry", 3400, "+80 de poder de habilidad +20 de aceleración de habilidad +600 de maná","/objetoimagenes/Liandry.png"),
(7,"Bebedor de Sangre", 3300, "+20 de aceleración de habilidad +45 de daño de ataque +400 de vida +150% de regeneración de vida básica","/objetoimagenes/BebedorSangre.png"),
(7,"Canto de Guerra de Shurelya", 2500, "+40 de poder de habilidad +20 de aceleración de habilidad +200 de vida +100% de regeneración de maná básica","/objetoimagenes/Shurelya.png"),
(7,"Cercenador Divino", 3300, "+20 de aceleración de habilidad +40 de daño de ataque +400 de vida","/objetoimagenes/CercenadorDivino.png"),
(7,"Cinturón Cohete Hextech", 3200, "+90 de poder de habilidad +15 de aceleración de habilidad +350 de vida","/objetoimagenes/CinturonHextech.png"),
(7,"Cosechador Nocturno", 3200, "+90 de poder de habilidad +15 de aceleración de habilidad +300 de vida","/objetoimagenes/CosechadorNocturno.png"),
(7,"Fuerza de la Trinidad", 3333, "+20 de aceleración de habilidad +30 de daño de ataque +30% de velocidad de ataque +200 de vida","/objetoimagenes/Trinidad.png"),
(7,"Guantelete de Fuego Escarchado", 2800, "+20 de aceleración de habilidad +25 de armadura +350 de vida +25 de resistencia mágica","/objetoimagenes/FuegoEscarchado.png"),
(7,"Hielo Eterno", 3400, "+80 de poder de habilidad +10 de aceleración de habilidad +250 de vida +600 de maná","/objetoimagenes/HieloEterno.png"),
(7,"Hoja Crepuscular de Draktharr", 3200, "+20 de aceleración de habilidad +60 de daño de ataque","/objetoimagenes/Draktharr.png"),
(7,"Matakrakens", 3400, "+60 de daño de ataque +25% de velocidad de ataque +20% de probabilidad de golpe crítico","/objetoimagenes/Matakrakens.png"),
(7,"Quimotanque Turbo", 2800, "+20 de aceleración de habilidad +25 de armadura +350 de vida +25 de resistencia mágica","/objetoimagenes/QuimotanqueTurbo.png"),
(7,"Relicario de los Solari de Hierro", 2700, "+20 de aceleración de habilidad +30 de armadura +200 de vida +30 de resistencia mágica","/objetoimagenes/SolariHierro.png"),
(7,"Tempestad de Luden", 3400, "+80 de poder de habilidad +20 de aceleración de habilidad +600 de maná +6 de penetración mágica","/objetoimagenes/Luden.png"),
(7,"Égida de Fuego Solar", 3200, "+20 de aceleración de habilidad +30 de armadura +450 de vida +30 de resistencia mágica","/objetoimagenes/FuegoSolar.png");