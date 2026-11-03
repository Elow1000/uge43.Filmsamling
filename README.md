
# Filmsamling

Et CRUD-program til en filmsamling lavet i Java.
Projektet er udviklet på 1. semester af datamatikeruddannelsen på EK.

## Gruppemedlemmer

| Navn | GitHub |
|------|--------|
| Alex | Alex2309AAAA |
| Elias | Elow1000 |
| Caroline | CaroMars |

## Funktioner

Programmet giver brugeren mulighed for at:

- Tilføje nye film
- Vise alle film i samlingen
- Søge efter film
- Redigere eksisterende film
- Slette film

Hver film indeholder følgende oplysninger:

- Titel
- Instruktør
- Udgivelsesår
- Farve eller sort/hvid
- Varighed i minutter
- Genre

## Teknologier

- Java 21
- Maven
- JUnit 5
- IntelliJ IDEA
- Git og GitHub

## Projektstruktur

src/main/java/
- Main.java
- Movie.java
- MovieCollection.java
- Controller.java
- UserInterface.java

src/test/java/
- MovieTest.java
- MovieCollectionTest.java

docs/
- furps.md
- klassediagram.md

## Sådan køres programmet

1. Åbn projektet i IntelliJ IDEA.
2. Sørg for, at Java 21 eller nyere er installeret.
3. Åbn `src/main/java/Main.java`.
4. Kør `Main.main()`.
5. Brug menuen til at administrere filmsamlingen.

## Unit Testing

Projektet anvender JUnit 5 til at teste programmets funktioner.

Testene kontrollerer:
- Oprettelse af film
- Opdatering af filmoplysninger
- Tilføjelse af film til samlingen
- Søgning efter film
- Redigering af film
- Sletning af film

For at køre testene:

1. Højreklik på `src/test/java`.
2. Vælg `Run All Tests`.
3. Kontrollér, at alle tests består.

## Dokumentation

Projektet indeholder følgende dokumentation:

- `docs/furps.md` – FURPS-krav
- `docs/klassediagram.md` – Klassediagram

## Bemærkninger

Filmene gemmes i en ArrayList i programmets hukommelse.
De gemmes derfor ikke permanent, når programmet lukkes.
