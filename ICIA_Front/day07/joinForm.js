$(document).ready(function(){
    // 아이디 중복/규격 확인
    $("#userId").focusout(function(){
        var dbId = "ICIA";
        // var userId = document.getElementById("userId").value
        var userId = $("#userId").val();
        console.log("userId : " + userId);
        if (userId.length == 0) {
            $("#idCheckMsg").text("필수정보입니다.").css("color","red");
            formIdCheck = false;
        } else if(userId.length < 4 || userId.length > 10) {
            $("#idCheckMsg").text("4~10자리로 입력해주세요.").css("color","red");
            formIdCheck = false;
        } else if (dbId == userId) {
            // document.getElementById("idCheckMsg").innerText = "중복된 아이디입니다.";
            $("#idCheckMsg").text("중복된 아이디입니다.").css("color","red");
            formIdCheck = false;
        } else {
            $("#idCheckMsg").text("사용가능한 아이디입니다.").css("color","green");
            formIdCheck = true;
        }
    });

    // 비밀번호 규격 확인
    $("#userPw").focusout(function(){
        var userPw = $("#userPw").val();
        console.log("userPw : " + userPw);
        if (userPw.length == 0){
            $("#pwCheckMsg").text("필수정보입니다.").css("color","red");
        } else if(userPw.length < 4 || userPw.length > 8) {
            $("#pwCheckMsg").text("4~8자리로 입력해주세요.").css("color","red");
        } else {
            $("#pwCheckMsg").text("");
        }
    })

    // 비밀번호 재확인
    $("#pwConfirm").keyup(function(){
        var userPw = $("#userPw").val();
        var cfPw = $("#pwConfirm").val();
        if (userPw != cfPw) {
            $("#pwConfirmMsg").text("비밀번호가 일치하지 않습니다.").css("color","red");
            formPwCheck = false;
        } else {
            $("#pwConfirmMsg").text("일치").css("color","green");
            if(userPw.length < 4 || userPw.length > 8) {
                formPwCheck = false;
                return; // 함수를 종료시키는건데, 어차피 마지막에 있는데 왜....?
            } else {
                formPwCheck = true;
            }
        }
    })

    // input 이메일도메인
    $("#domainSelect").change(function(){
        var domainVal = $("#domainSelect").val();
        console.log("선택 도메인 : " + domainVal);
        $("#emailDomain").val(domainVal);
    })
    
});