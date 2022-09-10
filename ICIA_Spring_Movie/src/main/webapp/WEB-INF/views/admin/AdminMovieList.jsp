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
	                                            <td class="align-middle"><a href="${pageContext.request.contextPath }/adminMovieView?mvcode=${mv.mvcode }" class="btn p-0" style="display:inline;">${mv.mvname }</a></td>
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
                                    	<div class="row">
	                                  		<div class="col-6">
			                                  	<label class="small">영화코드</label>
			                                  	<input class="form-control" id="mvModi_mvcode" name="thcode" type="text" readonly="readonly">
	                                  		</div>
	                                  		<div class="col-6">
			                                  	<label class="small">제목</label>
			                                  	<input class="form-control" id="mvModi_mvname" name="thcode" type="text" readonly="readonly">
	                                  		</div>
                                    	</div>
	                                  	<div>                                	
		                                  	<label class="small">감독</label>
		                                  	<input class="form-control" id="mvModi_mvpd" name="thcode" type="text" readonly="readonly">
	                                  	</div>
	                                  	<div>                                	
		                                  	<label class="small">배우</label>
		                                  	<input class="form-control" id="mvModi_mvactor" name="thcode" type="text" readonly="readonly">
	                                  	</div>
	                                  	<div class="row">
	                                  		<div class="col-6">
			                                  	<label class="small">장르</label>
			                                  	<input class="form-control" id="mvModi_mvgenre" name="thcode" type="text" readonly="readonly">
	                                  		</div>
	                                  		<div class="col-6">
			                                  	<label class="small">개봉일</label>
			                                  	<input class="form-control" id="mvModi_mvopen" name="thcode" type="text" readonly="readonly">
	                                  		</div>
                                    	</div>
	                                  	<div class="row">
	                                  		<div class="col-6">
			                                  	<label class="small">관람등급</label>
			                                  	<input class="form-control" id="mvModi_mvage" name="thcode" type="text" readonly="readonly">
	                                  		</div>
	                                  		<div class="col-6">
			                                  	<label class="small">시간</label>
			                                  	<input class="form-control" id="mvModi_mvtime" name="thcode" type="text" readonly="readonly">
	                                  		</div>
                                    	</div>
	                                </div>
                                </div>
                            </div>
                        </div>
	                </div>
	                <div class="modal-footer">
                       	<button type="button" class="toggleBtn btn btn-sm btn-danger" onclick="modiOpen()">정보수정</button>
                        <button type="button" class="toggleBtn btn btn-sm btn-secondary d-none" onclick="modiClose(true)">취소</button> 
                        <button type="button" class="toggleBtn btn btn-sm btn-danger d-none" onclick="movieModiModal()">수정하기</button> 
	                </div>
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
	
		var mvInfoVal = "";
	
		function movieView(mvInfo){
			console.log("movieView() 실행");
			var row_mv = mvInfo.split("(")[1].split(")")[0].split(", mv");
			console.log(row_mv);

			var movieData = {};
			for(var i = 0; i < row_mv.length; i++){
				var key = row_mv[i].split('=')[0];
				var val = row_mv[i].split('=')[1];
				movieData[key] = val;
			}
			// 기존 데이터를 전역변수에 저장 (수정 시도하다 취소할 경우, 기존 데이터값으로 되돌리기 위함)
			mvInfoVal = movieData;
			console.log(mvInfoVal);

			$("#mvModi_mvposter").attr("src", movieData.poster);
			$("#mvModi_mvcode").val(movieData.mvcode);
			$("#mvModi_mvname").val(movieData.name);
			$("#mvModi_mvpd").val(movieData.pd);
			$("#mvModi_mvactor").val(movieData.actor);
			$("#mvModi_mvgenre").val(movieData.genre);
			$("#mvModi_mvage").val(movieData.age);
			$("#mvModi_mvtime").val(movieData.time);
			$("#mvModi_mvopen").val(movieData.open);
			
			$("#mvModiModal").modal('show');
		}
	</script>	
	
    <script type="text/javascript">
		// 기존 데이터를 저장할 전역변수 (수정 시도하다 취소할 경우, 기존 데이터값으로 되돌리기 위함)

    
    	function movieModiModal(){
    		console.log("모달_영화정보 수정 요청");
    		
    		var mvcode = $("#mvModi_mvcode").val();
    		var mvpd = $("#mvModi_mvpd").val();
    		var mvactor = $("#mvModi_mvactor").val();
    		var mvgenre = $("#mvModi_mvgenre").val();
    		var mvage = $("#mvModi_mvage").val();
    		var mvtime = $("#mvModi_mvtime").val();
    		var mvopen = $("#mvModi_mvopen").val();
    		
    		$.ajax({
    			type:"post",
    			data:{"mvcode":mvcode, "mvpd":mvpd, "mvactor":mvactor, "mvgenre":mvgenre, "mvage":mvage, "mvtime":mvtime, "mvopen":mvopen},
    			url:"adminMovieModiModal",
    			success: function(result){
    				console.log(result);
    				mvInfoVal.mvpd = mvpd;
    				mvInfoVal.mvactor = mvactor;
    				mvInfoVal.mvgenre = mvgenre;
    				mvInfoVal.mvage = mvage;
    				mvInfoVal.mvtime = mvtime;
    				mvInfoVal.mvopen = mvopen;
    				modiClose(false);
    				alert("정보가 수정되었습니다.");
    			}
    		});
    	}
    
    
    	function modiOpen(){
    		$("#mvModi_mvpd").removeAttr("readonly");
			$("#mvModi_mvactor").removeAttr("readonly");
			$("#mvModi_mvgenre").removeAttr("readonly");
			$("#mvModi_mvage").removeAttr("readonly");
			$("#mvModi_mvtime").removeAttr("readonly");
			$("#mvModi_mvopen").removeAttr("readonly");
			$(".toggleBtn").toggleClass("d-none");
    	}
    	
    	function modiClose(bool){
    		$("#mvModi_mvpd").attr("readonly","readonly");
			$("#mvModi_mvactor").attr("readonly","readonly");
			$("#mvModi_mvgenre").attr("readonly","readonly");
			$("#mvModi_mvage").attr("readonly","readonly");
			$("#mvModi_mvtime").attr("readonly","readonly");
			$("#mvModi_mvopen").attr("readonly","readonly");
			$(".toggleBtn").toggleClass("d-none");
			
			if(bool){
				previousMvInfo();
			}
    	}
    	
    	function previousMvInfo(){
    		$("#mvModi_mvpd").val(mvInfoVal.pd);
			$("#mvModi_mvactor").val(mvInfoVal.actor);
			$("#mvModi_mvgenre").val(mvInfoVal.genre);
			$("#mvModi_mvage").val(mvInfoVal.age);
			$("#mvModi_mvtime").val(mvInfoVal.time);
			$("#mvModi_mvopen").val(mvInfoVal.open);
    	}
    </script>
</body>

</html>