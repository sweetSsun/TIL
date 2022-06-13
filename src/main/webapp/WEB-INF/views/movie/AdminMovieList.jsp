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

    <title>관리자-영화목록</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  	
  	<!-- Custom styles for this page -->
    <link href="${pageContext.request.contextPath }/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  
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

				<div class="container-fluid">
				     <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">관리자 영화목록 페이지 - AdminMovieList.jsp</h1>
                    </div>
                    
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 bg-gray-900">
                            <h6 class="m-0 font-weight-bold text-white">영화목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class="bg-gray-700 text-white">
                                        	<th style="width:65px;">영화코드</th>
                                            <th>제목</th>
                                            <th>장르</th>
                                            <th style="width:65px;">관람등급</th>
                                            <th>개봉일</th>
                                            <th style="width:50px;"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${mvList }" var="mv">
	                                        <tr>
	                                            <td class="align-middle">${mv.mvcode }</td>
	                                            <td class="align-middle"><a href="${pageContext.request.contextPath }/adminMovieView?mvcode=${mv.mvcode }" class="btn p-0">${mv.mvname }</a></td>
	                                            <td class="align-middle">${mv.mvgenre }</td>
	                                            <td class="align-middle">${mv.mvage }</td>
	                                            <td class="align-middle">${mv.mvopen }</td>
	                                            <th class="align-middle" id="mvstateBtn" style="text-align:center;">
	                                            	<button class="btn btn-info btn-icon-split px-1" onclick="movieView('${mv }')">상세정보</button>
		                                            	<c:choose>
	                                            		<c:when test="${mv.mvstate == 0 }">
			                                            	<button class="btn btn-danger btn-icon-split px-1" onclick="changeMvstate(this, '${mv.mvcode }')">비활성화</button>
	                                            		</c:when>
	                                            		<c:otherwise>
			                                            	<button class="btn btn-primary btn-icon-split px-1" onclick="changeMvstate(this, '${mv.mvcode }')">활성화</button>
	                                            		</c:otherwise>
	                                            	</c:choose>
	                                            </th>
	                                        </tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
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


<!-- 영화정보수정 모달~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
   <div class="modal fade" id="mvModiModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title font-weight-bold " id="mvModi_modalLabel"></h6>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <form action="adminMovieModiModal" method="post">
	                <div class="modal-body ">
	                	<div class="row">
	                		<div class="col-5">
                                <div class="no-gutters align-items-center">
                                    <div class="h6 mb-1 font-weight-bold text-gray-800" >
                                 		<img class="img-fluid" alt="영화포스터" style="max-height:300px;" id="mvModi_mvposter" src="">
                                    </div>
                                </div>
                            </div>
                           	<div class="col-7">
                                <div class="no-gutters align-items-center">
                                    <div class="h6 font-weight-bold text-gray-800">
	                                  <div id="mvModi_mvcode"></div>
	                                  <br>
	                                  <div id="mvModi_mvname"></div>
	                                  <br>
	                                  <div id="mvModi_mvactor"></div>
	                                  <br>
	                                  <div class="row">
		                                  <div class="col-6" id="mvModi_mvgenre"></div>
		                                  <div class="col-6" id="mvModi_mvopen"></div>
	                                  </div>
	                                  <br>
	                                  <div class="row">
		                                  <div class="col-6" id="mvModi_mvage"></div>
		                                  <div class="col-6" id="mvModi_mvtime"></div>
	                                  </div>
	                                </div>
                                </div>
                            </div>
                        </div>
	                </div>
	                <div class="modal-footer">
	                	<input type="button" class="btn btn-primary" id="modiPageBtn" value="관람평 수정" onclick="modifyReview()">
	                	<input type="submit" class="btn btn-primary d-none"  id="modiBtn" value="수정완료">
	                </div>
                    <div class="mt-1" style="text-align: right;" id="modiBtn">
                       	<button type="button" class="btn btn-sm btn-danger" onclick="modiOpen()">정보수정</button>
                        <button type="button" class="btn btn-sm btn-secondary d-none" onclick="modiClose()">취소</button> 
                        <button type="submit" class="btn btn-sm btn-danger d-none">수정하기</button> 
                    </div>
                </form>
            </div>
        </div>
    </div>


 
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
    	var checkMsg = "${msg}"
    	console.log(checkMsg.length);
    	if(checkMsg.length > 0){
    		alert(checkMsg);
    	}
    </script>

	<script type="text/javascript">
		function changeMvstate(btnObj, mvcode){
			var btnText = $(btnObj).text();
			if (btnText == "비활성화") {
				var mvstate = 1;
			} else {
				var mvstate = 0;
			}
			console.log("변경할 mvcode : " + mvcode);
			console.log("변경할 mvstate : " + mvstate);
			$.ajax({
				type:"post",
				data:{"mvcode":mvcode, "mvstate":mvstate},
				url: "${pageContext.request.contextPath }/changeMvstate",
				success: function(result){
					if (result == 1) {
						$(btnObj).removeClass("btn-danger").addClass("btn-primary").text("활성화");
					} else {
						$(btnObj).removeClass("btn-primary").addClass("btn-danger").text("비활성화");
					}
				}
			});
		}
	</script>
	
	<script type="text/javascript">
		function movieView(mvInfo){
			$("#mvInfoModal").modal('show');
		}
	</script>	
	
    <script type="text/javascript">
		var modiInput = $(".inputDiv").children("input");
    
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
</body>

</html>