package DTO;

public class CourseDTO {

	private Long id;



	private String title;

	private int ects;

	private boolean obligatory;

	private int numberOfLectures;

	private int numberOfExcercises;

	private String yearOfStudy;

	private String pic_name;

	private String mimetype;

	private byte[] pic;


	
	
	public CourseDTO(Long id, String title, int ects, boolean obligatory, int numberOfLectures, int numberOfExcercises,
			String yearOfStudy, String pic_name, String mimetype, byte[] pic) {
		this.id = id;
		this.title = title;
		this.ects = ects;
		this.obligatory = obligatory;
		this.numberOfLectures = numberOfLectures;
		this.numberOfExcercises = numberOfExcercises;
		this.yearOfStudy = yearOfStudy;
		this.pic_name = pic_name;
		this.mimetype = mimetype;
		this.pic = pic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public boolean isObligatory() {
		return obligatory;
	}

	public void setObligatory(boolean obligatory) {
		this.obligatory = obligatory;
	}

	public int getNumberOfLectures() {
		return numberOfLectures;
	}

	public void setNumberOfLectures(int numberOfLectures) {
		this.numberOfLectures = numberOfLectures;
	}

	public int getNumberOfExcercises() {
		return numberOfExcercises;
	}

	public void setNumberOfExcercises(int numberOfExcercises) {
		this.numberOfExcercises = numberOfExcercises;
	}

	

	public String getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(String yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getPic_name() {
		return pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	

}
