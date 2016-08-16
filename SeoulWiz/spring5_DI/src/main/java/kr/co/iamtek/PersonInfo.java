package kr.co.iamtek;

public class PersonInfo {
	
	private Person person;

	public PersonInfo(Person person) {
		super();
		this.person = person;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	public void getPersonInfo() {
		if(person != null) {
			System.out.println(
					"이름 : " + person.getName() +
					"\n\t" +
					"성별 : " + person.getGender() +
					", 나이 : " + person.getAge() +
					", 직업 : " + person.getJob() +
					"\n-----------------------------------------------------"
			);
		}
	}
}
