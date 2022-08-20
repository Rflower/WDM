# 🍴WDM
### 🍖우리 동네 맛집 소개하기🍖
<br/><br/><br/>


![wdmmain](https://user-images.githubusercontent.com/57398610/185555405-7d03336a-eb23-4609-b08f-81ac5aa23748.JPG)



## 1. 제작기간 & 참여 인원
- 2022/07/18 ~ 2022/08/28
- 팀 프로젝트(3명)

## 2. 개발환경
🔅**공통**
- Window 10
- Eclipse IDE for Enterprise Java and Web Developers
- Oracle SQL Developer
- Git Hub

🔅**Back end**
- Spring Boot
- Spring Security
- Spring JPA
- Java 11

🔅**Front end**
- HTML, CSS3
- JavaScript, jQuery
- Boot Strap

## 3. ERD 설계<br/>
![er다이어그램](https://user-images.githubusercontent.com/57398610/185556219-f88b3fb3-563e-4b0a-b434-2f3c643bd600.JPG)<br/>


## 4. 요구사항<br/>
🔗[요구사항정의서_우동맛.xlsx](https://github.com/Rflower/WDM/files/9379629/_.xlsx)<br/>


## 5. 페이지 설명<br/>
박상욱 구현페이지🟢<br/>
김보애 구현페이지🟣<br/>
박선영 구현페이지🔴<br/>
<br/>
**main.html**🟢🟣🔴<br/>
> **사이트 메인 페이지**<br/>
> 로그인, 회원가입 및 상위 4개 맛집 조회 가능<br/>
> 새로운 맛집 등록하기 가능<br/>

**adminCheckPage.html**🟣<br/>
> **관리자 차트 페이지**<br/>
> 관리자가 원하는 데이터 차트로 구현<br/>

**adminQnAList.html**🟣<br/>
> **QnA 리스트 페이지**<br/>
> 유저가 남긴 질문 리스트 전체 조회<br/>
> 제목을 누르면 유저의 QnA 화면으로 이동<br/>

**adminWDMList.html**🟣<br/>
> **맛집 리스트 전체 조회 페이지**<br/>

**join.html**🟢<br/>
>**회원가입 페이지**<br/>
>페이지 설명 <br/>

**login.html**🟢<br/>
>**로그인 페이지**<br/>
>페이지 설명<br/>

**findMember**🟢<br/>
>**changePwdOk.html**<br/>
> 비밀번호 변경 팝업 페이지<br/>
>**findIdForm.html**<br/>
> 아이디 찾기 팝업 페이지<br/>
>**findIdResult.html**<br/>
> 아이디 찾기 결과 페이지<br/>
>**findPwdForm.html**<br/>
> 비밀번호 찾기 페이지<br/>
>**findPwdResult.html**<br/>
> 비밀번호 재설정 페이지<br/>

**myUpdateInfo.html**🟢<br/>
>** 회원정보 수정 페이지**<br/>
> 기존 가입했던 정보를 불러오고 변경하지 않을 경우 기존 이메일, 닉네임 등 정보는 그대로 유지<br/>

**myList.html**🔴<br/>
> **회원이 작성한 글 리스트 페이지**<br/>
> 회원 ID 값을 참조로 회원이 작성한 글을 불러온다.<br/>

**myWDMDetail.html**🔴<br/>
> **작성 글 상세보기 페이지**<br/>
> 회원이 작성한 글 상세보기<br/>
> 해당 페이지에서는 자신이 작성한 게시글을 수정할 수 있다.<br/>

**QnA.html**🟣<br/>
> **QnA 페이지**<br/>
> 유저 본인의 질문만 조회 가능<br/>
> 관리자는 유저의 질문에 대댓글로 답변 가능<br/>

**WDMComment.html**🟣<br/>
> **댓글 페이지**<br/>
> WDMDetail화면의 댓글 <br/>
> 댓글 리스트 페이징 처리 <br/>

**WDMDetail.html**🔴<br/>
> **맛집 상세보기 페이지**<br/>
> 게시글 추천하기를 누르면 추천수가 +1으로 바뀌며 아이콘이 변경된다.<br/>
> 카카오 지도 API를 이용해 맛집 위치 표기<br/>

**WDMInsert.html**🔴<br/>
> **맛집 등록하기 페이지**<br/>
> 내가 직접 맛집 소개하기<br/>
> 중복된 식당명 없는지 유효성 확인<br/>

**WDMList.html**🟣<br/>
> **맛집리스트 조회 페이지**<br/>
> 동네 이름 or 메뉴를 검색해야 맛집 조회 화면으로 이동<br/>
> 맛집의 종류(한식,양식,중식 등등)별로 조회 가능<br/>
> 맛집의 종류를 추천이 많은 맛집, 최근 등록된 맛집 별로 조회 가능<br/>
> 각 카테고리별 페이징 처리<br/>

**WDMupdate.html**🔴<br/>
> **맛집 수정하기 페이지**<br/>
> 회원이 올린 맛집 수정가능<br/>
> 이미지 미첨부시 기존 이미지 그대로 유지하게 구현.<br/>

**Errors**🔴<br/>
>**404.html**<br/>
> 404 Not Found Error 페이지<br/>
>**405.html**<br/>
> 405 Method Not Allowed Error 페이지<br/>
>**500.html**<br/>
> 500 Internal Server Error 페이지<br/>
>**globalError.html**<br/>
> 정의한 에러 외 모든 에러페이지<br/>
