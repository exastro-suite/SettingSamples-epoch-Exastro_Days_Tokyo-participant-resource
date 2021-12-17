/*   Copyright 2021 NEC Corporation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package exastro.Exastro_Days_Tokyo.participant_resource.repository.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * The persistent class for the participants database table.
 * 
 */
@Entity
@Table(name="participants")
public class Participant {
	
	@Column(name="seminar_id")
	private int seminarId;
	
	@Id
	@Column(name="participant_id")
	private int participantId;

	@Column(name="user_id")
	private String userId;

	@Column(name="user_name")
	private String userName;
	
	@Column(name="kind_of_sso")
	private String kindOfSso;
	
	@Column(name="registered_date")
	private Timestamp registeredDate;
	
	@Column(name="delete_flag")
	private boolean deleteFlag;
	//コンストラクタ
	public Participant() {
	}
	
	//参加者登録用コンストラクタ
	public Participant(int seminarId, String userId, String userName, String kindOfSso,
			Timestamp registeredDate) {
		this.seminarId = seminarId;
		this.userId = userId;
		this.userName = userName;
		this.kindOfSso = kindOfSso;
		this.registeredDate = registeredDate;
		this.deleteFlag = false;
	}
	
	//参加者登録解除用コンストラクタ
	public Participant(int seminarId, int participantId, String userId, String userName, String kindOfSso,
			Timestamp registeredDate) {
		this.seminarId = seminarId;
		this.participantId = participantId;
		this.userId = userId;
		this.userName = userName;
		this.kindOfSso = kindOfSso;
		this.registeredDate = registeredDate;
		this.deleteFlag = false;
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

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
		
}
