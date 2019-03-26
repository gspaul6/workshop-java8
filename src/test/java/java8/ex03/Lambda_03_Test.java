package java8.ex03;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 03 - ForEach
 */
public class Lambda_03_Test {

	// tag::PersonProcessor[]
	interface PersonProcessor {
		void process(Person p);
	}
	// end::PersonProcessor[]

	// tag::forEach[]
	private void forEach(List<Person> source, PersonProcessor processor) {
		// TOD0
		for (Person person : source) {

			processor.process(person);

		}

	}

	// end::forEach[]

	// tag::test_verify_person[]
	@Test
	public void test_verify_person() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// TODO vérifier qu'une personne à un prénom qui commence par first
		PersonProcessor poo1 = new PersonProcessor() {

			@Override
			public void process(Person p) {
				// TODO Auto-generated method stub
				if (p.getFirstname().equals("first")) {
					System.out.println("this name is commencing" + p);
				}

			}

		};

		// TODO vérifier qu'une personne à un nom qui commence par last
		PersonProcessor poo2 = new PersonProcessor() {

			@Override
			public void process(Person p) {
				// TODO Auto-generated method stub
				if (p.getLastname().equals("last")) {
					System.out.println("this name is commencing" + p);

				}
			}

		};

		// TODO vérifier qu'une personne à un age > 0
		PersonProcessor poo3 = new PersonProcessor() {

			@Override
			public void process(Person p) {
				// TODO Auto-generated method stub
				if (p.getAge()>0) {
					System.out.println("this name is commencing" + p.toString());
				}

			}

		};

		PersonProcessor verifyPerson = poo3;

		assertThat(verifyPerson, notNullValue());

		forEach(personList, verifyPerson);
	}
	// end::test_verify_person[]

}
