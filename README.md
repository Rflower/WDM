# 🍴WDM
🍖우리 동네 맛집 소개하기🍖



![wdmmain](https://user-images.githubusercontent.com/57398610/185555405-7d03336a-eb23-4609-b08f-81ac5aa23748.JPG)



## 1. 제작기간 & 참여 인원
- 2022/07/18 ~ 2022/08/28
- 팀 프로젝트(3명)

## 2. 개발환경
**공통**
- Window 10
- Eclipse IDE for Enterprise Java and Web Developers
- Oracle SQL Developer
- Git Hub

**Back end**
- Spring Boot
- Spring Security
- Spring JPA
- Java 11

**Front end**
- HTML, CSS3
- JavaScript, jQuery
- Boot Strap

## 3. ERD 설계

![er다이어그램](https://user-images.githubusercontent.com/57398610/185556219-f88b3fb3-563e-4b0a-b434-2f3c643bd600.JPG)


## 4. 요구사항
🔗[요구사항정의서_우동맛.xlsx](https://github.com/Rflower/WDM/files/9379629/_.xlsx)


## 5. 페이지 설명
박상욱 구현페이지🟢<br/>
김보애 구현페이지🟣<br/>
박선영 구현페이지🔴<br/>

**main.html**🟢🟣🔴<br/>
> 사이트 메인 페이지<br/>
> 로그인, 회원가입 및 상위 4개 맛집 조회 가능<br/>
> 새로운 맛집 등록하기 가능<br/>

**adminCheckPage.html**🟣<br/>
> 관리자가 원하는 데이터 차트로 구현<br/>

**adminQnAList.html**🟣<br/>
> 유저가 남긴 질문 리스트 전체 조회<br/>
> 제목을 누르면 유저의 QnA 화면으로 이동<br/>

**adminWDMList.html**🟣<br/>
> 유저가 등록한 맛집 리스트 전체 조회<br/>

**adminDtail.html**🔴<br/>
>페이지 설명<br/>

**join.html**🟢<br/>
>페이지 설명<br/>

**login.html**🟢<br/>
>페이지 설명<br/>

**myList.html**🔴<br/>
> 회원이 작성한 글 리스트 조회<br/>

**myUpdateInfo.html**🟢<br/>
>페이지 설명<br/>

**myWDMDetail.html**🔴<br/>
> 회원이 작성한 글 상세보기<br/>
> 수정하기 기능 이동 가능 페이지<br/>

**QnA.html**🟣<br/>
> 유저 본인의 질문만 조회 가능<br/>
> 관리자는 유저의 질문에 대댓글로 답변 가능<br/>

**WDMComment.html**🟣<br/>
>페이지 설명<br/>

**WDMDetail.html**🔴<br/>
> 맛집 상세보기 기능<br/>
> 추천하기 기능 및 지도API<br/>

**WDMInsert.html**🔴
> 내가 직접 맛집 소개하기
> 중복된 식당명 없는지 유효성 확인

**WDMList.html**🟣
> 페이지 설명

**WDMupdate.html**🔴
> 회원이 올린 맛집 수정하기 페이지

**Errors**🔴
>**404.html**<br/>
> 404 Not Found Error 페이지<br/>
>**405.html**<br/>
> 405 Method Not Allowed Error 페이지<br/>
>**500.html**<br/>
> 500 Internal Server Error 페이지<br/>
>**globalError.html**🔴
> 정의한 에러 외 모든 에러페이지
