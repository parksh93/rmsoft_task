package com.subscribe.task.service;

import com.subscribe.task.dto.FindMemberDTO;
import com.subscribe.task.dto.SaveDTO;
import com.subscribe.task.repository.MemberRepository;
import com.subscribe.task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public List<FindMemberDTO> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void save(SaveDTO saveDTO) {
        memberRepository.save(saveDTO);
    }
}
