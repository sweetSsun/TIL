<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.Date" %>
    
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>예매정보</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  
</head>

<script type="text/javascript">
	var loginCheck = "${sessionScope.loginId}";
	if(loginCheck.length == 0){
		alert("로그인 후 이용 가능합니다.");
		location.href="memberLoginForm";
	}
</script>

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
                        <h1 class="h3 mb-0 text-gray-800">예매정보 페이지 - ReservationInfo.jsp</h1>
                    </div>
					
					<!--  Content Row -->
					<div class="col-xl-9 mr-auto ml-auto">
                        <div class="card h-100" style="max-width: 800px;">
                        	<div class="card-header font-weight-bold bg-gray-700 text-white">
                                예매코드 ${redto.recode }
                        	</div>
                            <div class="card-body pb-1">
                            	<div class="row">
	                            	<div class="col-6">
		                                <div class="row no-gutters align-items-center">
		                                    <div class="h6 mb-3 font-weight-bold text-gray-800" >
		                                 		 <img class="img-fluid" alt="영화포스터" style="max-height:500px;" src="${redto.mvposter }">
		                                    </div>
		                                </div>
		                            </div>
	                            	<div class="col-6">
		                                <div class="row no-gutters align-items-center">
		                                    <div class="h6 my-3 font-weight-bold text-gray-800">
				                                  ${redto.mvname }
				                                  <br><br>
				                                  ${redto.thname }&nbsp; ${redto.rescroom }
				                                  <br><br>
				                                  ${redto.rescdate }
				                                  <br><br>
				                                  ${redto.reamount } 명
		                                    </div>
		                                </div>
		                            </div>
	                            </div>
                            	<div class="row mb-2" >
                           			<button class="btn btn-secondary btn-icon-split px-1 mx-1 " onclick="location.href='reservationList'">예매목록</button>
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

</html>