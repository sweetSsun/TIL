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

    <title>관리자-회원목록</title>

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
                        <h1 class="h3 mb-0 text-gray-800">관리자 회원목록 페이지 - AdminMemberList.jsp</h1>
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
                                        	<th>아이디</th>
                                            <th>닉네임</th>
                                            <th>생일</th>
                                            <th>이메일</th>
                                            <th>주소</th>
                                            <th style="min-width:65px;"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${memberList }" var="member">
	                                        <tr>
	                                            <td class="align-middle">${member.mid }</td>
	                                            <td class="align-middle">${member.mname }</td>
	                                            <td class="align-middle">${member.mbirth }</td>
	                                            <td class="align-middle">${member.memail }</td>
	                                            <td class="align-middle">${member.maddress }</td>
	                                            <th class="align-middle" id="mvstateBtn" style="text-align:center;">
		                                            	<c:choose>
	                                            		<c:when test="${member.mstate == 0 }">
			                                            	<button class="btn btn-primary btn-icon-split px-1" onclick="modalOpen (this, '${member.mid }')">일반회원</button>
	                                            		</c:when>
	                                            		<c:when test="${member.mstate == 1 }">
			                                            	<button class="btn btn-secondary btn-icon-split px-1" onclick="modalOpen(this, '${member.mid }')">탈퇴회원</button>
	                                            		</c:when>
	                                            		<c:when test="${member.mstate == 2 }">
			                                            	<button class="btn btn-warning btn-icon-split px-1" onclick="modalOpen(this, '${member.mid }')">카톡회원</button>
	                                            		</c:when>
	                                            		<c:otherwise>
			                                            	<button class="btn btn-danger btn-icon-split px-1" onclick="modalOpen(this, '${member.mid }')">정지회원</button>
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


 	<div class="modal fade" id="changeMstateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLabel"> </h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body" id="modalContext">'확인'을 선택하면 해당 회원의 계정이 정지됩니다.</div>
                <div class="modal-footer">
                	<input type="hidden" id="mid">
                	<input type="hidden" id="mstate">
                	<div id="aTagDiv">
	                    <button class="btn btn-danger" onclick="changeMstate()">확인</button>
                	</div>
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
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
		var selBtnObj = "";
	
		function modalOpen(btnObj, mid){
	    	$("#mid").val(mid);
	    	$("#aTagDiv").html("<button class='btn btn-danger' onclick='changeMstate()'>확인</button>");
	    	
			if ($(btnObj).text() == "일반회원" || $(btnObj).text() == "카톡회원"){
	    		$("#mstate").val(3);
	    		$("#modalLabel").text(mid + "님을 정지시키겠습니까?");
		    	$("#modalContext").text("'확인'을 선택하면 해당 회원의 계정이 정지됩니다.");
			} else  if ($(btnObj).text() == "정지회원") {
				if (isNaN(Number(mid))){
		    		$("#mstate").val(0);
				} else {
		    		$("#mstate").val(2);
				}
	    		$("#modalLabel").text(mid + "님을 활성화 시키겠습니까?");
		    	$("#modalContext").text("'확인'을 선택하면 해당 회원의 계정이 활성화됩니다.");

			} else {
	    		$("#modalLabel").text(mid + "님");
	    		$("#modalContext").text("이미 탈퇴한 회원입니다.");
	    		$("#aTagDiv").text("");
			}
			selBtnObj = btnObj;
			$("#changeMstateModal").modal('show');
		}
		
		
		function changeMstate(){
			var modiMid = $("#mid").val();
			var modiMstate = $("#mstate").val();

			console.log("변경할 mid : " + modiMid);
			console.log("변경할 mstate : " + modiMstate);
			
			// id를 문자로 변경했다가 숫자로 변경이 가능하면 카톡(2)회원, 변경이 불가능하면 일반(0)회원
			var userId = Number(modiMid);
			console.log("userId : " + userId);
			
			$.ajax({
				type:"post",
				data:{"mid":modiMid, "mstate":modiMstate},
				url: "adminMemberUpdate",
				success: function(result){
					console.log("success");
					if (modiMstate == 0) {
						$(selBtnObj).removeClass("btn-danger").addClass("btn-primary").text("일반회원");
					} else if (modiMstate == 2) {
						$(selBtnObj).removeClass("btn-danger").addClass("btn-warning").text("카톡회원");
					} else {
						$(selBtnObj).removeClass("btn-primary").addClass("btn-danger").text("정지회원");
					}
					$("#changeMstateModal").modal('hide');
				},
				error: function(){
					alert("error");
				}
			});
			
		}

    	
    </script>
</body>

</html>