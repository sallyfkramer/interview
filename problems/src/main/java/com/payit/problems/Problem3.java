package com.payit.problems;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.payit.problems.models.Customer;
import com.payit.problems.models.Duplicates;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.*;

/**
 * We have a list of customers and we are fairly certain
 * that there are duplicates in the list.
 *
 * You must count the number of duplicates and possible duplicates.
 *
 * A duplicate is a customer where their first name, last name, and email address all match.
 * A possible duplicate is where their first name and last name match but they have different email addresses.
 *
 * The list of customers is found in the json document 'customers.json' found in the resources directory.
 * You must load and deserialize the document into a list of Customer objects. (The customer object is found in the models package)
 * Feel free to use any open source library you would like to aid you in the deserialization. (Hint: Gradle is your friend)
 *
 * Running ./gradlew cleanIdea idea will generate project files for intellij. You can do the same for eclipse.
 * I have already added google gson as a dependency if you would like to use that library for deserialization.
 *
 * Once you have a list of customer objects count the number of duplicates and the number of possible duplicates.
 * Return you count in the Duplicates object.
 *
 * Other Notes:
 * A matching pair is considered 1 duplicate. Three of the same is considered two matches. (i.e. N - 1)
 *
 */
public class Problem3 {

    private List<Customer> resources() {

        String fileName = "file/customers.json";


        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        Customer[] customers = gson.fromJson(reader, Customer[].class);

        return Arrays.asList(customers);
    }


    static class CustomerSortingComparator implements Comparator<Customer> {

        @Override
        public int compare(Customer customer1, Customer customer2) {

            int LastNameCompare = customer1.getLastName().compareTo(customer2.getLastName());
            int FirstNameCompare = customer1.getFirstName().compareTo(customer2.getFirstName());

            if (LastNameCompare == 0) {
                return ((FirstNameCompare == 0) ? LastNameCompare : FirstNameCompare);
            } else {
                return LastNameCompare;
            }
        }
    }


    public Duplicates findDuplicates() {
        List<Customer> customers = resources();
        Duplicates duplicates = new Duplicates();
        Collections.sort(customers, new CustomerSortingComparator());

        int possibleDuplicates = 0;
        int fullDuplicate = 0;

        for (int i = 0; i < customers.size() - 1; i++) {
            if (customers.get(i).getFirstName().equals(customers.get(i + 1).getFirstName()) )
                if (customers.get(i).getLastName().equals(customers.get(i + 1).getLastName())) {

                    if (customers.get(i).getEmailAddress().equals( customers.get(i + 1).getEmailAddress()))
                        fullDuplicate += 1;
                    else possibleDuplicates += 1;
                }
        }
        duplicates.setPossibleDuplicates(possibleDuplicates);
        duplicates.setFullDuplicates(fullDuplicate);
        return duplicates;
    }
}
