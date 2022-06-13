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

    <title>관리자-극장목록</title>

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
                        <h1 class="h3 mb-0 text-gray-800">관리자 극장목록 페이지 - AdminTheaterList.jsp</h1>
                    </div>
                    
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 bg-gray-900">
                            <h6 class="m-0 font-weight-bold text-white">극장목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class="bg-gray-700 text-white">
                                        	<th style="min-width:80x;">극장코드</th>
                                            <th style="min-width:70x;">이름</th>
                                            <th style="width:40%;">주소</th>
                                            <th style="min-width:60px;">전화번호</th>
                                            <th style="min-width:130px;"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${thList }" var="th">
	                                        <tr>
	                                            <td class="align-middle">${th.thcode }</td>
	                                            <td class="align-middle"><a href="#" class="btn p-0">${th.thname }</a></td>
	                                            <td class="align-middle">${th.thaddr }</td>
	                                            <td class="align-middle">${th.thtel }</td>
	                                            <th class="align-middle" id="mvstateBtn" style="text-align:center;">
	                                            	<button class="btn btn-info btn-icon-split px-1" onclick="theaterView('${th }')">상세정보</button>
		                                            	<c:choose>
	                                            		<c:when test="${th.thstate == 0 }">
			                                            	<button class="btn btn-danger btn-icon-split px-1" onclick="changeThstate(this, '${th.thcode }')">비활성화</button>
	                                            		</c:when>
	                                            		<c:otherwise>
			                                            	<button class="btn btn-primary btn-icon-split px-1" onclick="changeThstate(this, '${th.thcode }')">활성화</button>
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


   <div class="modal fade" id="thModiModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title font-weight-bold " id="thModi_modalLabel"></h6>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
	                <div class="modal-body ">
	                	<div class="row">
                            <div class="col-12">
                                <div class="h6 font-weight-bold text-gray-800">
	                                <div class="row">
	                                	<div class="col-6">
	                                		<label class="small">극장코드</label>
	                                		<input class="form-control" id="thModi_thcode" name="thcode" type="text" readonly="readonly">
	                                	</div>
	                                	<div class="col-6">
	                                		<label class="small">이름</label>
	                                		<input class="form-control" id="thModi_thname" name="thname" type="text" readonly="readonly">
	                                	</div>
		                        	</div>
                                	<label class="small">주소</label>
                                	<input class="form-control" id="thModi_thaddr" name="thaddr" type="text" readonly="readonly">
                                	<label class="small">전화번호</label>
                                	<input class="form-control" id="thModi_thtel" name="thtel" type="text" readonly="readonly">
	                        	</div>
	                        </div>
                        </div>
	                </div>
	                <div class="modal-footer">
                       	<button type="button" class="toggleBtn btn btn-sm btn-danger" onclick="modiOpen()">정보수정</button>
                        <button type="button" class="toggleBtn btn btn-sm btn-secondary d-none" onclick="modiClose()">취소</button> 
                        <button type="submit" class="toggleBtn btn btn-sm btn-danger d-none" onclick="thModi()">수정하기</button> 
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
		function changeThstate(btnObj, thcode){
			var btnText = $(btnObj).text();
			if (btnText == "비활성화") {
				var thstate = 1;
			} else {
				var thstate = 0;
			}
			console.log("변경할 thcode : " + thcode);
			console.log("변경할 thstate : " + thstate);
			$.ajax({
				type:"post",
				data:{"thcode":thcode, "thstate":thstate},
				url: "changeThstate",
				success: function(result){
					if (btnText == "비활성화") {
						$(btnObj).removeClass("btn-danger").addClass("btn-primary").text("활성화");
					} else {
						$(btnObj).removeClass("btn-primary").addClass("btn-danger").text("비활성화");
					}
				}
			});
		}
	</script>
	
	<script type="text/javascript">
		function theaterView(thInfo){
			console.log(thInfo);
			var row = thInfo.replaceAll(", ",",").split("(")[1].split(")")[0].split(",");
			console.log(row);

			var theaterData = {};
			for(var i = 0; i < row.length; i++){
				var key = row[i].split('=')[0];
				var val = row[i].split('=')[1];
				theaterData[key] = val;
			}
			
    		$("#thModi_thname").attr("readonly", "readonly");
    		$("#thModi_thaddr").attr("readonly", "readonly");
    		$("#thModi_thtel").attr("readonly", "readonly");
		
			$("#thModi_modalLabel").text("극장 상세정보");
			$("#thModi_thcode").val(theaterData.thcode);
			$("#thModi_thname").val(theaterData.thname);
			$("#thModi_thaddr").val(theaterData.thaddr);
			$("#thModi_thtel").val(theaterData.thtel);
			
			$("#thModiModal").modal('show');
		}
	</script>	

    <script type="text/javascript">
    	function modiOpen(){
    		$("#thModi_thname").removeAttr("readonly");
    		$("#thModi_thaddr").removeAttr("readonly");
    		$("#thModi_thtel").removeAttr("readonly");
    		var btn = $(".toggleBtn");
    		console.log(btn.length);
    		for(var i = 0; i < btn.length; i++){
    			btn.toggleClass("d-none");
    		}
    	}
    	
    	function modiClose(){
    		$("#thModi_thname").attr("readonly","readonly");
    		$("#thModi_thaddr").attr("readonly","readonly");
    		$("#thModi_thtel").attr("readonly","readonly");
    		var btn = $(".toggleBtn");
    		btn.toggleClass("d-none");
    	}
    	
    	function thModi(){
    		var thcode = $("#thModi_thcode").val();
    		var thname = $("#thModi_thname").val();
    		var thaddr = $("#thModi_thaddr").val();
    		var thtel = $("#thModi_thtel").val();
    		
    		$.ajax({
    			type: "get",
    			data: {"thcode":thcode, "thname":thname, "thaddr":thaddr, "thtel":thtel},
    			url: "adminThaterModiModal",
    			success: function(result){
    				if(result == 1){
    					location.href="${pageContext.request.contextPath }/adminTheaterList";
    				}
    			}
    		});
    		
    	}
    </script>
    
</body>

</html>