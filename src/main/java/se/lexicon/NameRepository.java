package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0]; // element format should be ["firstName lastName", "firstName lastName"]


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: PART 1: implement getSize method
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param Names The array of names to set.
     */
    public static void setNames(final String[] Names) {
        //todo: PART 1: implement setNames method
        //I'm not sure if this is the solution you asked for.
        //I changed the name of the argument to Name so it was possible to refer to names.
        names = Names;
        for(String element: names){
            System.out.println(element);
        }
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: PART 1: implement clear method
        names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: PART 1: implement findAll method
        //should I suppose to create a new array and just return it? is that all?
        return new String[]{"Rafael Nadal", "Novak Jokovic", "Roger Federer"};
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {
        //todo: PART 2: implement find method
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                return names[i];
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        //todo: PART 2: implement add method
        if (find(fullName) == null){
            String [] newNames = Arrays.copyOf(names, names.length + 1);
            newNames[names.length] = fullName;
            names = newNames;
            System.out.println("the array has now " + names.length + " elements ");
            System.out.println("the last one is " + names[names.length - 1]);
            return true;
        }
        return false;
    }

    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        //todo: PART 3: findByFirstName method
        int indexCounter = 0;
        String [] newName = new String[names.length]; //creates an array to put what is found with the same length as the original.
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length(); j++){
                if ( names[i].charAt(j) == ' '){
                    if (firstName.equalsIgnoreCase(names[i].substring(0, j))){
                        newName[indexCounter] = firstName;
                        indexCounter++;
                    };
                }
            }
        }
        return deleteNullElements(newName);
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        //todo: PART 3: implement findByLastName method
        int indexCounter = 0;
        String [] newName = new String[names.length]; //creates an array to put what is found with the same length as the original.
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length(); j++){
                if ( names[i].charAt(j) == ' '){
                   String temp = names[i].substring(j+1);
                    if (lastName.equalsIgnoreCase(names[i].substring(j+1))){
                        newName[indexCounter] = lastName;
                        indexCounter++;
                    };
                }
            }
        }
        return deleteNullElements(newName);
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {
        //todo: PART : implement update method
        String foundName = find(original);
        if (foundName != null){
            for (int i = 0; i < names.length; i++) {
                if (foundName.equalsIgnoreCase(names[i])){
                    names[i] = updatedName;
                    return true;
                }
            }
        }
        System.out.println("The name " + original + " doesn't exists in the list.");
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {
        //todo: PART 4: implement remove method
        String foundName = find(fullName);
            if (foundName !=null){
                String[] newArray = new String[names.length -1];
                int counter = 0;
                for (String element: names){
                    if (!element.equalsIgnoreCase(fullName)){
                        newArray[counter] = element;
                        counter++;
                    }
                }
                names = newArray;
            }
        return false;
    }

    public static void getElement(){
        for (String element : names){
            System.out.println(element);
        }
    }

    public static String [] deleteNullElements(String [] ArrayWithNulls){
        int counter = 0;

        for (String element : ArrayWithNulls){
            if (element == null){
                counter++;
            }
        }
        String [] tempArray = new String[ArrayWithNulls.length - counter];
        for (int i = 0; i < ArrayWithNulls.length; i++) {
            if (ArrayWithNulls[i] != null){
                tempArray[i] = ArrayWithNulls[i];
            }

        }
        return tempArray;
    }

}