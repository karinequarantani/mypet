package com.mypet.application.service;

import com.mypet.application.model.Tutor;
import com.mypet.application.model.dto.TutorDTO;
import com.mypet.application.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public Tutor insert(TutorDTO tutorDTO){
        var tutor = Tutor.builder()
                .name(tutorDTO.getName())
                .birthday(tutorDTO.getBirthday())
                .gender(tutorDTO.getGender())
                .phone(tutorDTO.getPhone())
                .email(tutorDTO.getEmail()).build();
        return tutorRepository.save(tutor);
    }

    public Tutor update(TutorDTO tutorDTO, String tutorId){
        var tutor = tutorRepository.findById(tutorId).orElseThrow();
        BeanUtils.copyProperties(tutorDTO, tutor, getNullFields(tutorDTO));
        tutor.setUpdatedAt(LocalDateTime.now());
        return tutorRepository.save(tutor);
    }

    public List<Tutor> findAll(){
        return tutorRepository.findAll();
    }

    public void delete(String tutorId){
        tutorRepository.deleteById(tutorId);
    }

    public String[] getNullFields(TutorDTO tutorDTO){
        List<String> ignoreFields = new ArrayList<>();
        if (tutorDTO.getName() == null){
            ignoreFields.add("name");
        }
        if(tutorDTO.getBirthday() == null){
            ignoreFields.add("birthday");
        }
        if(tutorDTO.getGender() == null){
            ignoreFields.add("gender");
        }
        if(tutorDTO.getPhone() == null){
            ignoreFields.add("phone");
        }
        if(tutorDTO.getEmail() == null){
            ignoreFields.add("email");
        }
        return ignoreFields.toArray(String[]::new);
    }

    public Tutor findById(String tutorId){
        var tutor = tutorRepository.findById(tutorId);
        if(tutor.isEmpty()){
            throw new EntityNotFoundException("Tutor not found");
        }
        return tutor.get();
    }
}
