# <img width="30" alt="Group 1000003635" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/6619b13d-0e84-423e-8bde-65d4f7e80147"> 어디든지 이동할 수 있는 팝업카 플랫폼, 콜팝

<img width="1920" alt="Slide 16_9 - 4-2" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/fc3a5209-4ecd-4b7d-ab97-b1339369c763">


<br>

## 프로젝트 소개

- 현재 진행중인 팝업카 목록 및 상세 조회를 할 수 있습니다.
- 오픈 예정 팝업카 방문 위치를 사용자가 투표하고 결과를 확인할 수 있습니다.
- 팝업카 현장에서 입장 웨이팅을 등록하고 알림을 받을 수 있습니다.
- 팝업카에서 진행중인 이벤트를 확인 및 확인 코드를 통해 참여 인증을 할 수 있습니다.

<br>

## 팀원 구성

<div align="center">

|**👨🏻‍💻김형민**|**👩🏻‍🎨박지원**|**👩🏻‍💼송지희**|**👨🏻‍💻이태곤**|**👩🏻‍💻윤유정**|
|:------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------:|
|<img src="https://github.com/taegon98/softee5-tenten-BE/assets/102223636/b19791cf-59d4-4d89-beba-6cea0096b05c" height=180 width=150> <br/> |<img src="https://github.com/taegon98/softee5-tenten-BE/assets/102223636/97fda033-59dd-4c91-8425-718e5116c692" height=180 width=150> <br/>| <img src="https://github.com/taegon98/softee5-tenten-BE/assets/102223636/2839b2ed-bd63-4be0-a88c-90ef00e31fd1" height=180 width=150> <br/>| <img src="https://github.com/taegon98/softee5-tenten-BE/assets/102223636/85749d8a-b427-47e3-82a0-ed8ec2b9777b" height=180 width=150> <br/> |<img src="https://github.com/taegon98/softee5-tenten-BE/assets/102223636/6d1c399e-17e0-4051-83e5-117dd212d4cc" height=180 width=150> <br/> |
|**Backend/Android**|**Design**|**PM**|**Backend/Infra**|**Android**|
</div>

<br>

## 1. 개발 환경

- Android : Android studio, Kotlin 1.5.0
- Backend : Java17, Spring boot 3,2,1, JPA, H2, Swagger, AWS EC2, AWS S3
- 버전 및 이슈관리 : Github, Github Issues, Github Desktop, Docker hub
- 협업 툴 : Notion, Slack, Github
- 서비스 배포 환경 : AWS EC2
- [커밋 컨벤션](https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/wiki/Git-commit-convention)
- [코드 컨벤션](https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/wiki/Git-code-convention)
- [API Document](https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/wiki/API-document)

<br>

## 2. 브랜치 전략

- Upstream repository를 각자의 Origin repository에 clone 받아서 개발을 진행하였습니다.
- Upstream repository에서 API 단위로 issue branch를 생성후에 나누어서 개발을 진행하였습니다.
  - Origin repository의 작업을 해당 issue branch로 pull request
  - Upstream repository의 main으로 merge 하기전에 peer review

<br>

## 3. 프로젝트 구조

```
├── Dockerfile
├── README.md
├── build
│   ├── classes
│   │   └── java
│   │       ├── main
│   │       │   └── softeer
│   │       │       └── tenten
│   │       │           ├── TentenApplication.class
│   │       │           ├── config
│   │       │           │   └── S3
│   │       │           │       └── S3Config.class
│   │       │           ├── controller
│   │       │           │   ├── event
│   │       │           │   │   ├── EventController.class
│   │       │           │   │   └── UserEventController.class
│   │       │           │   ├── popup
│   │       │           │   │   └── PopupController.class
│   │       │           │   ├── review
│   │       │           │   │   └── ReviewController.class
│   │       │           │   ├── user
│   │       │           │   │   └── UserController.class
│   │       │           │   ├── vote
│   │       │           │   │   └── VoteController.class
│   │       │           │   └── waiting
│   │       │           │       └── WaitingController.class
│   │       │           ├── dto
│   │       │           │   ├── event
│   │       │           │   │   ├── EventRequest$EventCode$EventCodeBuilder.class
│   │       │           │   │   ├── EventRequest$EventCode.class
│   │       │           │   │   ├── EventRequest.class
│   │       │           │   │   ├── EventResponse$EventDetail$EventDetailBuilder.class
│   │       │           │   │   ├── EventResponse$EventDetail.class
│   │       │           │   │   ├── EventResponse$EventList$EventListBuilder.class
│   │       │           │   │   ├── EventResponse$EventList.class
│   │       │           │   │   └── EventResponse.class
│   │       │           │   ├── popup
│   │       │           │   │   ├── PopupResponse$PopupDetail$PopupDetailBuilder.class
│   │       │           │   │   ├── PopupResponse$PopupDetail.class
│   │       │           │   │   ├── PopupResponse$PopupList$PopupListBuilder.class
│   │       │           │   │   ├── PopupResponse$PopupList.class
│   │       │           │   │   ├── PopupResponse.class
│   │       │           │   │   └── waiting
│   │       │           │   │       ├── WaitingResponse$WaitingInformation$WaitingInformationBuilder.class
│   │       │           │   │       ├── WaitingResponse$WaitingInformation.class
│   │       │           │   │       └── WaitingResponse.class
│   │       │           │   ├── review
│   │       │           │   │   ├── ReviewResponse$ReviewList$ReviewListBuilder.class
│   │       │           │   │   ├── ReviewResponse$ReviewList.class
│   │       │           │   │   └── ReviewResponse.class
│   │       │           │   ├── user
│   │       │           │   │   ├── UserRequest$Login$LoginBuilder.class
│   │       │           │   │   ├── UserRequest$Login.class
│   │       │           │   │   ├── UserRequest.class
│   │       │           │   │   ├── UserResponse$Login$LoginBuilder.class
│   │       │           │   │   ├── UserResponse$Login.class
│   │       │           │   │   └── UserResponse.class
│   │       │           │   ├── vote
│   │       │           │   │   ├── VoteRequest$VoteOption$VoteOptionBuilder.class
│   │       │           │   │   ├── VoteRequest$VoteOption.class
│   │       │           │   │   ├── VoteRequest.class
│   │       │           │   │   ├── VoteResponse$RegisterVote$RegisterVoteBuilder.class
│   │       │           │   │   ├── VoteResponse$RegisterVote.class
│   │       │           │   │   └── VoteResponse.class
│   │       │           │   └── waiting
│   │       │           │       ├── WaitingRequest$RegisterWaiting$RegisterWaitingBuilder.class
│   │       │           │       ├── WaitingRequest$RegisterWaiting.class
│   │       │           │       └── WaitingRequest.class
│   │       │           ├── entity
│   │       │           │   ├── area
│   │       │           │   │   ├── Destination$DestinationBuilder.class
│   │       │           │   │   ├── Destination.class
│   │       │           │   │   ├── Option$OptionBuilder.class
│   │       │           │   │   └── Option.class
│   │       │           │   ├── criteria
│   │       │           │   │   ├── Brand$BrandBuilder.class
│   │       │           │   │   ├── Brand.class
│   │       │           │   │   ├── Category$CategoryBuilder.class
│   │       │           │   │   ├── Category.class
│   │       │           │   │   ├── PopupTag$PopupTagBuilder.class
│   │       │           │   │   ├── PopupTag.class
│   │       │           │   │   ├── Tag$TagBuilder.class
│   │       │           │   │   └── Tag.class
│   │       │           │   ├── event
│   │       │           │   │   ├── Event$EventBuilder.class
│   │       │           │   │   ├── Event.class
│   │       │           │   │   ├── UserEvent$UserEventBuilder.class
│   │       │           │   │   └── UserEvent.class
│   │       │           │   ├── popup
│   │       │           │   │   ├── Popup$PopupBuilder.class
│   │       │           │   │   ├── Popup.class
│   │       │           │   │   ├── PopupImage$PopupImageBuilder.class
│   │       │           │   │   └── PopupImage.class
│   │       │           │   ├── review
│   │       │           │   │   ├── Review$ReviewBuilder.class
│   │       │           │   │   └── Review.class
│   │       │           │   ├── user
│   │       │           │   │   ├── User$UserBuilder.class
│   │       │           │   │   └── User.class
│   │       │           │   ├── vote
│   │       │           │   │   ├── Vote$VoteBuilder.class
│   │       │           │   │   └── Vote.class
│   │       │           │   └── waiting
│   │       │           │       ├── Waiting$WaitingBuilder.class
│   │       │           │       └── Waiting.class
│   │       │           ├── global
│   │       │           │   ├── api
│   │       │           │   │   ├── ApiResponse.class
│   │       │           │   │   └── status
│   │       │           │   │       └── StatusCode.class
│   │       │           │   ├── exception
│   │       │           │   │   └── GeneralException.class
│   │       │           │   └── handler
│   │       │           │       └── GlobalExceptionHandler.class
│   │       │           ├── mapper
│   │       │           │   ├── event
│   │       │           │   │   └── EventMapper.class
│   │       │           │   ├── popup
│   │       │           │   │   └── PopupMapper.class
│   │       │           │   ├── review
│   │       │           │   │   └── ReviewMapper.class
│   │       │           │   ├── user
│   │       │           │   │   └── UserMapper.class
│   │       │           │   ├── vote
│   │       │           │   │   └── VoteMapper.class
│   │       │           │   └── waiting
│   │       │           │       └── WaitingMapper.class
│   │       │           ├── repository
│   │       │           │   ├── area
│   │       │           │   │   └── OptionRepository.class
│   │       │           │   ├── event
│   │       │           │   │   ├── EventRepository.class
│   │       │           │   │   └── UserEventRepository.class
│   │       │           │   ├── popup
│   │       │           │   │   └── PopupRepository.class
│   │       │           │   ├── review
│   │       │           │   │   └── ReviewRepository.class
│   │       │           │   ├── user
│   │       │           │   │   └── UserRepository.class
│   │       │           │   ├── vote
│   │       │           │   │   └── VoteRepository.class
│   │       │           │   └── waiting
│   │       │           │       └── WaitingRepository.class
│   │       │           └── service
│   │       │               ├── S3
│   │       │               │   └── AwsS3Service.class
│   │       │               ├── event
│   │       │               │   ├── EventService.class
│   │       │               │   └── UserEventService.class
│   │       │               ├── popup
│   │       │               │   └── PopupService.class
│   │       │               ├── review
│   │       │               │   └── ReviewService.class
│   │       │               ├── user
│   │       │               │   └── UserService.class
│   │       │               ├── vote
│   │       │               │   └── VoteService.class
│   │       │               └── waiting
│   │       │                   └── WaitingService.class
```

<br>

## 4. ER Diagram
![callpop](https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/22537053-da43-4a59-816b-38379a14baf8)

<br>

## 5. System Architecture
<img width="1921" alt="Slide 16_9 - 18-2" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/b26af373-2128-497d-8ac8-fc17edaae0c9">

<br>

## 6. Information Architecture
<img width="1920" alt="Slide 16_9 - 5" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/f450a10a-e0dd-4d40-b05d-9c49454d4e1a">

<br>

## 7. 역할 분담

### 👨🏻‍💻김형민

- **Backend**: 로그인, 투표 기능, 투표 결과 조회, 웨이팅 기능
- **Android**: 로그인 화면, 이벤트 조회 화면, 이벤트 상세 페이지 화면, 이벤트 참여코드 입력 화면, 웨이팅 등록 화면, 투표 화면

### 👩🏻‍🎨박지원

- UI 디자인
- 로고, 브랜딩 등 시각화 작업
- 디자인 시스템 정리
- 유저플로우

### 👩🏻‍💼송지희

- 마일스톤 설정 및 WBS 작성
- 시장 및 타겟 분석 및 설문조사
- 페르소나 설정
- IA 및 기능 명세
- 화면 설계 - 와이어프레임
- 더미 데이터 구축

### 👨🏻‍💻이태곤

- **Backend**: 팝업 스토어 조회, 팝업 스토어 상세 조회, 이벤트 조회, 이벤트 상세 조회, 이벤트 참여, 리뷰 조회
- **Infra**: AWS S3 Bucket 생성, AWS EC2 배포, Docker container 생성

### 👩🏻‍💻윤유정

- **Android**: 메인 화면, 팝업 상세 페이지 화면, 팝업 상세 정보 탭, 대기 등록 / 입장 안내 팝업 화면, 이벤트 참여 코드 인증 기능, NAVER MAP API
  

<br>

## 8. 개발 기간 및 작업 관리

### 개발 기간

- 전체 개발 기간 : 2024-01-05 ~ 2024-01-10
- UI 구현 : 2024-01-05 ~ 2024-01-08
- 기능 구현 : 2024-01-06 ~ 2024-01-09

<br>

### 작업 관리

- GitHub Issues 생성, Github wiki 및 Slack을 통해 진행 상황을 공유했습니다.
- 워밍업 프로젝트가 진행되는 5일동안 매일 아침 10시 회의를 진행하며, 진행 상황과 오늘 할 일을 공유하고 Notion에 회의 내용을 기록했습니다.


<br>

## 9. 페이지별 기능

### [로그인]
- 사용자 아이디와 비밀번호를 입력하여 로그인을 진행합니다.
- 로그인 버튼 클릭 시 아이디 또는 비밀번호가 일치하지 않을 경우에는 경고 문구가 나타나며, 로그인에 성공하면 홈 피드 화면으로 이동합니다.

| 로그인 |
|----------|
|<img width="360" alt="로그인" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/2255e3cf-a33d-454b-819c-8ae32c55d28f">|



<br>

### [홈 화면]
- 로그인 성공시 팝업 스토어 전체 목록을 제공받을 수 있습니다.
  - 내 근처 팝업카: 사용자의 위치에 따라 가까운 순서대로 팝업 스토 목록을 제공합니다.
    - 더보기 버튼을 누르게 되면, 전체 팝업 스토어 목록을 거리가 가까운순에 따라 제공받을 수 있습니다.
  - 추천하는 팝업카 (개선 사항): 스크랩이 많은 순서에 따라 팝업 스토어 목록을 제공합니다.
  - 오픈 예정 팝업카: 오픈예정인 팝업 스토어 목록을 제공합니다.
- 팝업 스토어를 클릭하면 상세정보 화면으로 이동할 수 있습니다.

| 홈 |
|----------|
|<img width="361" alt="홈화면" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/c7b1121c-44c9-40d9-9c13-ebc5f50fb1ee">|

<br>

### [팝업 스토어 상세 정보(오픈)]
- 팝업 스토어를 클릭하면 상세정보를 확인할 수 있습니다.
  - 행사 위치, 판매 품목과 같은 상세 정보와 이벤트, 리뷰 등 팝업카 스토어에 대한 모든 정보를 확인할 수 있습니다.
- 대기 줄서기 버튼 클릭을 통해, 웨이팅을 등록할 수 있습니다.
  - 본인의 대기번호 및 앞에 대기중인 팀이 몇팀인지 확인할 수 있습니다.
  - 본인의 순서가되면, 팝업 알림을 받을 수 있습니다. (개선 사항)


| 팝업 스토어 상세 화면 | 대기 중 화면 |
|----------|----------|
|<img width="377" alt="상세페이지 - 상세정보-2" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/ca6fa1d9-96cd-49fc-b06e-c68e8995e991">|<img width="377" alt="상세페이지 - 상세정보 펼침-2" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/6085ffa0-a4e7-420a-9ca5-f55ee7227420">|


<br>

### [팝업 스토어 상세 정보(오픈 예정)]
- 오픈 예정 팝업 스토어 상세정보를 확인할 수 있습니다.
  - 원하는 지역을 투표할 수 있습니다.
  - 하나의 팝업 스토어에 대해서 중복 투표가 불가능합니다.
- 투표 진행시에 통계된 결과화면을 확인할 수 있습니다.

| 팝업 스토어 투표 | 투표 결과 확인 | 
|----------|----------|
|<img width="377" alt="상세페이지 - 오픈예정 상세 - 투표 모달" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/300cad7a-d629-4a4e-aad7-44b8f37dd5bb">|<img width="354" alt="Group 1000003639" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/3987f66e-824a-4a68-b950-5ee13b0e701f">|

<br>

### [이벤트 조회]
- 팝업 스토어에서 진행중인 이벤트 목록을 확인할 수 있습니다.
- 이벤트 클릭시에 상세 화면으로 이동할 수 있습니다.
  - 이벤트 소개 및 참여 방법 등을 확인할 수 있습니다.
  - 참여 인증하기 버튼을 클릭하고 직원 코드를 입력하여 참여 인증을 할 수 있습니다.

| 이벤트 전체 조회 | 이벤트 상세 조회 | 이벤트 참여 코드 입력 화면 |
|----------|----------|----------|
|<img width="360" alt="상세페이지 - 이벤트" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/ecd6f38f-d1ca-4b31-9a68-53f011332ae1">|<img width="361" alt="상세페이지 - 이벤트 - 상세 - 참여 인증 모달" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/e97509e4-c5a9-40fc-9733-a3860330cac8">|<img width="361" alt="상세페이지 - 이벤트 - 상세 - 참여 인증 모달 - 입력-2" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/16274a4d-82ee-4c9d-8e60-c840645e0b7c">|



### [리뷰 조회]
- 팝업 스토어를 방문한 방문자의 리뷰를 조회할 수 있습니다.
  - 닉네임, 방문 위치, 방문 날짜(팝업 스토어가 열린 날짜), 내용을 확인할 수 있습니다.

| 리뷰 조회 |
|----------|
|<img width="360" alt="상세페이지 - 리뷰" src="https://github.com/softeerbootcamp-3nd/softee5-tenten-BE/assets/102223636/edcc9b2d-3299-4b68-97a0-bce975a18a3d">|


<br>

## 10. Trouble Shooting 🚀

- ### **@RequestBody가 선언된 객체의 final field 이슈**
  - 컨트롤러에서 @RequestBody를 사용할 경우달 해당 객체는 내장된 Jackson라이브러리를 통해 json을 자바 객체로 변환된다.
  - 자바 객체로 변환되는 역직렬화 과정에서 default 생성자가 있어야 한다.
  - 최초 final로 필드를 선언해서 default 생성자가 불가능해서 에러가 발생했다.
  - **Solution**: final 선언 삭제

- ### **@Docker image pull 이슈**
  - M1 mac book에서 Docker image를 build -> Docker hub push
  - ec2 ubuntu 환경에서 해당 docker image가 pull 할 때 문제 발생
    - Error code:  WARNING: The requested image's platform (linux/arm64/v8) 
 does not match the detected host platform (linux/amd64) 
 and no specific platform was requested standard_init_linux.go:228: 
 exec user process caused: exec format error
  - M1칩에서는 Docker image 빌드시에 linux/arm64로 빌드가 되어서 ubuntu(amd64)에서 배포할 때 문제 발생
  - **Solution**: 빌드 단계에서--platform 옵션으로 linux/amd64로 지정
    - docker build --platform linux/amd64 -t [이미지명:태그] .

<br>

## 11. 프로젝트 후기

### 👨🏻‍💻김형민

이번 워밍업 프로젝트가 저에게 있어서 최초의 협업 과정을 느낄 수 있는 프로젝트였습니다.
원래 혼자서만 했었기 때문에 어떤 일이건 같이 하는건 익숙하지 않았지만 운 좋게 좋은 팀원들을 만나 정말 재밌고, 그만큼 열심히 했던 프로젝트였습니다.
짧은 시간이지만 정말 길게 느껴질 정도로 팀원들과 친밀감도 생겼습니다.
체감 시간과는 별게로 프로젝트 기간 자체는 더 길었으면 좋겠다는 생각을 계속 하게 됐습니다.
프로젝트를 진행하다보니 모두 기간에 비해 많은걸 하고싶어 했고 저 또한 그랬습니다.
이렇게 앱 같은 앱을 개발한 적도 처음이고, 애써 해놓은 기획과 디자인도 아깝게 느껴졌기 때문입니다.<br>
팀원과 협업 경험이 없는 저를 잘 이끌어준 모든 팀원들에게 고맙다는 생각이 들고, 아직은 엄청 짧게 했지만 이 부트 캠프에 참여할 수 있어서 다행이라고 생각했습니다.💙

<br>

### 👩🏻‍🎨박지원

일주일간 인텐시브하게 기획, 디자인, 개발까지 진행되는 프로젝트를 경험해보며 짧은 기간 내에서 목표를 세우고, 마일스톤을 쪼개가며 협업하는 법을 배웠습니다.
모두의 생각과 관점이 다른 만큼, 합의를 이뤄내고 최선의 목표로 나아가는 과정이 의미있었습니다.
특히 디자이너로서 유저의 경험에 가장 편한 UI를 고심하고, 많은 정보를 담은 화면을 구성하는 것이 어려웠지만 프로젝트 경험이 많은 기획자의 도움으로 빠르게 해낼 수 있었습니다.
다음에 협업 기회가 있다면 스크린 해상도 세팅을 개발자와 맞추고 구현할때 효율적으로 할 수 있도록 하겠습니다.<br>
디자인이 개발되는 과정에 대해 더 공부하고 사용성과 심미성이 좋은 서비스를 만들 수 있도록 노력하겠습니다!😄
<br>

### 👩🏻‍💼송지희

짧은 기간 진행한 프로젝트지만, 아이디어 선정에 많은 시간을 들인만큼 콜팝에 대한 애정이 깊습니다.
모빌리티를 주제로 아이디어를 논의하며 모빌리티 시장의 규모와 다양성을 파악할 수 있었습니다.
낼 수 있는 아이디어의 범위가 넓었고, 모두의 욕심이 많았던만큼 선정 기준을 까다롭게 정하고자 했습니다.
1) 5일 간 MVP 구현이 가능할 것, 2) 문제를 해결할 것, 3) 문제와 대응하는 해결방안에 설득력이 있을 것. 때문에 아이디어 논의 과정이 길어지다 팀원들 모두가 매력적으로 생각했던 PBV 관련 서비스를 기획하게 되었습니다.
PBV의 다양한 활용 방안과 그에 따른 SW서비스를 구상하며 PBV의 성장성을 확인할 수 있었고, 그에 대한 이해도도 높일 수 있었습니다.
콜팝을 기획하며 체계적인 기획을 하기 어려웠다는 아쉬움은 있습니다.
해커톤처럼 짧은 기간에 MVP를 완성해야 했기 때문에 디자이너와 개발자에게 전달해야 할 산출물을 중심으로 빠르게 작업하고, 이후에 리서치를 보완하는 방식으로 진행했습니다.
때문에 가설을 설정하고 그걸 검증할 시간도 없이 기능과 화면을 기획하고, 개발이 시작되었을 때에서야 가설을 검증할 수 있었습니다.
다행히 적은 모집단이지만 가설은 기각되지 않았고, 그 후에는 PBV와 팝업카에 익숙하지 않은 청자들에게 콜팝을 소개하는 방식에 집중했던 것 같습니다.
<br>

### 👨🏻‍💻이태곤

협업 경험이 이전에도 있었지만, 디테일하게 커밋 및 코드 컨벤션을 정하고 브랜치 전략을 지키면서 개발을 진행한 것은 처음이였습니다.
처음에는 익숙하지 않아 에너지를 많이 쏟다보니 개발 속도가 느려지는 경향이 있었지만, 리팩토링 과정과 가독성에 있어 오히려 더 효율적으로 함께 코드를 작성할 수 있었습니다.
개발을 열심히 진행하는 동안, 기획자님의 계속적인 팔로우업과 디자이너님의 UI/UX 수정을 반영하면서 어느새 프로젝트 막바지에 와보니 저희 팀만의 프로세스가 갖추어져 있었습니다.
약 1주일 이라는 시간동안 이탈자 없이, 매일 얼굴보고 밥먹으면서 긍정적인 분위기 속에서 모두가 만족할 수 있는 결과물이 나온 것 같습니다!<br>
우리팀 너무 고생많았고, 고맙다!😊

<br>

### 👩🏻‍💻윤유정
이번 프로젝트를 진행하며 협업과 함께 성장의 중요성을 느낄 수 있었습니다. 안드로이드 개발이 처음이라 구현 속도도 느리고 모르는 부분도 어떤 키워드로 구글링 해야하는지조차 알기 어려울 때가 많았는데, 다른 직군이지만 안드로이드 개발과 관련해 경험이 있는 분께 많이 배웠고, 프로젝트를 수월하게 진행할 수 있었습니다.
5일 이라는 짧은 기간 이지만 기획, 디자인 직무와 또 백엔드/프론트 직무와의 협업을 진행하며 전체적인 프로세스를 경험해 볼 수 있었습니다.<br>
잘 모르는 분야이지만 서로 소통해서 합의점을 찾고 더 나은 방향으로 나아갈 수 있도록 의논하는 과정에서 커뮤니케이션의 중요성을 느낄 수 있었고, 다 함께 몰두한 결과 이러한 프로덕트를 만들어 낼 수 있었다고 생각합니다.
