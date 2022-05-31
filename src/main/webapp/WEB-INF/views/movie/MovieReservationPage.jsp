<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>영화예매</title>

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
                        <h1 class="h3 mb-0 text-gray-800">영화예매 페이지 - MovieReservationpage.jsp</h1>
                    </div>
					<!--  Content Row -->
					<!-- 영화, 극장, 날짜및시간, 상영관 선택 -->
					<div class="row text-gray-100">
						<div class="col-3 pr-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">영화</h6>
                                </div>
                                <div class="card-body listArea pl-1" id="mvList">
                                   	<div class="pl-1 text-gray-900 text-md">
        	                            <c:forEach items="${reMvList }" var="reMv">
                                    		<div class="btn" onclick="mvSelect(this, '${reMv.mvcode}', '${reMv.mvposter }')"
                                    		style="text-align:left; display:block;">${reMv.mvname }</div>
            	                        </c:forEach>
                                   	</div>
                                </div>
                            </div>
						</div>
						<div class="col-4 pr-0 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">극장</h6>
                                </div>
                                <div class="card-body listArea pl-1" id="mvList">
                                   	<div class="pl-1 text-gray-900 text-md">
        	                            
                                   	</div>
                                </div>
                            </div>
						</div>
						<div class="col-2 pr-0 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">날짜</h6>
                                </div>
                                <div class="card-body listArea pl-1" id="mvList">
                                   	<div class="pl-1 text-gray-900 text-md">
        	                            
                                   	</div>
                                </div>
                            </div>
						</div>						
						<div class="col-3 pl-0">
							<div class="card shadow mb-4">
                                <div class="card-header py-3 bg-gray-900">
                                    <h6 class="m-0 font-weight-bold text-white">시간 및 상영관</h6>
                                </div>
                                <div class="card-body listArea pl-1" id="mvList">
                                   	<div class="pl-1 text-gray-900 text-md">
        	                            
                                   	</div>
                                </div>
                            </div>
						</div>
					 
					</div>
					
					<!--  Content Row -->
					<!-- 선택 항목 확인 -->
					<div class="row mt-5 text-gray-100">
						<div class="col-3 bg-warning">
							선택 영화 정보
							<p>포스터</p>
							<p>영화제목</p>
						</div>  
						<div class="col-3 bg-primary">
							선택 극장 및 상영관 정보
						</div>  
						<div class="col-3 bg-success">
							인원수 입력
						</div>  
						<div class="col-3 bg-info">
							예매하기 버튼
						</div>  
					</div>
					  

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
    	
    	function mvSelect(selObj, selMvcode, selMvposter)	{
    		$("#mvList div").css("background-color","").css("color","");
    		$(selObj).css("background-color","#5a5c69").css("color","white");
    		
    		console.log("선택 영화 코드 : " + selMvcode)
    		console.log("선택 영화 제목 : " + $(selObj).text())
    		console.log("선택 영화 포스터 : " + selMvposter)
    		
    		$.ajax(function(){
    			type: "get",
    			url: "movieReserveTheater",
    			data: {"selMvcode":selMvcode},
    			dataType: "json",
    			success: function(result){
					    				
    				
    				
    			}		
    		});
    	}
    	
    </script>

</body>

</html>