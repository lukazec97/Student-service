package DTO;

import java.util.Set;

public class CenterDTO {
	
	
	
	private Long id;
	
	private String name;

	private String pic_name;

	private String mimetype;

	private Set<StudyProgramDTO> studyPrograms;

	private byte[] pic;


	

	


	public CenterDTO(Long id, String name, String pic_name, String mimetype, Set<StudyProgramDTO> studyPrograms,
			byte[] pic) {
		this.id = id;
		this.name = name;
		this.pic_name = pic_name;
		this.mimetype = mimetype;
		this.studyPrograms = studyPrograms;
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


	public Set<StudyProgramDTO> getStudyPrograms() {
		return studyPrograms;
	}


	public void setStudyPrograms(Set<StudyProgramDTO> studyPrograms) {
		this.studyPrograms = studyPrograms;
	}
	
	
	
	

}
