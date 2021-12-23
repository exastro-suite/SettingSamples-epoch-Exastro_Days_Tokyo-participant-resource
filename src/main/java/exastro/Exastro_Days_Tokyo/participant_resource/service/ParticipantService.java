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

package exastro.Exastro_Days_Tokyo.participant_resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exastro.Exastro_Days_Tokyo.participant_resource.repository.ParticipantRepository;
import exastro.Exastro_Days_Tokyo.participant_resource.repository.entity.Participant;
import exastro.Exastro_Days_Tokyo.participant_resource.service.dto.ParticipantDto;

@Service
public class ParticipantService {
	
	@Autowired
	protected ParticipantRepository repository;
	
	//セミナー参加人数確認
	public long countParticipant(int seminarId) {
		try{
			//セミナー参加人数を取得しリターン
			long count = repository.countBySeminarIdAndDeleteFlagFalse(seminarId);
			return count;
		}
		catch(Exception e) {
			throw e;
		}	
	}
	
	//参加者登録
	public int saveParticipant(ParticipantDto participantDto) {
		Participant participant = null;
		try {
			//DtoからEntityインスタンスを作成しDBにinsert
			participant = new Participant(participantDto.getSeminarId(),
					participantDto.getUserId(), participantDto.getUserName(), participantDto.getKindOfSso(),
					participantDto.getRegisteredDate());
			repository.save(participant);
			//登録した参加者の参加者IDを取得しリターン
			Participant target = repository.findByUserIdAndKindOfSsoIs(participantDto.getUserId(), participantDto.getKindOfSso());
			return target.getParticipantId();
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	//参加者登録解除
	public void deleteParticipant(int participantId) {
		try {
			//参加者の論削フラグを立てDBをupdate
			Participant target = repository.findByParticipantIdIs(participantId);
			target.setDeleteFlag(true);
			repository.save(target);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
}
