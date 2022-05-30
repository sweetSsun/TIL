<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>회원정보</title>

	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
	<style type="text/css">
		.bg-register-image{
			background: url(${pageContext.request.contextPath }/resources/img/또치.jpg);
			background-position: center;
			background-size: cover;
		}
	</style>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
		<%@ include file="/WEB-INF/views/includes/SideBar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
				<%@ include file="/WEB-INF/views/includes/TopBar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">회원정보페이지 - MemberInfoForm.jsp</h1>
                    </div>
					
					<!--  Content Row - 회원가입양식 시작 -->
	           	<form class="user" action="modifyMember" method="post" enctype="multipart/form-data">
	                <div class="row">
	               		<div class="col-lg-5 d-none d-lg-block" style="background-color: white;">
	               		     <div class="text-center p-5">
	                                <h1 class="h4 text-gray-900 mb-4">프로필 이미지</h1>
	                         </div>
	                         <div style="text-align:center;">
	                         <c:choose>
                                <c:when test="${sessionScope.mprofile != null }">
                                	<img class="img-profile rounded-circle" style="height:300px; width: 300px; object-fit: cover;"
                                    src="${pageContext.request.contextPath }/resources/mprofileUpload/${sessionScope.mprofile}">
                                </c:when>
                                <c:otherwise>
                                	<img class="img-profile rounded-circle" style="height:300px; width: 300px; object-fit: cover;"
                                    src="${pageContext.request.contextPath }/resources/img/undraw_profile.svg">
                                </c:otherwise>
                             </c:choose>
                             <br>
	                         <input style="padding: 12px; height: 1.3cm;" type="file" class="form-control form-control-user d-none" 
	                       		  id="inputMfile" name="mfile">
	                         </div>
	              	 	</div>
	                    <div class="col-lg-7 ml-auto mr-auto" style="background-color: white;">
	                        <div class="p-5">
	                            <div class="text-center">
	                                <h1 class="h4 text-gray-900 mb-4">회원정보</h1>
	                            </div>
	                                <div class="form-group">
	                                	<label for="inputMid" class="text-md font-weight-bold">아이디</label>
	                                    <input readonly class="form-control form-control-user" id="inputMid"
	                                            name="mid" value="${member.mid }">
	                                </div>
	                                <div class="form-group">
	                                    	<label for="inputMpw" class="text-md font-weight-bold">비밀번호</label>
	                                        <input readonly class="form-control form-control-user"
	                                            id="inputMpw" name="mpw" value="${member.mpw }">
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                    	<label for="inputMname" class="text-md font-weight-bold">이름</label>
	                                        <input readonly class="form-control form-control-user" id="inputMname"
	                                            name="mname" value="${member.mname }">
	                                    </div>
	                                    <div class="col-sm-6">
	                                    	<label for="inputMbirth" class="text-md font-weight-bold">생년월일</label>
	                                        <input readonly class="form-control form-control-user" id="inputMbirth"
	                                            name="mbirth"value="${member.mbirth }">
	                                    </div>
	                                </div>
	                                <div class="form-group">
	                                	<label for="inputMemail" class="text-md font-weight-bold">이메일</label>
	                                    <input readonly class="form-control form-control-user" id="inputMemail"
	                                        name="memail" value="${member.memail }">
	                                </div>
	                               	
	                               	<label for="inputMaddr" class="text-md font-weight-bold">주소</label>
	                                 <div class="form-group row">
	                               		 <div class="col-sm-6 mb-3 mb-sm-0">
		                                    <input readonly class="form-control form-control-user"
		                                       name="mpostcode" id="inputMpostcode" value="${member.mpostcode }">
	                                    </div>
	                                    <div class="col-sm-6">
	                                    	<input type="button" class="btn btn-primary btn-user btn-block d-none"
	                                        onclick="sample6_execDaumPostcode()" id="searchPostcode" value="우편번호 찾기">
	                                    </div>
	                                </div>
	                                <div class="form-group">
	                                 	   <input readonly class="form-control form-control-user" id="inputMaddr"
	                                        name="maddr" value="${member.maddr }">
	                                </div>
	                                <div class="form-group row">
	                               		 <div class="col-sm-6 mb-3 mb-sm-0">
	                                 	   <input readonly class="form-control form-control-user" id="inputMdetailAddr"
	                                        name="mdetailAddr" value="${member.mdetailAddr }">
	                                    </div>
	                                    <div class="col-sm-6">
	                                 	   <input readonly class="form-control form-control-user" id="inputMextraAddr"
	                                        name="mextraAddr" value="${member.mextraAddr }">
	                                    </div>
	                                </div>
	                               <input type="button" class="btn btn-primary btn-user btn-block" id="modiFormButton"
	                                        value="정보수정">
	                               <input type="submit" class="btn btn-primary btn-user btn-block d-none" id="modiButton"
	                                      value="수정완료">
	                        </div>
	                    </div>
	                </div>
	                            </form>
	                
					<!--  Content Row -->

					<!--  Content Row -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

 
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>

	<!-- 다음 우편번호 서비스 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath }/resources/MemberJs/daumPostCode.js"></script>

</body>
<script type="text/javascript">
/* 	$(document).ready(function(){
		$("#modiButton").clcik(function(){
		console.log("정보수정 요청")
		$.ajax(function(){
			type : "post",
			url : "modifyMember",
			data : {"mid" : ${"#inputMid"} },
			success : function(result){
				console.log(연결 성공);
			}
		});
			
			
		});
		
	}); */
	
</script>
<script type="text/javascript">

	var checkId = false;
	var checkPw = false;
	
	$(document).ready(function(){
		console.log("준비완료");
		
		// 정보수정 폼 요청
 		$("#modiFormButton").click(function(){
 			console.log("정보수정 양식 요청");
	 		$("#inputMpw").attr("type", "text").removeAttr("readonly");
			$("#inputMname").attr("type", "text").removeAttr("readonly");
			$("#inputMbirth").attr("type", "date").removeAttr("readonly");
			$("#inputMemail").attr("type", "email").removeAttr("readonly");
			$("#inputMpostcode").attr("type", "text").removeAttr("readonly");
			$("#inputMaddr").attr("type", "text").removeAttr("readonly");
			$("#inputMdetailAddr").attr("type", "text").removeAttr("readonly");
			$("#inputMextraAddr").attr("type", "text").removeAttr("readonly");
			
			/* var button = $('input[type=button]');
	 		console.log(button.eq[0].val());
			for(int i = 0; i < button.length; i++ ) {
				button.eq[i].toggleClass("d-none");
			}  */
			$("#searchPostcode").toggleClass("d-none");
			$("#modiFormButton").toggleClass("d-none");
			$("#modiButton").toggleClass("d-none");
			$("#inputMfile").toggleClass("d-none");
		});
		
		// 아이디 중복확인
		$("#inputMid").focusout(function(){
			console.log("아이디 확인");
			var inputMid = $("#inputMid").val();
			
			if(inputMid.length == 0){
				$("#idCheckMsg").text("아이디를 입력해주세요.").css("color", "red");
				checkId = false;
			} else {
				$.ajax({
					type: "get",
					url: "memberIdCheck",
					data: {"inputMid" : inputMid},
					success: function(result){
						console.log("연결성공");
						if (result == inputMid){
							$("#idCheckMsg").text("중복된 아이디").css("color", "red");
							checkId = false;
						} else {
							$("#idCheckMsg").text("사용가능한 아이디").css("color", "green");
							checkId = true;
						}
					},
					error: function(){
						console.log("연결실패");
					}
				});			 
			}
			
		});
	
		// 비밀번호 재확인
 		$("#repeatMpw").keyup(function(){
 			console.log("비밀번호 확인");
			var inputMpw = $("#inputMpw").val();
			var repeatMpw = $("#repeatMpw").val();
			console.log("inputMpw : " + inputMpw);
			console.log("repeatMpw : " + repeatMpw);
			
			if (inputMpw == repeatMpw) {
				$("#pwCheckMsg").text("일치").css("color", "green");
				console.log("일치");
				if (inputMpw.length == 0) {
					checkPw = false;
				} else {
					checkPw = true;
				}
			} else {
				$("#pwCheckMsg").text("불일치").css("color", "red");
				console.log("불일치");
				checkPw = false;
			}
		});
 		
		
	});
	
	function joinFormCheck(){
		if (!checkId) { // 아이디 입력 확인
			$("#inputMid").focus();
			alert("아이디를 확인해주세요!")
			return false;
		}
		if (!checkPw) { // 비밀번호 입력 확인
			$("#inputMpw").focus();
			alert("비밀번호를 확인해주세요!")
			return false;
		}
		if ($("#inputMname").val().length == 0) { // 이름 입력 확인
			$("#inputMname").focus();
			alert("이름을 입력해주세요!")
			return false;
		}
	}
</script>

</html>