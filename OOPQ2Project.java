import java.util.List;
import java.io.BufferedReader;
import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;
import java.util.Collections;

/**
 * This program aims to analyze key indicators of a contact-tracing dataset
 *
 * @author (Shashi Salavath)
 * @version (11/18/22)
 */
public class OOPQ2Project {
    public static void main(String[] args) {
        // Call the partone method with the nane of the input file
        // Inpput file can be changed to align with a given dataset
        part1("Dataset1.txt");
        part2("Dataset1.txt");
        part3("Dataset1.txt");
        part4("Dataset1.txt");
        part5("Dataset1.txt");
        part6("Dataset1.txt");
        part7("Dataset1.txt");
    }

    public static void part1(String datafile) {
        // Create an empty hashmap to store the contact data
        Map<String, List<String>> contactData = new HashMap<>();

        // Read the data from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(datafile))) {
            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens
                String[] tokens = line.split(",");
                // The first token is the sick person
                String sickPerson = tokens[0];

                // Create an empty list to store the contacts of the sick person
                List<String> contacts = new ArrayList<>();
                // Add the remaining tokens to the list
                for (int i = 1; i < tokens.length; i++) {
                    contacts.add(tokens[i]);
                }

                // Add the sick person and their contacts to the hashmap
                contactData.put(sickPerson, contacts);
            }
        } catch (IOException e) {
            // Print an error message if there was a problem reading the file
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the header for the part 1 results
        System.out.println("Contact Records:");

        // Loop through the keys (sick people) in the hashmap
        for (String sickPerson : contactData.keySet()) {
            // Get the list of contacts for the sick person
            List<String> contacts = contactData.get(sickPerson);

            // Print the name of the sick person and "had contact with"
            System.out.print("\t" + sickPerson + " had contact with ");

            // Loop through the contacts of the sick person
            for (int i = 0; i < contacts.size(); i++) {
                // Get the current contact
                String contact = contacts.get(i);

                // Print the contact name, followed by a comma and space if it is not the last
                // item in the list
                System.out.print(contact);
                if (i < contacts.size() - 2) {
                    System.out.print(", ");
                }
                // Print the word "and" followed by a space if the contact is the second-to-last
                // item in the list
                else if (i == contacts.size() - 2) {
                    System.out.print(" and ");
                }
            }

            System.out.println();
        }
    }

    public static void part2(String datafile) {
        System.out.println();
        // Create an empty hashmap to store the contact data
        Map<String, List<String>> contactData = new HashMap<>();

        // Read the data from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(datafile))) {
            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens
                String[] tokens = line.split(",");
                // The first token is the sick person
                String sickPerson = tokens[0];

                // Create an empty list to store the contacts of the sick person
                List<String> contacts = new ArrayList<>();
                // Add the remaining tokens to the list
                for (int i = 1; i < tokens.length; i++) {
                    contacts.add(tokens[i]);
                }

                // Add the sick person and their contacts to the hashmap
                contactData.put(sickPerson, contacts);
            }
        } catch (IOException e) {
            // Print an error message if there was a problem reading the file
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the header for the part 2 results
        System.out.print("Patient Zero(s): ");

        // Create an enpty set to store the names of sick people
        Set<String> sickPeople = new HashSet<>();

        // Loop through the keys (sick people) in the hashmap
        for (String sickPerson : contactData.keySet()) {
            // Add the sick person's name to the set
            sickPeople.add(sickPerson);
        }

        // Create an empty set to store the names of patient zeroes
        Set<String> patientZeroes = new HashSet<>();
        // Loop through the keys(sick people) in the hashmap
        for (String sickPerson : contactData.keySet()) {
            // Get the list of contacts for the sick person
            List<String> contacts = contactData.get(sickPerson);

            // Loop through the contacts of the sick person
            for (String contact : contacts) {
                // Remove the contact's name from the set of sick people
                sickPeople.remove(contact);
            }
        }

        // Add the remaining names in the set of sick people to the set of patient
        // zeroes
        patientZeroes.addAll(sickPeople);

        // Loop through the patient zeroes
        int i = 0;
        for (String patientZero : patientZeroes) {
            // Print the name of the patient zero
            System.out.print(patientZero);

            // If not last item in set, print comma and space
            if (i < patientZeroes.size() - 2) {
                System.out.print(", ");
            }

            // If it is the second-to-last item in the set, print " and "
            if (i == patientZeroes.size() - 2) {
                i++;
                System.out.print(" and ");
            }

            i++;
        }

        System.out.println();
    }

    public static void part3(String datafile) {
        System.out.println();
        // Create an empty hashmap to store the contact data
        Map<String, List<String>> contactData = new HashMap<>();

        // Read the data from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(datafile))) {
            // Read esch line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens
                String[] tokens = line.split(",");
                // The first token is the sick person
                String sickPerson = tokens[0];

                // Create an empty list to store the contacts of the sick person
                List<String> contacts = new ArrayList<>();
                // Add the remaining tokens to the list
                for (int i = 1; i < tokens.length; i++) {
                    contacts.add(tokens[i]);
                }

                // Add the sick person and their contacts to the hashmap
                contactData.put(sickPerson, contacts);
            }
        } catch (IOException e) {
            // Print an error message if there was a problem reading the file
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the header for the part 3 results
        System.out.print("Potential Zombies: ");

        // Create an empty set to store the names of potential zombies
        Set<String> potentialZombies = new HashSet<>();

        // Loop through the keys (sick people) in the hashmap
        for (String sickPerson : contactData.keySet()) {
            // Get the list of contacts for the sick person
            List<String> contacts = contactData.get(sickPerson);

            // Loop through the contacts of the sick person
            for (String contact : contacts) {
                // Add the contact's name to the set of potential zombies
                potentialZombies.add(contact);
            }
        }

        // Keep track of how many potential zombies have been printed
        int count = 0;

        // Loop trough the potential zombies
        for (String potentialZombie : potentialZombies) {
            // Check if the potential zombie is not a sick person
            if (!contactData.containsKey(potentialZombie)) {
                if (count > 0) {
                    // Prints "and" before the potential zombie's name
                    System.out.print(" and ");
                }

                System.out.print(potentialZombie);
                count++;
            }
        }

        System.out.println();
    }

    public static void part4(String datafile) {
        System.out.println();
        // Create an empty hashmap to store the contact data
        Map<String, List<String>> contactData = new HashMap<>();

        // Read the data from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(datafile))) {
            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens
                String[] tokens = line.split(",");
                // The first token is the sick person
                String sickPerson = tokens[0];

                // Create an empty list t store the contacts of the sick person
                List<String> contacts = new ArrayList<>();
                // Add the remaining tokens to the list
                for (int i = 1; i < tokens.length; i++) {
                    contacts.add(tokens[i]);
                }

                // Add the sick person and their contacts to the hashmap
                contactData.put(sickPerson, contacts);
            }
        } catch (IOException e) {
            // Print an error message if there was a problem reading the file
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Find people who are not patient zeros or potential zombies
        Set<String> patientZeros = new HashSet<>();
        Set<String> potentialZombies = new HashSet<>();
        Set<String> sickPeople = new HashSet<>();
        Set<String> healthyPeople = new HashSet<>();

        // Find patient zeros and sick people
        for (Map.Entry<String, List<String>> entry : contactData.entrySet()) {
            String sickPerson = entry.getKey();
            List<String> contacts = entry.getValue();
            sickPeople.add(sickPerson);
            if (contacts.isEmpty()) {
                patientZeros.add(sickPerson);
            }
        }

        // Find potential zombies
        for (Map.Entry<String, List<String>> entry : contactData.entrySet()) {
            List<String> contacts = entry.getValue();
            for (String contact : contacts) {
                if (!sickPeople.contains(contact)) {
                    potentialZombies.add(contact);
                }
            }
        }

        // Sort people who are not patient zeros or potential zombies
        for (Map.Entry<String, List<String>> entry : contactData.entrySet()) {
            List<String> contacts = entry.getValue();
            for (String contact : contacts) {
                if (!patientZeros.contains(contact) && !potentialZombies.contains(contact)) {
                    healthyPeople.add(contact);
                }
            }
        }
        // Print out the method header
        System.out.print("Neither Patient Zero or Potential Zombie: ");

        // Print out the names of the healthy
        int count = 0;
        int size = healthyPeople.size();
        for (String name : healthyPeople) {
            count++;
            if (count == size - 1) {
                // Print the second to last name followed by "and"
                System.out.print(name + " and ");
            } else if (count == size) {
                // Print the last name without a comma
                System.out.print(name);
            } else {
                // Print the name followed by a comma
                System.out.print(name + ", ");
            }
        }

        System.out.println();
    }

    public static void part5(String datafile) {
        System.out.println();
        // Create an empty hashmap to store the contact data
        Map<String, List<String>> contactData = new HashMap<>();

        // Read the data from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(datafile))) {
            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens
                String[] tokens = line.split(",");
                // The first token is the sick person
                String sickPerson = tokens[0];

                // Create an empty list to store the contacts of the sick person
                List<String> contacts = new ArrayList<>();
                // Add the remaining tokens to the list
                for (int i = 1; i < tokens.length; i++) {
                    contacts.add(tokens[i]);
                }

                // Add the sick person and their contacts to the hashmap
                contactData.put(sickPerson, contacts);
            }
        } catch (IOException e) {
            // Print an error message if there was a problem reading the file
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Create an empty set to store the names of the sick people
        Set<String> sickPeople = new HashSet<>();

        // Loop through the keys (sick people) in the hashmap
        for (String sickPerson : contactData.keySet()) {
            // Add the sick person's name to the set of sick people
            sickPeople.add(sickPerson);
        }

        // Keep track of the biggest group of people that could have been infected by a
        // single person
        int maxGroupSize = 0;

        // Stores names of people who could have infected the largest group
        List<String> maxGroupInfectors = new ArrayList<>();

        // Loop through the keys (sick people) in the hashmap
        for (String sickPerson : contactData.keySet()) {
            // Get the list of contacts for the sick person
            List<String> contacts = contactData.get(sickPerson);

            Set<String> group = new HashSet<>();
            group.add(sickPerson);
            // Loop through the contacts of the sick person
            for (String contact : contacts) {
                // If the contact is a sick person, add them to the group
                if (sickPeople.contains(contact)) {
                    group.add(contact);
                }
            }

            // If the soze of the group is larger than the current maximum, update the
            // maximum and the list of infectors
            if (group.size() > maxGroupSize) {
                maxGroupSize = group.size();
                maxGroupInfectors.clear();
                maxGroupInfectors.add(sickPerson);
            }
            // If the size of the group is equal to the current maximum, add the sick person
            // to the list of infectors
            else if (group.size() == maxGroupSize) {
                maxGroupInfectors.add(sickPerson);
            }
        }

        // Print the header for the part 5 results
        System.out.print("Most Viral People: ");

        // System.out.println("\tSize: " + maxGroupSize);
        // System.out.print("\tInfected by: ");

        // Use StringJoiner to format list
        StringJoiner infectors = new StringJoiner(", ");
        for (String infector : maxGroupInfectors) {
            infectors.add(infector);
        }
        // Print formatted list
        System.out.print(infectors.toString());
        System.out.println();
    }

    public static void part6(String datafile) {
        System.out.println();
        // Create an empty hashmap to store the contact data
        Map<String, List<String>> contactData = new HashMap<>();

        // Read the data from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(datafile))) {
            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens
                String[] tokens = line.split(",");
                // The first token is the sick person
                String sickPerson = tokens[0];

                // Create an empty list to store the contacts of the sick person
                List<String> contacts = new ArrayList<>();
                // Add the remaining tokens to the list
                for (int i = 1; i < tokens.length; i++) {
                    contacts.add(tokens[i]);
                }

                // Add the sick person and their contacts to the hashmap
                contactData.put(sickPerson, contacts);
            }
        } catch (IOException e) {
            // Print an error message if there was a problem reading the file
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Create a map to store the contact count for each person
        Map<String, Integer> contactCount = new HashMap<>();

        // Iterate over the contact data and count the number of contacts for each
        // person
        for (List<String> contacts : contactData.values()) {
            for (String contact : contacts) {
                contactCount.put(contact, contactCount.getOrDefault(contact, 0) + 1);
            }
        }

        // Fins the people with the most contacts
        List<String> mostContactedPeople = new ArrayList<>();
        int maxContacts = 0;
        for (Map.Entry<String, Integer> entry : contactCount.entrySet()) {
            if (entry.getValue() == maxContacts) {
                mostContactedPeople.add(entry.getKey());
            } else if (entry.getValue() > maxContacts) {
                mostContactedPeople.clear();
                mostContactedPeople.add(entry.getKey());
                maxContacts = entry.getValue();
            }
        }

        // Method header
        System.out.print("Most Contacted: ");

        // Formats print so and is before last word
        for (int i = 0; i < mostContactedPeople.size(); i++) {
            String person = mostContactedPeople.get(i);
            if (i > 0) {
                if (i == mostContactedPeople.size() - 1) {
                    System.out.print(" and ");
                } else {
                    System.out.print(", ");
                }
            }
            System.out.print(person);
        }

        System.out.println();
    }

    // Extra credit problem
    public static void part7(String datafile) {
        System.out.println();
        // Create an empty hashmap to store the contact data
        Map<String, List<String>> contactData = new HashMap<>();

        // Read the data from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(datafile))) {
            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens
                String[] tokens = line.split(",");
                // The first token is the sick person
                String sickPerson = tokens[0];

                // Create an empty list to store the contacts of the sick person
                List<String> contacts = new ArrayList<>();
                // Add the remaining tokens to the list
                for (int i = 1; i < tokens.length; i++) {
                    contacts.add(tokens[i]);
                }

                // Add the sick person and their contacts to the hashmap
                contactData.put(sickPerson, contacts);
            }
        } catch (IOException e) {
            // Print an error message if there was a problem reading the file
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Create an empty set to store the potential zombies
        Set<String> potentialZombies = new HashSet<>();

        // Loop through the keys(sick people) in the hashmap
        for (String sickPerson : contactData.keySet()) {
            // Get the list of contacts for the sick person
            List<String> contacts = contactData.get(sickPerson);
            // Loop through the contacts of the sick person
            for (String contact : contacts) {
                // If the contact is not a sick person, add them to the set of potential zombies
                if (!contactData.containsKey(contact)) {
                    potentialZombies.add(contact);
                }
            }
        }

        // Create an empty list to store the max distances from potential zombies
        List<Integer> maxDistances = new ArrayList<>();

        // Loop through keyset
        int sickPersonIndex = 0;
        for (String sickPerson : contactData.keySet()) {
            // Call recursion func to find distance from potential zombie to sick person
            int maxDistance = computeMaxDistance(sickPerson, contactData, potentialZombies);
            maxDistances.add(maxDistance);

            sickPersonIndex++;
        }

        System.out.println("Maximum Distance from Potential Zombies:");

        // Track index of keyset
        sickPersonIndex = 0;

        // Loop through the keys (sick people) in the hashmap
        for (String sickPerson : contactData.keySet()) {
            // Get the max distance for the sick person
            int maxDistance = maxDistances.get(sickPersonIndex);

            System.out.println("\t" + sickPerson + ": " + maxDistance);

            sickPersonIndex++;
        }

        // To account for potential zombies, who have 0 distance
        for (String contactedPerson : potentialZombies) {
            System.out.println("\t" + contactedPerson + ":" + " 0");
        }

    }

    // Method to find the max distance from a potential zombie
    public static int computeMaxDistance(String person, Map<String, List<String>> contactData,
            Set<String> potentialZombies) {
        // If person is a potential zombie, returns 0
        if (potentialZombies.contains(person)) {
            return 0;
        }

        // If person has no contacts, returns -1(since they cant reach a potential
        // zombie)
        if (!contactData.containsKey(person)) {
            return -1;
        }

        List<String> contacts = contactData.get(person);

        // Stores the max distances from potential zombies for the person contacts
        List<Integer> maxDistances = new ArrayList<>();

        // Loop through contact of person
        for (String contact : contacts) {
            // Find the max distance from a potential zombie for the contact
            int maxDistance = computeMaxDistance(contact, contactData, potentialZombies);
            maxDistances.add(maxDistance);
        }

        // Return the max value in the list of max distances, add 1 to skip current
        // person
        return Collections.max(maxDistances) + 1;
    }
}
