// start.js

// head태그 내부, body태그 내부, head와 body 사이 등 위치는 상관 X 
// >> 보통 body 밑에 쓰는게 일반적(내용 구현해놓고 기능 주기)
function clickTest() {
    alert("자바스크립트!")
    document.getElementById("p1").innerText = "변경";
    // Id가 "p1"인 요소를 "변경"이라는 Text로 변경
}