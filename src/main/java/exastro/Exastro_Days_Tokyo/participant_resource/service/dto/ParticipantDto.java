package exastro.Exastro_Days_Tokyo.participant_resource.service.dto;

import java.sql.Timestamp;

public class ParticipantDto {

//	セミナーID	
	private int seminarId;

//	参加者ID
	private int participantId;
	
//	ユーザーID
	private String userId;

//	ユーザー名	
	private String userName;

//	SSO種別
	private String kindOfSso;
	
//	登録日時
	private Timestamp registeredDate;

//参加者登録用コンストラクタ
	public ParticipantDto(int seminarId, String userId, String userName, String kindOfSso, Timestamp registeredDate) {
		this.seminarId = seminarId;
		this.userId = userId;
		this.userName = userName;
		this.kindOfSso = kindOfSso;
		this.registeredDate = registeredDate;
	}
	
//参加者登録解除用コンストラクタ
	public ParticipantDto(int seminarId, int participantId, String userId, String userName, String kindOfSso,
			Timestamp registeredDate) {
		this.seminarId = seminarId;
		this.participantId = participantId;
		this.userId = userId;
		this.userName = userName;
		this.kindOfSso = kindOfSso;
		this.registeredDate = registeredDate;
	}

	public int getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(int seminarId) {
		this.seminarId = seminarId;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getKindOfSso() {
		return kindOfSso;
	}

	public void setKindOfSso(String kindOfSso) {
		this.kindOfSso = kindOfSso;
	}

	public Timestamp getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Timestamp registeredDate) {
		this.registeredDate = registeredDate;
	}	
	
}