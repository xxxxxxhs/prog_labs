package Managers;

import CollectionClasses.*;
import Exceptions.IncorrectValueException;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * class ask for adding and updating Movies in collection
 */

public class Ask {

    /*
     * @param console
     * asks for values of fields of new Movie-object
     * @return Movie
     */
    public static Movie newMovie(Console console, String username) throws IncorrectValueException {
        String name;
        while (true) {
            try {
                console.print("name: ");
                name = console.readln().trim();
                if (name.equals("exit")) {
                    System.exit(1);
                }
                if (name != null & !name.trim().equals("")) break;
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        Coordinates coordinates = newCoordinates(console);
        Integer oscarsCount = newOscarsCount(console);
        long goldenPalmCount = newGoldenPalmCount(console);
        Float totalBoxOffice = newTotalBoxOffice(console);
        MpaaRating mpaaRating = newMpaaRating(console);
        Person screenwriter = newScreenWriter(console);
        return new Movie(name, coordinates, oscarsCount, goldenPalmCount, totalBoxOffice, mpaaRating, screenwriter, username);
    }
    /*
     * @param console
     * asks for values of fields of new Coordinates-object, required to generate new Movie
     * @return Coordinates
     */
    public static Coordinates newCoordinates(Console console) {
        float x;
        double y;
        while (true) {
            try {
                console.print("x-cor: ");
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        if (Float.parseFloat(line) > -170) {
                            x = Float.parseFloat(line);
                            break;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        while(true) {
            try {
                console.print("y-coor: ");
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        y = Double.parseDouble(line);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        try {
            return new Coordinates(x, y);
        } catch (IncorrectValueException e) {
            console.printError("incorrect coordinates");
            return null;
        }
    }

    /*
     * @param console
     * asks for value of Movie's amount of oscars
     * @return Integer
     */
    public static Integer newOscarsCount(Console console){
        Integer oscarsCount;
        while(true) {
            try {
                console.print("Oscars count: ");
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        if (Integer.parseInt(line) > 0) {
                            oscarsCount = Integer.parseInt(line);
                            break;
                        }
                    } catch (NumberFormatException e) {
                    }
                } else {
                    return null;
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        return oscarsCount;
    }

    /*
     * @param console
     * asks for Movie's amound of golden palms
     * @return long
     */
    public static long newGoldenPalmCount(Console console) {
        long goldenPalmCount;
        while (true) {
            try {
                console.print("Golden Palm count: ");
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        if (Long.parseLong(line) > 0) {
                            goldenPalmCount = Long.parseLong(line);
                            break;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        return goldenPalmCount;
    }

    /*
     * @param console
     * asks for value of Movie's amount of total box office
     * @return Float
     */
    public static Float newTotalBoxOffice(Console console) {
        Float totalBoxOffice;
        while (true){
            try {
                console.print("Total box office: ");
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        if (Float.parseFloat(line) > 0) {
                            totalBoxOffice = Float.parseFloat(line);
                            break;
                        }
                    } catch (NumberFormatException e) {
                    }
                } else {
                    return null;
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        return totalBoxOffice;
    }

    /*
     * @param console
     * asks for value of Movie's mpaa rating
     * @return MpaaRating
     */
    public static MpaaRating newMpaaRating(Console console) {
        MpaaRating mpaaRating;
        while (true) {
            try {
                console.print("Mpaa raating " + Arrays.toString(MpaaRating.values()) + ": ");
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        mpaaRating = MpaaRating.valueOf(line);
                        break;
                    } catch (Exception e) {
                    }
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        return mpaaRating;
    }

    /*
     * @param console
     * generate new Person as a field of Movie
     * @return Person
     */
    public static Person newScreenWriter(Console console) throws IncorrectValueException {
        String name;
        while (true) {
            try {
                console.print("Screenwriter's name: ");
                name = console.readln();
                if (name.equals("exit")) {
                    System.exit(1);
                }
                if (!name.equals("")) {
                    break;
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        String passportID;
        while (true) {
            try {
                console.print("Screenwriter's passport id: ");
                passportID = console.readln();
                if (passportID.equals("exit")) {
                    System.exit(1);
                }
                if (!passportID.equals("")) {
                    break;
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        Color eyeColor;
        while (true) {
            try {
                console.print("Screenwriter's eye color " + Arrays.toString(Color.values()) + ": ");
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        eyeColor = Color.valueOf(line);
                        break;
                    } catch (Exception e) {
                    }
                } else {
                    eyeColor = null;
                    break;
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        Color hairColor;
        while (true) {
            try {
                console.print("Screenwriter's hair color " + Arrays.toString(Color.values()) + ": ");
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        hairColor = Color.valueOf(line);
                        break;
                    } catch (Exception e) {
                    }
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        Location location = newLocation(console);
        return new Person(name, passportID, eyeColor, hairColor, location);
    }

    /*
     * @param console
     * asks for Location as a Person's field
     */
    public static Location newLocation(Console console) {
        Double x;
        Float y;
        Long z;
        String name;
        while (true) {
            console.print("Screenwriter's location x-cor: ");
            try {
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        x = Double.parseDouble(line);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        while (true) {
            console.print("Screenwriter's location y-cor: ");
            try {
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        y = Float.parseFloat(line);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        while (true) {
            console.print("Screenwriter's location z-cor: ");
            try {
                var line = console.readln().trim();
                if (line.equals("exit")) {
                    System.exit(1);
                }
                if (!line.equals("")) {
                    try {
                        z = Long.parseLong(line);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        while (true) {
            console.print("Screenwriter's location name: ");
            try {
                name = console.readln().trim();
                if (name.equals("exit")) {
                    System.exit(1);
                }
                if (!name.equals("")) {
                    break;
                }
            } catch(NoSuchElementException e) {console.printError("registered EOF"); System.exit(-1);}
        }
        try {
            return new Location(x, y, z, name);
        } catch (IncorrectValueException e) {
            console.printError("location errror");
            return null;
        }
    }
}
