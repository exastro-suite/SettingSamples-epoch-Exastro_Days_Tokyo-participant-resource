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

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exastro.Exastro_Days_Tokyo.participant_resource.repository.ParticipantRepository;
import exastro.Exastro_Days_Tokyo.participant_resource.repository.entity.Participant;
import exastro.Exastro_Days_Tokyo.participant_resource.service.dto.ParticipantDto;

@Service
public class ParticipantUserService extends BaseParticipantService implements ParticipantService {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected ParticipantRepository repository;
	
	//セミナー参加人数確認
	public long countParticipant(int seminarId) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		try{
			//セミナー参加人数を取得しリターン
			long count = repository.countBySeminarIdAndDeleteFlagFalse(seminarId);
			return count;
		}
		catch(Exception e) {
			throw e;
		}	
	}
	
	//申込済みセミナー確認
	public List<ParticipantDto> getParticipant(String userId, String kindOfSso){
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		List<ParticipantDto> participantList = null;
		
		try{
			//申込済みのセミナーidをリターン
			participantList = repository.findByDeleteFlagFalseAndUserIdAndKindOfSsoIs(userId, kindOfSso)
					.stream()
					.map(p -> new ParticipantDto(p.getSeminarId(), p.getParticipantId(), p.getUserId(), p.getUserName(),
							p.getKindOfSso(), p.getRegisteredDate(), p.isDeleteFlag()))
					.collect(Collectors.toList());			
		}
		catch(Exception e) {
			throw e;
		}
		return participantList;
	}
	
	//参加者登録
	public void saveParticipant(ParticipantDto participantDto) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		Participant participant = null;
		
		try {
			//DtoからEntityインスタンスを作成しDBにinsert
			participant = new Participant(participantDto.getSeminarId(),
					participantDto.getUserId(), participantDto.getUserName(), participantDto.getKindOfSso(),
					new Timestamp(participantDto.getRegisteredDate().getTime()));
			repository.save(participant);
		}
		catch(Exception e) {
			throw e;
		}
	}

}
