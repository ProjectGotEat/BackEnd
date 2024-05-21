package javaeatsong.goteat.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.repository.ParticipantsMapper;
import javaeatsong.goteat.model.Participants;

@Service
public class ParticipantsService {

	@Autowired
	private ParticipantsMapper participantsMapper;
	
    public void postParticipant(Participants participant) throws Exception {
        participantsMapper.insert(participant);
    }
}
