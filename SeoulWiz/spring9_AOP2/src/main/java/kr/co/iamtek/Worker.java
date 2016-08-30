package kr.co.iamtek;

public class Worker {

	private String name;
	private int age;
	private String  job;
	
	public void getWorkerInfo() {
		System.out.println(
				"이름 : " + getName() +
				", 나이 : " + getAge() + 
				", 직업 : " + getJob()
		);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
