<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>영화목록</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  
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
                        <h1 class="h3 mb-0 text-gray-800">영화목록 페이지 - MovieList.jsp</h1>
                    </div>
					
					<!--  Content Row -->
					<!-- 포스터, 영화제목, 개봉일 출력 -->
					<div class="row">
					<div class="col-xl-11 col-lg-7 mr-auto ml-auto">
					<div class="row">
					<c:forEach items="${mvList }" var="mv">
						<div class="col-xl-3 col-md-6 mb-4">
                            <div class="card h-100 py-2">
                            	<div class="card-header">
                            		<a href="${pageContext.request.contextPath }/movieView?mvcode=${mv.mvcode }">
                                    <img class="img-fluid" alt="${mv.mvposter }" src="${mv.mvposter }">
                                    </a>
                            	</div>
                                <div class="card-body pb-1">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="h6 mb-0 font-weight-bold text-gray-800">
                                            	<a class="text-gray-900" style="text-decoration-line:none;" href="${pageContext.request.contextPath }/movieView?mvcode=${mv.mvcode }">${mv.mvname }</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              	<div class="card-footer" style="background-color:white; border-top:none;">
                                    <div class="text-xs mb-0 text-gray-800 font-weight-bold">예매율 % | 추천수 10</div>
                                    <div class="text-xs mb-1 text-gray-800 font-weight-bold">${mv.mvopen } 개봉</div>
                                    <div style="text-align: right;">
                                    	<c:if test="${sessionScope.loginId != null}">
                              			<a class="btn btn-sm btn-danger" href="movieReservationPage?mvcode=${mv.mvcode }">예매하기</a>
                              			</c:if>
	                              	</div>
                                </div>
                            </div>
                        </div>
					</c:forEach>
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