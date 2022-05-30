<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${movieInfo.mvname } 상세정보</title>

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
                        <h1 class="h3 mb-0 text-gray-800">영화 상세정보 페이지 - MovieView.jsp</h1>
                    </div>
					
					<!--  Content Row -->
					<div class="row">
                        <div class="col-lg-6">
                            <!-- Default Card Example -->
                            <div class="card mb-4">
                                <div class="card-body">
                                 	 <img class="img-fluid" alt="${movieInfo.mvname }" src="${movieInfo.mvposter }">
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <!-- Dropdown Card Example -->
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 text-gray-800 font-weight-bold">${movieInfo.mvname }</h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body text-gray-800 text-sm">
                                	<div>
	                                    감독 : ${movieInfo.mvpd }
                                	</div>
                                	<div>
	                                    배우 : ${movieInfo.mvactor }
                                	</div>
                                	<div>
	                                    장르 : ${movieInfo.mvgenre } / 기본 : ${movieInfo.mvage }, ${movieInfo.mvtime }
                                	</div>
                                	<div>
	                                    개봉일 : ${movieInfo.mvopen }
                                	</div>
                                	<div>예매율 :  % / 추천수 : 10</div>
                                	<div class="mt-1" style="text-align: right;">
	                                	<a class="btn btn-sm btn-danger" href="#">예매하기</a>
	                                	<a class="btn btn-sm btn-primary" href="#">추천하기</a>
                                	</div>
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