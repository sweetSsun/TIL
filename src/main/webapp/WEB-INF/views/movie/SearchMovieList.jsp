<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="https://kit.fontawesome.com/9125416ae4.js" crossorigin="anonymous"></script>

    <title>영화검색목록</title>

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
                        <h1 class="h3 mb-0 text-gray-800">검색결과 페이지 - SearchMovieList.jsp</h1>
                    </div>
					
					<!--  Content Row -->
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 bg-gray-900 mb-4">
                            <h6 class="m-0 font-weight-bold text-white">예매 가능 영화</h6>
                        </div>
					<div class="row">
					<div class="col-xl-11 col-lg-7 mr-auto ml-auto">
					<div class="row">
					<c:forEach items="${searchScMvList }" var="scMv">
						<div class="col-xl-3 col-md-6 mb-4">
                            <div class="card h-100 py-2">
                            	<div class="card-header">
                            		<a href="${pageContext.request.contextPath }/movieView?mvcode=${scMv.mvcode }">
                                    <img class="img-fluid" alt="${scMv.mvposter }" src="${scMv.mvposter }">
                                    </a>
                            	</div>
                                <div class="card-body pb-1">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="h6 mb-0 font-weight-bold text-gray-800">
                                            	<a class="text-gray-900" style="text-decoration-line:none;" href="${pageContext.request.contextPath }/movieView?mvcode=${scMv.mvcode }">${scMv.mvname }</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              	<div class="card-footer" style="background-color:white; border-top:none;">
                                    <div class="text-xs mb-0 text-gray-800 font-weight-bold">
                                    	예매율 ${scMv.rerate } %
                                    </div>
                                    <div class="text-xs mb-1 text-gray-800 font-weight-bold">${scMv.mvopen } 개봉</div>
                                    <div style="text-align: right;">
                              			<a class="btn btn-sm btn-primary" href="movieView?mvcode=${scMv.mvcode }">상세보기</a>
                              			<a class="btn btn-sm btn-danger" href="movieReservationPage?mvcode=${scMv.mvcode }">예매하기</a>
	                              	</div>
                                </div>
                            </div>
                        </div>
					</c:forEach>
					</div>
					</div>
					</div>
					</div>

					<!--  Content Row -->
 					<div class="card shadow mb-4">
                        <div class="card-header py-3 bg-gray-900 mb-4">
                            <h6 class="m-0 font-weight-bold text-white">영화 검색 결과</h6>
                        </div>
					<div class="row">
					<div class="col-xl-11 col-lg-7 mr-auto ml-auto">
					<div class="row">
					<c:forEach items="${searchAllMvList }" var="allMv">
						<div class="col-xl-3 col-md-6 mb-4">
                            <div class="card h-100 py-2">
                            	<div class="card-header">
                            		<a href="${pageContext.request.contextPath }/movieView?mvcode=${allMv.mvcode }">
                                    <img class="img-fluid" alt="${allMv.mvposter }" src="${allMv.mvposter }">
                                    </a>
                            	</div>
                                <div class="card-body pb-1">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="h6 mb-0 font-weight-bold text-gray-800">
                                            	<a class="text-gray-900" style="text-decoration-line:none;" href="${pageContext.request.contextPath }/movieView?mvcode=${allMv.mvcode }">${allMv.mvname }</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              	<div class="card-footer" style="background-color:white; border-top:none;">
                                    <div class="text-xs mb-1 text-gray-800 font-weight-bold">${allMv.mvopen } 개봉</div>
                                    <div style="text-align: right;">
	                              	</div>
                                </div>
                            </div>
                        </div>
					</c:forEach>
					</div>
					</div>
					</div>
					</div>
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