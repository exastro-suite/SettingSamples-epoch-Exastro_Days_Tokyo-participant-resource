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

package exastro.Exastro_Days_Tokyo.participant_resource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exastro.Exastro_Days_Tokyo.participant_resource.repository.entity.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, String> {
	
	//セミナー参加人数を取得
	Integer countBySeminarIdAndDeleteFlagFalse(int seminarId);
	
	//申込済みのセミナーIdを取得
	List<Participant> findByDeleteFlagFalseAndUserIdAndKindOfSsoIs(String userId, String kindOfSso);
	
	//参加者を取得
	Participant findByDeleteFlagFalseAndUserIdAndKindOfSsoAndSeminarIdIs(String userId, String kindOfSso, int seminarId);
	
}
