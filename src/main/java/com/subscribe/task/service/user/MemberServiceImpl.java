package com.subscribe.task.service.user;

import com.subscribe.task.dto.user.FindMemberDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;
import com.subscribe.task.exception.NotFoundUserException;
import com.subscribe.task.repository.MemberRepository;
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
    public void save(SaveUserDTO saveUserDTO) {
        memberRepository.save(saveUserDTO);
    }

    @Override
    public FindMemberDTO findUser(SignInDTO signInDTO) {
        FindMemberDTO findMemberDTO = memberRepository.findByLoginId(signInDTO.getLoginId());

        if(findMemberDTO != null) {
            if(findMemberDTO.getPassword().equals(signInDTO.getPassword())){
                return findMemberDTO;
            }
        }

        throw new NotFoundUserException("not match");
    }
}
