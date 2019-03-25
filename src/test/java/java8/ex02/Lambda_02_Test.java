package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

    // tag::PersonToAccountMapper[]
    interface PersonToAccountMapper {
        Account map(Person p);
    }
    // end::PersonToAccountMapper[]
    interface PersonToNameMapper {
        String map(Person p);
    }
    private List<Account> map(List<Person> personList, PersonToAccountMapper mapper) {
        // TODO implémenter la méthode
    	List<Account>result = new ArrayList<>();
    	for (Person person : personList) {
			 
				result.add(mapper.map(person));
			
		}
		return result;
        
    }
    
    private List<String> map(List<Person> personList, PersonToNameMapper mapper) {
   List<String> result = new ArrayList<>();
   for (Person p : personList){
	   result.add(mapper.map(p));
   }
   return result;
    }
    // end::map[]


    // tag::test_map_person_to_account[]
    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        PersonToAccountMapper tim = new PersonToAccountMapper() {
			@Override
			public Account map(Person p) {
				Account tik = new Account();
				tik.setBalance(100);
				tik.setOwner(p);
				return tik;
				}
		};
        // TODO transformer la liste de personnes en liste de comptes
        // TODO tous les objets comptes ont un solde à 100 par défaut
        List<Account> result = map(personList, tim);

        assertThat(result, hasSize(personList.size()));
        assertThat(result, everyItem(hasProperty("balance", is(100))));
        assertThat(result, everyItem(hasProperty("owner", notNullValue())));
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        
        // TODO transformer la liste de personnes en liste de prénoms
        List<String> result = null;
//        for(Person p:personList)
//        {
//        	String g = p.getFirstname();
//        result.add(g);
//        }
        PersonToNameMapper tim = new PersonToNameMapper() {
			@Override
			public String map(Person p) {
				
				
				return p.getFirstname();
				}
		};
		result = map(personList, tim);
        assertThat(result, hasSize(personList.size()));
        assertThat(result, everyItem(instanceOf(String.class)));
        assertThat(result, everyItem(startsWith("first")));
    }
    // end::test_map_person_to_firstname[]
}
