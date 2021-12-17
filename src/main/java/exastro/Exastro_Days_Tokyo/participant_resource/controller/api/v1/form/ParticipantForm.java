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

package exastro.Exastro_Days_Tokyo.participant_resource.controller.api.v1.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParticipantForm {

//	セミナーID	
	@JsonProperty("seminar_id")
	private int seminarId;

//	参加者ID
	@JsonProperty("participant_id")
	private int participantId;
	
//	ユーザーID
	@JsonProperty("user_id")
	private String userId;

//	ユーザー名
	@JsonProperty("user_name")
	private String userName;

//	SSO種別
	@JsonProperty("kind_of_sso")
	private String kindOfSso;
	
//	登録日時
	@JsonProperty("registered_date")
	private String registeredDate;
	
	public ParticipantForm() {
	}

//参加者登録用コンストラクタ
	public ParticipantForm(int seminarId, String userId, String userName, String kindOfSso, String registeredDate) {
		this.seminarId = seminarId;
		this.userId = userId;
		this.userName = userName;
		this.kindOfSso = kindOfSso;
		this.registeredDate = registeredDate;
	}
	
//参加者登録解除用コンストラクタ
	public ParticipantForm(int seminarId, int participantId, String userId, String userName, String kindOfSso,
			String registeredDate) {
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

	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}	
	
}
