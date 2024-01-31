package modules;

public class Patientinfo {
	private int patientId;
	private String patientName;
	private int age;
	private int weight;
	private int height;
	private String city;
	private String diagnosis;
	private int doctorId;
	
	
	
	public Patientinfo() {
		super();
	}
	public Patientinfo(int patientId, String patientName, int age, int weight, int height, String city,
			String diagnosis, int doctorId) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.city = city;
		this.diagnosis = diagnosis;
		this.doctorId = doctorId;
	}
	
	public Patientinfo(String patientName, int age, int weight, int height, String city, String diagnosis,
			int doctorId) {
		super();
		this.patientName = patientName;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.city = city;
		this.diagnosis = diagnosis;
		this.doctorId = doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorsId(int doctorId) {
		this.doctorId = doctorId;
	}
	@Override
	public String toString() {
		return "patientinfo [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", weight="
				+ weight + ", height=" + height + ", city=" + city + ", diagnosis=" + diagnosis + ", doctorId="
				+ doctorId + "]";
	}
	

}
