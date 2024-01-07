<h1>RM솔루션 구독 및 판매 시스템</h1>
<b>
    💡 해당 프로젝트는 서비스 구독 및 판매 시스템으로 Spring Boot를 이용해 백엔드 API 서버를 구성한 프로젝트입니다.
</b>
<h2>🔍Key points</h2>
<details>
    <summary>
        <h3 style="display: inline"> 1. 외래키 명시적 적용</h3>
    </summary>

![ERD](https://github.com/parksh93/GOALDDAE_BACK/assets/129180734/3779e6fd-7f66-4441-8ef8-980276d6006b)

해당 프로젝트는 users, subscribe, payment 총 3개의 DB로 설계되었습니다.<br/>
이때, payment 와 subscribe의 경우 users 테이블의 id 즉, 사용자의 고유번호를 FK로 가지게 됩니다.<br/>
하지만 실제 DB 적용 시에는 직접적으로 FK를 걸어주는 것이 아닌 명시적으로 user_id를 선언만 해주고 직접적으로 FK를 걸지 않습니다.
<br/>
<br/>

<h4>명시적으로 FK를 선언한 이유는?</h4>
FK를 직접적으로 선언하지 않은 이유는 <b style='color:orange'>대용량 서비스</b> 고려했기 때문입니다.<br/>
<b style='background-color:green'>서비스를 이용하는 사용자가 많지 않을 경우에는 FK를 걸어 DB의 무결성을 보장하는 것이 좋지만 사용자가 늘어남에 따라 데이터 생성 및 수정시에 항상 부모 테이블의 PK가 존재하는지 확인하게 되기 떄문에 성능 저하를 일으키게 됩니다.</b><br/>
그렇기 때문에 해당 프로젝트에서는 FK를 직접 걸지 않도록 설계했습니다.
</details>

<details>
    <summary>
        <h3 style="display: inline"> 2. Spring Security 적용</h3>
    </summary>
프로젝트를 진행하면서 보안성을 높이고자 Spring Security를 적용하였습니다.

`
BCryptPasswordEncoder
`
를 이용해 회원 가입 시 비밀번호를 암호화해 저장합니다. 그 후 로그인 시 입력받은 비밀번호를 암호화해 비교하여 로그인을 진행합니다.
<br><br>
로그인에 성공하게 되면 "ROLE_USER" 권한을 부여하여 사용자의 id와 loginId를 담은 JWT 토큰을 발급해 추후 서비스 이용 시 filter를 통해 권한에 따라 서비스 이용을 제한하게 됩니다.

</details>
<br>
<hr>
<h2>Tech</h2>
<h4>1. Language</h4>
<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white" />
<h4>2. Framework</h4>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat&logo=Spring Boot&logoColor=white"/>
<img src="https://img.shields.io/badge/MyBatis-ED1F35?style=flat&logo=MyBatis&logoColor=white"/>
<h4>3. Architecture</h4>
<img src="https://img.shields.io/badge/REST API-042133?style=flat&logo=REST&logoColor=white"/>
<h4>4. Security</h4>
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat&logo=Spring Security&logoColor=white"/>
<img src="https://img.shields.io/badge/JWT-666666?style=flat&logo=JWT&logoColor=white"/>
