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

package exastro.Exastro_Days_Tokyo.participant_resource.controller.api.v1;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exastro.Exastro_Days_Tokyo.participant_resource.controller.api.v1.form.ParticipantForm;
import exastro.Exastro_Days_Tokyo.participant_resource.service.ParticipantService;
import exastro.Exastro_Days_Tokyo.participant_resource.service.dto.ParticipantDto;

@RestController
@RequestMapping("/api/v1/participant")
public class ParticipantController{
	
	@Autowired
	protected ParticipantService service;
	
	//セミナー参加人数確認
	@GetMapping(value = "",
			produces = MediaType.APPLICATION_JSON_VALUE )
	public long getParticipant(@RequestParam ("seminar_id") int seminarId) {
		try{
			//セミナー参加人数を取得しリターン
			long count = service.countParticipant(seminarId);
			return count;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	//参加者登録
	@PostMapping(
				value = "",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE )
	public int saveParticipant(@RequestBody ParticipantForm participantForm) {
		ParticipantDto participantDto = null;
		try{
			//登録日時をString型→Timestamp型へ型変換
			Timestamp ts = Timestamp.valueOf(participantForm.getRegisteredDate());
			
			//FormからDtoインスタンスを作成
			participantDto = new ParticipantDto(participantForm.getSeminarId(),
					participantForm.getUserId(), participantForm.getUserName(), participantForm.getKindOfSso(),
					ts);
			return service.saveParticipant(participantDto);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	//参加者登録解除
	@DeleteMapping(
				value = "/{participantId}",
				produces = MediaType.APPLICATION_JSON_VALUE )
	public void deleteParticipant(@PathVariable(value = "participantId") @Validated int participantId) {
		try{
			service.deleteParticipant(participantId);
		}
		catch(Exception e) {
			throw e;
		}
	}
}