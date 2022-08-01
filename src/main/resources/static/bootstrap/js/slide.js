/**
 * 
 */
 
 let curPos= 0; // 현재 보고 있는 이미지의 인덱스 번호!
let position = 0; // 현재 .images 의 위치값!
const IMAGE_WIDTH = 640; // 한번 움직일 때 이동해야 할 거리!

// 요소 선택
const prevBtn = document.querySelector(".prev100")
const nextBtn = document.querySelector(".next100")
const images = document.querySelector(".images100")

function prev(){
    if(curPos > 0){
    nextBtn.removeAttribute("disabled") /* disabled 속성 제거*/
    position += IMAGE_WIDTH /* position 값 증가 */
    
    images.style.transform = `translateX(${position}px)` /* images 스타일 transform, x축 변경*/
    curPos -= 1; /* curPos 값 감소*/
    }
    if(curPos == 0){ /* 이미지 index값 0 되면 prev 못하게 */
        prevBtn.setAttribute("disabled", 'true')
    }
 }
function next(){ 
    if(curPos < 3){
        prevBtn.removeAttribute("disabled")
        position -= IMAGE_WIDTH
        /*
            트랜스폼(변형)의 네가지 속성값(함수)
            - scale() : 확대 또는 축소
            - translate() : 위치 이동
            - rotate() : 회전시키기
            - skew() : 요소 비틀기
        */
        images.style.transform = `translateX(${position}px)`
        curPos += 1;  
    }
    if(curPos == 3){
        // 뒤로 못 가게 하기
        nextBtn.setAttribute("disabled", 'true') // 못 누르는 버튼이 됨
    }
}
// 초기 랜더링 시 최초 호출 함수의 관습적 이름
function init(){
    // 앞으로 가기는 처음부터 못누르게!
    prevBtn.setAttribute("disabled", 'true')
    prevBtn.addEventListener("click", prev)
    nextBtn.addEventListener("click", next)
}

init();