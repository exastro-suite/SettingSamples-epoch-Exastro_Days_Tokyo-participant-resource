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

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ParticipantForm {
	
	// セミナーID
	private int seminarId;
	
	// 参加者ID
	private int participantId;
	
	// ユーザーID
	private String userId;
	
	// ユーザー名
	private String userName;
	
	// SSO種別
	private String kindOfSso;
	
	// 登録日時
	private String registeredDate;
	
	public ParticipantForm() {
		
	}
	
	// 参加者登録用コンストラクタ
	public ParticipantForm(int seminarId, String userId, String userName, String kindOfSso, String registeredDate) {
		this.seminarId = seminarId;
		this.userId = userId;
		this.userName = userName;
		this.kindOfSso = kindOfSso;
		this.registeredDate = registeredDate;
	}
	
	// 参加者登録解除用コンストラクタ
	public ParticipantForm(int seminarId, int participantId, String userId, String userName, String kindOfSso,
			String registeredDate) {
		this.seminarId = seminarId;
		this.participantId = participantId;
		this.userId = userId;
		this.userName = userName;
		this.kindOfSso = kindOfSso;
		this.registeredDate = registeredDate;
	}
	
}
