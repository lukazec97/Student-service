package DTO;

import java.util.Set;

public class StudyProgramDTO {
	
	
	private Long id;

	private String name;


	private String rukovodilac;

	private String center;

	private Set<YearOfStudyDTO> yearsOfStudy;

	private String pic_name;

	private String mimetype;

	private byte[] pic;

	
	

	public StudyProgramDTO(Long id, String name, String rukovodilac, String center, Set<YearOfStudyDTO> yearsOfStudy,
			String pic_name, String mimetype, byte[] pic) {
		this.id = id;
		this.name = name;
		this.rukovodilac = rukovodilac;
		this.center = center;
		this.yearsOfStudy = yearsOfStudy;
		this.pic_name = pic_name;
		this.mimetype = mimetype;
		this.pic = pic;
	}
	
	

	public StudyProgramDTO(Long id, String name, String center, Set<YearOfStudyDTO> yearsOfStudy, String pic_name,
			String mimetype, byte[] pic) {
		this.id = id;
		this.name = name;
		this.center = center;
		this.yearsOfStudy = yearsOfStudy;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	


	public String getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(String rukovodilac) {
		this.rukovodilac = rukovodilac;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public Set<YearOfStudyDTO> getYearsOfStudy() {
		return yearsOfStudy;
	}

	public void setYearsOfStudy(Set<YearOfStudyDTO> yearsOfStudy) {
		this.yearsOfStudy = yearsOfStudy;
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
