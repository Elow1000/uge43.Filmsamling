
# FURPS – Filmsamling

| Kategori | Krav | Opfyldt? | Hvor |
|---|---|---|---|
| F – Functionality | Brugeren kan oprette, vise, søge, redigere og slette film. | Ja | UserInterface, Controller og MovieCollection |
| U – Usability | Brugeren kan trykke Enter for at beholde eksisterende oplysninger ved redigering. | Ja | UserInterface.editMovie() |
| R – Reliability | Programmet håndterer bogstaver ved indtastning af tal uden at lukke ned. | Ja | UserInterface.readInt() |
| P – Performance | Søgning gennemgår filmene én gang og finder titler, der indeholder søgeteksten. | Ja | MovieCollection.searchMovies() |
| S – Supportability | Programmet er opdelt i klasser med forskellige ansvarsområder. | Ja | Movie, MovieCollection, Controller og UserInterface |

## Funktioner

Programmet understøtter CRUD:
- Opret film
- Vis og søg efter film
- Rediger film
- Slet film

Brugeren kan også markere en film som set og registrere datoen.

## Manglende funktioner

- Film gemmes endnu ikke permanent i en CSV-fil.
- Søgning efter film, der ikke er set længe, mangler.
- Sortering efter forskellige filmegenskaber mangler.
- Refaktorering til packages mangler.
