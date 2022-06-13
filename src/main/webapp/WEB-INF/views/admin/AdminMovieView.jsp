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

    <title>관리자 - 영화정보수정</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  	
  	    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.min.css" rel="stylesheet">
  	<!-- Custom styles for this page -->
    <link href="${pageContext.request.contextPath }/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
    <style>
	    .active {
	    	color: #fff;
		    background-color: #4e73df;
	    	border-color: #4e73df;
	    }
	    input {
	    	border: none;
	    	size: auto;
	    }
	    input[type=text]{
	    	border: solid 2px #cfcece; border-radius: 5px;
	    }
	    .inputDiv input{
	    	width : 100%;
	    }
    </style>
    
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
		<%@ include file="/WEB-INF/views/includes/AdminSideBar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
				<%@ include file="/WEB-INF/views/includes/AdminTopBar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">영화 정보수정 페이지 - AdminMovieModi.jsp</h1>
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
						<form method="post" action="adminMovieModi">
                                <!-- Card Header - Dropdown -->
                                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 text-gray-800 font-weight-bold">
                                    	<input type="hidden" name="mvcode" value="${movieInfo.mvcode }">${movieInfo.mvcode }
                                    	<input type="hidden" name="mvname" value="${movieInfo.mvname }">${movieInfo.mvname }
                                    </h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body text-gray-800 text-sm" id="modiInfo">
                                	<div class="inputDiv">
	                                    감독 <input readonly name="mvpd" value="${movieInfo.mvpd }">
                                	</div>
	                                    <br>
                                	<div class="inputDiv">
	                                    배우 <input readonly name="mvactor" value="${movieInfo.mvactor }">
                                	</div>
	                                    <br>
	                                <div class="row">
	                                	<div class="col-6 inputDiv">
		                                    장르 <input readonly name="mvgenre" value="${movieInfo.mvgenre }">
	                                	</div>
	                                	<div class="col-6 inputDiv">
		                                    개봉일 <input readonly name="mvopen" value="${movieInfo.mvopen }">
	                                	</div>
                                	</div>
	                                    <br>
	                                <div class="row">
	                                	<div class="col-6 inputDiv">
		                                    관람등급 <input readonly name="mvage" value="${movieInfo.mvage }">
	                                	</div>
	                                	<div class="col-6 inputDiv">
		                                    상영시간 <input readonly name="mvtime" value="${movieInfo.mvtime }">
		                                </div>
                                	</div>
	                                    <br>
                                	<div>
                                		예매율 : ${movieInfo.rerate }% |
                                		<i class='fa-regular fa-thumbs-up text-primary'></i> ${movieInfo.recommend1 }
                                		<i class='fa-regular fa-thumbs-down text-danger'></i> ${movieInfo.recommend0 }
                                	</div>
	                                    <br>
                                	<div class="mt-1" style="text-align: right;" id="modiBtn">
	                                	<button type="button" class="btn btn-sm btn-danger" onclick="modiOpen()">정보수정</button>
	                                	<button type="button" class="btn btn-sm btn-secondary d-none" onclick="modiClose()">취소</button> 
	                                	<button type="submit" class="btn btn-sm btn-danger d-none">수정하기</button> 
	                                	<a class="btn btn-sm btn-primary" href="adminMovieList">영화목록</a> 
                                	</div>
                                </div>
						</form>
                            </div>
                        </div>
                        
                        
                    </div>
                </div>
	    	</div>
            <!-- End of Main Content -->
	    </div>
        </div>
					

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
    
     <!-- Page level plugins -->
    <script src="${pageContext.request.contextPath }/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
    <!-- Page level custom scripts -->
    <script src="${pageContext.request.contextPath }/resources/js/demo/datatables-demo.js"></script>
    
    <script type="text/javascript">
		var modiInput = $(".inputDiv").children("input");

/* 		$(document).ready(function(){
    		for(var i = 0; i <  modiInput.length; i++){
    			var inputSize = modiInput.eq(i).val().length;
    			console.log("input태그 글자길이 : " + inputSize);
    			modiInput.eq(i).attr("size", inputSize);
    		}
    	}); */
    
    	function modiOpen(){
    		var mvcode = "${movieInfo.mvcode}";
    		console.log("정보수정할 영화코드 : " + mvcode);
			console.log(modiInput.length);
			for(var i = 0; i < modiInput.length; i++){
				modiInput.eq(i).removeAttr("readonly").attr("type", "text");
			}
			$("#modiBtn").children("button").toggleClass("d-none");
    	}
    	
    	function modiClose(){
			for(var i = 0; i < modiInput.length; i++){
				modiInput.eq(i).removeAttr("type").attr("readonly", "readonly");
			}
			$("#modiBtn").children("button").toggleClass("d-none");
    		
    	}
    </script>
    
    <script type="text/javascript">
    	var checkMsg = "${msg}"
    	console.log(checkMsg.length);
    	if(checkMsg.length > 0){
    		alert(checkMsg);
    	}
    	
    </script>

</body>
</html>