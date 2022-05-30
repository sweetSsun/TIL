<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

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
                        <h1 class="h3 mb-0 text-gray-800">로그인페이지 - MemberLoginForm.jsp</h1>
                    </div>
					
					<!--  Content Row - 회원가입양식 시작 -->
	                <div class="row">
	                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
	                    <div class="col-lg-7 ml-auto mr-auto" style="background-color: white;">
	                        <div class="p-5">
	                            <div class="text-center">
	                                <h1 class="h4 text-gray-900 mb-4">로그인</h1>
	                            </div>
	                            <form class="user" action="memberLogin" method="post" onsubmit="return LoginFormCheck()">
	                                <div class="form-group">
	                                    <input type="text" class="form-control form-control-user" id="inputMid"
	                                            name="mid" placeholder="아이디">
	                                    <span style="font-size: 10px; margin-left: auto;" id="idCheckMsg"></span>
	                                </div>
	                                <div class="form-group">
	                                    <!-- margin :: m (b,t,l,r) / padding :: p (b,t,l,r) -->
	                                    <input type="password" class="form-control form-control-user"
	                                           id="inputMpw" name="mpw" placeholder="비밀번호">
	                                </div>
	                                <button type="submit" class="btn btn-primary btn-user btn-block">
	                                    로그인
	                                </button>
	                            </form>
	                            <hr>
	                            <div class="text-center">
	                                <a class="small" href="forgot-password.html">Forgot Password?</a>
	                            </div>
	                            <div class="text-center">
	                                <a class="small" href="login.html">Already have an account? Login!</a>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                
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
    
    <script type="text/javascript">
    	var checkMsg = "${msg}"
    	console.log(checkMsg.length);
    	if(checkMsg.length > 0){
    		alert(checkMsg);
    	}
    </script>

</body>

<script type="text/javascript">

	function LoginFormCheck(){
		if ($("#inputMid").val().length == 0) { // 아이디 입력 확인
			$("#inputMid").focus();
			alert("아이디를 확인해주세요!")
			return false;
		}
		if ($("#inputMpw").val().length == 0) { // 비밀번호 입력 확인
			$("#inputMpw").focus();
			alert("비밀번호를 확인해주세요!")
			return false;
		}
	}
</script>

</html>